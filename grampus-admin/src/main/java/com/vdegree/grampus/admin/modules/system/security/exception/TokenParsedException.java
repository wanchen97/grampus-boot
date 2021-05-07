package com.vdegree.grampus.admin.modules.system.security.exception;

import com.vdegree.grampus.admin.modules.system.code.ErrorCode;
import com.vdegree.grampus.common.core.exception.BaseException;

/**
 * TokenParseException
 *
 * @author Beck
 * @since 2021-05-07
 */
public class TokenParsedException extends BaseException {
	private static final long serialVersionUID = 985062659360376840L;

	public TokenParsedException() {
		super(ErrorCode.System.TOKEN_PARSED_ERROR.getCode());
	}

	public TokenParsedException(String msg) {
		super(ErrorCode.System.TOKEN_PARSED_ERROR.getCode(), msg);
	}
}
