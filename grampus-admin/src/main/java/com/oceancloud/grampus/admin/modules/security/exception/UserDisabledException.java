package com.oceancloud.grampus.admin.modules.security.exception;

import com.oceancloud.grampus.admin.code.ErrorCode;
import com.oceancloud.grampus.framework.core.exception.ApiException;

/**
 * 用户被禁用异常
 *
 * @author Beck
 * @since 2020-12-16
 */
public class UserDisabledException extends ApiException {
	private static final long serialVersionUID = 1791940330757308184L;

	public UserDisabledException() {
		super(ErrorCode.Auth.USER_DISABLE_ERROR.getCode());
	}
}
