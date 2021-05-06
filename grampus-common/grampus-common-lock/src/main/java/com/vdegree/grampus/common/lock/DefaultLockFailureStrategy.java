package com.vdegree.grampus.common.lock;

import com.vdegree.grampus.common.lock.exception.LockFailureException;
import lombok.extern.slf4j.Slf4j;

/**
 * DefaultLockFailureStrategy
 *
 * @author Beck
 * @date 2021-01-29
 */
@Slf4j
public class DefaultLockFailureStrategy implements LockFailureStrategy {

	@Override
	public void onLockFailure(String key, long waitTime, int lockCount) {
		log.error("thread:{} lock fail,key:{} waitTime:{}ms", Thread.currentThread().getName(), key,
				waitTime);
		throw new LockFailureException("request failed,please retry it.");
	}
}
