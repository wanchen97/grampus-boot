package com.vdegree.grampus.common.lock.strategy;

/**
 * 抽象分布式锁策略
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-29
 */
public abstract class AbstractLockStrategy<T> {

	protected T obtainLockInstance(boolean locked, T lockInstance) {
		return locked ? lockInstance : null;
	}

}