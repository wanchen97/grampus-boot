package com.vdegree.grampus.admin.modules.system.security.exception;

import com.vdegree.grampus.admin.modules.system.code.ErrorCode;
import com.vdegree.grampus.common.core.exception.BaseException;

/**
 * TokenExpiredException
 *
 * @author Beck
 * @since 2021-05-07
 */
public class TokenExpiredException extends BaseException {
	private static final long serialVersionUID = -7284332526504876630L;

	public TokenExpiredException() {
		super(ErrorCode.System.TOKEN_EXPIRED_ERROR.getCode());
	}

	public TokenExpiredException(String msg) {
		super(ErrorCode.System.TOKEN_EXPIRED_ERROR.getCode(), msg);
	}
}
