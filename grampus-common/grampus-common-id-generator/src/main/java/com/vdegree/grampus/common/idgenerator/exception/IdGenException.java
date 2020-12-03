package com.vdegree.grampus.common.idgenerator.exception;

import java.io.Serializable;

/**
 * Title: ID生成器异常
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-03
 */
public class IdGenException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -6648147134838012009L;

	public IdGenException(String message) {
		super(message);
	}

	public IdGenException(Throwable cause) {
		super(cause);
	}
}
