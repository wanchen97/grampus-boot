package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dto.SysUserDTO;
import com.vdegree.grampus.admin.modules.system.security.enums.SuperAdminEnum;
import com.vdegree.grampus.admin.modules.system.security.redis.SystemUserDetailsRedis;
import com.vdegree.grampus.admin.modules.system.service.SysUserRoleService;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.common.core.utils.CollectionUtil;
import com.vdegree.grampus.common.core.utils.StringUtil;
import com.vdegree.grampus.common.mybatis.enums.DelFlagEnum;
import com.vdegree.grampus.admin.modules.system.dao.SysUserDao;
import com.vdegree.grampus.admin.modules.system.entity.SysUser;
import com.vdegree.grampus.admin.modules.system.service.SysUserService;
import com.vdegree.grampus.common.mybatis.service.impl.EnhancedBaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户表 服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:50:59
 */
@AllArgsConstructor
@Service("sysUserService")
public class SysUserServiceImpl extends EnhancedBaseServiceImpl<SysUserDao, SysUser, SysUserDTO> implements SysUserService {

	private final PasswordEncoder passwordEncoder;
	private final SysUserRoleService sysUserRoleService;
	private final SystemUserDetailsRedis systemUserDetailsRedis;

	@Override
	public SysUser getSysUserByUserNo(String userNo) {
		SysUser entity = new SysUser();
		entity.setUserNo(userNo);
		entity.setDelFlag(DelFlagEnum.NORMAL.getValue());
		return baseMapper.selectOne(entity);
	}

	@Override
	public void updatePassword(Long userId, String newPassword) {
		SysUser entity = new SysUser();
		entity.setId(userId);
		entity.setPassword(passwordEncoder.encode(newPassword));
		baseMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(SysUserDTO dto) {
		SysUser entity = BeanUtil.copy(dto, SysUser.class);
		String plainPwd = entity.getPassword();
		// 新建账号支持空密码
		if (StringUtil.isNotBlank(plainPwd)) {
			entity.setPassword(passwordEncoder.encode(plainPwd));
		}
		entity.setSuperAdmin(SuperAdminEnum.FALSE.getValue());
		baseMapper.insert(entity);
		sysUserRoleService.saveOrUpdate(entity.getId(), dto.getRoleIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void modifyById(SysUserDTO dto) {
		SysUser entity = BeanUtil.copy(dto, SysUser.class);
		SysUser sysUser = selectById(entity.getId());
		String userNo = sysUser.getUserNo();
		String plainPwd = entity.getPassword();
		// 新建账号支持空密码
		if (StringUtil.isNotBlank(plainPwd)) {
			entity.setPassword(passwordEncoder.encode(plainPwd));
		}
		entity.setSuperAdmin(SuperAdminEnum.FALSE.getValue());
		updateById(entity);
		if (CollectionUtil.isNotEmpty(dto.getRoleIdList())) {
			sysUserRoleService.saveOrUpdate(entity.getId(), dto.getRoleIdList());
		}
		systemUserDetailsRedis.removeSystemUserDetails(userNo);
	}
}