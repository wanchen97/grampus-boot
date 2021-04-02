package com.vdegree.grampus.common.core.exception;

/**
 * Title: BaseException
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1525116257471128717L;

	protected String code;

	public BaseException() {
		super();
	}

	public BaseException(String code) {
		super();
		this.code = code;
	}

	public BaseException(String code, String message) {
		super(message);
		this.code = code;
	}

	public BaseException(String code, String message, Throwable e) {
		super(message, e);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
