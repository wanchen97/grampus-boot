package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dto.SysUserDTO;
import com.vdegree.grampus.common.mybatis.enums.DelFlagEnum;
import com.vdegree.grampus.admin.modules.system.dao.SysUserDao;
import com.vdegree.grampus.admin.modules.system.entity.SysUser;
import com.vdegree.grampus.admin.modules.system.service.SysUserService;
import com.vdegree.grampus.common.mybatis.service.impl.EnhancedBaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}