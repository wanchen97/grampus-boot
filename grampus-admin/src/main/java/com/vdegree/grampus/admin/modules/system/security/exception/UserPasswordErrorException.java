package com.vdegree.grampus.admin.modules.system.security.exception;

import com.vdegree.grampus.admin.modules.system.code.ErrorCode;
import com.vdegree.grampus.common.core.exception.BaseException;

/**
 * 用户密码错误异常
 *
 * @author Beck
 * @since 2020-12-16
 */
public class UserPasswordErrorException extends BaseException {
	private static final long serialVersionUID = 8127084390337697670L;

	public UserPasswordErrorException() {
		super(ErrorCode.System.USER_PASSWORD_ERROR.getCode());
	}
}
