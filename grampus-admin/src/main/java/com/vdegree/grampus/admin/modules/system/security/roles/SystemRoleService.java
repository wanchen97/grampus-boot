package com.vdegree.grampus.admin.modules.system.security.roles;

import com.google.common.base.Joiner;
import com.vdegree.grampus.admin.modules.system.security.roles.dao.SystemRoleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Title: system role service
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-15
 */
@Service
@RequiredArgsConstructor
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
		return Joiner.on(",").join(permissionSet);
	}
}
