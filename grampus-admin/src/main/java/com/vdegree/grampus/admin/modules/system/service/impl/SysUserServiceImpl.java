package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dto.SysUserDTO;
import com.vdegree.grampus.admin.modules.system.security.enums.SuperAdminEnum;
import com.vdegree.grampus.admin.modules.system.service.SysUserRoleService;
import com.vdegree.grampus.common.core.utils.BeanUtil;
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
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		entity.setSuperAdmin(SuperAdminEnum.FALSE.getValue());
		baseMapper.insert(entity);
		sysUserRoleService.saveOrUpdate(entity.getId(), dto.getRoleIdList());
	}
}