package com.oceancloud.grampus.admin.modules.security.exception;

import com.oceancloud.grampus.admin.code.ErrorCode;
import com.oceancloud.grampus.framework.core.exception.ApiException;

/**
 * 用户不存在异常
 *
 * @author Beck
 * @since 2020-12-16
 */
public class UserNotFoundException extends ApiException {
	private static final long serialVersionUID = 5186572331502903237L;

	public UserNotFoundException() {
		super(ErrorCode.Auth.USER_NOT_EXISTED.getCode(), ErrorCode.Auth.USER_NOT_EXISTED.getMsg());
	}
}
