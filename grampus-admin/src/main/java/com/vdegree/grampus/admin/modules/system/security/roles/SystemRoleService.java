package com.vdegree.grampus.admin.modules.system.security.roles;

import com.google.common.base.Joiner;
import com.vdegree.grampus.admin.modules.system.security.roles.dao.SystemRoleDao;
import com.vdegree.grampus.common.core.utils.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Title: system role service
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-15
 */
@Service
@AllArgsConstructor
public class SystemRoleService {

	private final SystemRoleDao systemRoleDao;

	/**
	 * 获取用户所有权限标识
	 *
	 * @param userId 用户ID
	 * @return 权限标识
	 */
	public String getPermissions(Long userId) {
		Set<String> permissionSet = systemRoleDao.getPermissions(userId);
		return Joiner.on(",").join(permissionSet.stream().filter(perm -> Objects.nonNull(perm)
				&& StringUtil.isNotBlank(perm)).collect(Collectors.toSet()));
	}

	/**
	 * 获取所有权限标识
	 *
	 * @return 权限标识
	 */
	public String getAllPermissions() {
		Set<String> permissionSet = systemRoleDao.getAllPermissions();
		return Joiner.on(",").join(permissionSet.stream().filter(perm -> Objects.nonNull(perm)
				&& StringUtil.isNotBlank(perm)).collect(Collectors.toSet()));
	}
}
