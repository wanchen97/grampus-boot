package com.oceancloud.grampus.admin.modules.security.exception;

import com.oceancloud.grampus.admin.code.ErrorCode;
import com.oceancloud.grampus.framework.core.exception.ApiException;

/**
 * 用户密码错误异常
 *
 * @author Beck
 * @since 2020-12-16
 */
public class UserPasswordErrorException extends ApiException {
	private static final long serialVersionUID = 8127084390337697670L;

	public UserPasswordErrorException() {
		super(ErrorCode.Auth.USER_PASSWORD_ERROR.getCode(), ErrorCode.Auth.USER_PASSWORD_ERROR.getMsg());
	}
}
