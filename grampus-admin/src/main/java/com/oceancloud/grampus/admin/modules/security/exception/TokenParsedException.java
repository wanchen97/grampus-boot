package com.oceancloud.grampus.admin.modules.security.exception;

import com.oceancloud.grampus.admin.code.ErrorCode;
import com.oceancloud.grampus.framework.core.exception.ApiException;

/**
 * Token解析失败异常
 *
 * @author Beck
 * @since 2021-05-07
 */
public class TokenParsedException extends ApiException {
	private static final long serialVersionUID = 985062659360376840L;

	public TokenParsedException() {
		super(ErrorCode.Auth.TOKEN_PARSED_ERROR.getCode());
	}

	public TokenParsedException(String msg) {
		super(ErrorCode.Auth.TOKEN_PARSED_ERROR.getCode(), msg);
	}
}
