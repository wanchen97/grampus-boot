package com.vdegree.grampus.admin.modules.system.security.exception;

import com.vdegree.grampus.common.core.exception.BaseException;

/**
 * Title: 用户密码错误异常
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-16
 */
public class UserPasswordErrorException extends BaseException {
	private static final long serialVersionUID = 8127084390337697670L;

	public UserPasswordErrorException() {
		super(SystemSecurityErrorCode.USER_PASSWORD_ERROR);
	}
}