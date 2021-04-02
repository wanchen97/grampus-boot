package com.vdegree.grampus.common.auth.exception;

import com.vdegree.grampus.common.core.exception.BaseException;

/**
 * Exception to be thrown if authorization is failed.
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
public class AccessException extends BaseException {

	private static final long serialVersionUID = -2926344920552803270L;

	public AccessException() {

	}

	public AccessException(String code) {
		super();
		this.code = code;
	}

}
