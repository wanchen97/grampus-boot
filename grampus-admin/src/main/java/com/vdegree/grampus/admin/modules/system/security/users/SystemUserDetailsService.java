package com.vdegree.grampus.admin.modules.system.security.users;

import com.vdegree.grampus.admin.modules.system.entity.SysUser;
import com.vdegree.grampus.admin.modules.system.security.enums.SuperAdminEnum;
import com.vdegree.grampus.admin.modules.system.enums.SysUserEnabledEnum;
import com.vdegree.grampus.admin.modules.system.security.exception.UserDisabledException;
import com.vdegree.grampus.admin.modules.system.security.exception.UserNotFoundException;
import com.vdegree.grampus.admin.modules.system.security.roles.SystemRoleService;
import com.vdegree.grampus.admin.modules.system.service.SysUserService;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * system user details service
 *
 * @author Beck
 * @date 2020-12-15
 */
@AllArgsConstructor
@Service
public class SystemUserDetailsService implements UserDetailsService {

	private final SysUserService sysUserService;
	private final SystemRoleService systemRoleService;

	@Override
	public UserDetails loadUserByUsername(String userNo) throws UsernameNotFoundException {
		// TODO use cache
		SysUser user = sysUserService.getSysUserByUserNo(userNo);

		// 用户不存在
		if (user == null) {
			throw new UserNotFoundException();
		}

		// 用户被禁用
		if (SysUserEnabledEnum.DISABLED.getValue().equals(user.getEnabled())) {
			throw new UserDisabledException();
		}

		return buildUserDetails(user);
	}

	public UserDetails buildUserDetails(SysUser user) {
		SystemUserDetails systemUserDetails = BeanUtil.copy(user, SystemUserDetails.class);
		boolean isSuperAdmin = SuperAdminEnum.TRUE.getValue().equals(systemUserDetails.getSuperAdmin());
		if (Boolean.TRUE.equals(isSuperAdmin)) {
			systemUserDetails.setPermissions(systemRoleService.getAllPermissions());
		} else {
			systemUserDetails.setPermissions(systemRoleService.getPermissions(user.getId()));
		}
		return systemUserDetails;
	}
}
