package com.oceancloud.grampus.admin.modules.system.security.users;

import com.oceancloud.grampus.admin.modules.system.entity.SysUser;
import com.oceancloud.grampus.admin.modules.system.security.enums.SuperAdminEnum;
import com.oceancloud.grampus.admin.modules.system.enums.SysUserStatusEnum;
import com.oceancloud.grampus.admin.modules.system.security.exception.UserDisabledException;
import com.oceancloud.grampus.admin.modules.system.security.exception.UserNotFoundException;
import com.oceancloud.grampus.admin.modules.system.security.redis.SystemUserDetailsRedis;
import com.oceancloud.grampus.admin.modules.system.security.roles.SystemRoleService;
import com.oceancloud.grampus.admin.modules.system.service.SysUserService;
import com.oceancloud.grampus.common.core.utils.BeanUtil;
import com.oceancloud.grampus.common.core.utils.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统用户详情
 *
 * @author Beck
 * @since 2020-12-15
 */
@AllArgsConstructor
@Service
public class SystemUserDetailsService implements UserDetailsService {

	private final SysUserService sysUserService;
	private final SystemRoleService systemRoleService;
	private final SystemUserDetailsRedis systemUserDetailsRedis;

	@Override
	public UserDetails loadUserByUsername(String userNo) throws UsernameNotFoundException {
		// 查询用户详情
		SystemUserDetails userDetails = systemUserDetailsRedis.getSystemUserDetails(userNo);
		if (userDetails != null && StringUtil.isNotBlank(userDetails.getUserNo())) {
			// 查询用户权限标识
			if (SuperAdminEnum.TRUE.getValue().equals(userDetails.getSuperAdmin())) {
				// TODO 考虑是否需要优化超管的权限标识获取
				userDetails.setPermissions(systemRoleService.getAllPermissions());
			} else {
				String permissions = systemRoleService.getPermissionsByRoleIds(userDetails.getRoleIds());
				userDetails.setPermissions(permissions);
			}
			return userDetails;
		}
		SysUser user = sysUserService.getSysUserByUserNo(userNo);

		// 用户不存在
		if (user == null) {
			throw new UserNotFoundException();
		}

		// 用户被禁用
		if (SysUserStatusEnum.DISABLED.getValue().equals(user.getStatus())) {
			throw new UserDisabledException();
		}

		// 缓存系统用户详情
		userDetails = buildUserDetails(user);
		systemUserDetailsRedis.saveSystemUserDetails(userDetails);
		return userDetails;
	}

	public SystemUserDetails buildUserDetails(SysUser user) {
		SystemUserDetails systemUserDetails = BeanUtil.copyWithConvert(user, SystemUserDetails.class);
		List<Long> roleIds = systemRoleService.getRoleIds(user.getId());
		boolean isSuperAdmin = SuperAdminEnum.TRUE.getValue().equals(systemUserDetails.getSuperAdmin());
		systemUserDetails.setRoleIds(roleIds);
		if (Boolean.TRUE.equals(isSuperAdmin)) {
			systemUserDetails.setPermissions(systemRoleService.getAllPermissions());
		} else {
			systemUserDetails.setPermissions(systemRoleService.getPermissions(user.getId()));
		}
		return systemUserDetails;
	}
}
