package com.vdegree.grampus.common.lock.exception;

/**
 * 加锁失败异常
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-29
 */
public class LockFailureException extends LockException {

	public LockFailureException() {

	}

	public LockFailureException(String message) {
		super(message);
	}
}
