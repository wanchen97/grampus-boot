package com.vdegree.grampus.admin.modules.system.security.exception;

import com.vdegree.grampus.common.core.exception.BaseException;

/**
 * 用户不存在异常
 *
 * @author Beck
 * @since 2020-12-16
 */
public class UserNotFoundException extends BaseException {
	private static final long serialVersionUID = 5186572331502903237L;

	public UserNotFoundException() {
		super(SystemSecurityErrorCode.USER_NOT_EXISTED);
	}
}
