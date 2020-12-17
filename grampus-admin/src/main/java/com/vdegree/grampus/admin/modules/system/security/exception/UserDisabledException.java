package com.vdegree.grampus.admin.modules.system.security.exception;

import com.vdegree.grampus.common.core.exception.BaseException;

/**
 * Title: 用户被禁用异常
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-16
 */
public class UserDisabledException extends BaseException {
	private static final long serialVersionUID = 1791940330757308184L;

	public UserDisabledException() {
		super(SystemSecurityErrorCode.USER_DISABLE_ERROR);
	}
}
