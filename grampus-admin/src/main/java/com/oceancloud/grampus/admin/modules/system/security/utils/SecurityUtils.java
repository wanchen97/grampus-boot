package com.oceancloud.grampus.admin.modules.system.security.utils;

import com.oceancloud.grampus.admin.modules.system.security.users.SystemUserDetails;
import com.oceancloud.grampus.common.core.utils.WebUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Security工具.
 *
 * @author Beck
 * @since 2020-12-5
 */
public class SecurityUtils {
	/**
	 * 角色前缀
	 */
	public static final String SECURITY_ROLE_PREFIX = "ROLE_";

	/**
	 * 获取Authentication
	 */
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取用户
	 */
	public static SystemUserDetails getUserDetails(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof SystemUserDetails) {
			return ((SystemUserDetails) principal);
		}
		return null;
	}

	/**
	 * 获取用户
	 */
	public static SystemUserDetails getUserDetails() {
		Authentication authentication = getAuthentication();
		if (authentication == null) {
			return null;
		}
		return getUserDetails(authentication);
	}

	/**
	 * 获取用户名
	 */
	public static String getUserName() {
		SystemUserDetails systemUserDetails = getUserDetails();
		return systemUserDetails == null ? null : systemUserDetails.getUsername();
	}

	/**
	 * 退出
	 */
	public static void logout() {
		HttpServletRequest request = WebUtil.getRequest();
		new SecurityContextLogoutHandler().logout(request, null, null);
	}
}
