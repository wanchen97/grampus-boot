package com.vdegree.grampus.common.lock;

/**
 * 加锁失败策略
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-29
 */
public interface LockFailureStrategy {

	/**
	 * 锁失败事件
	 *
	 * @param lockKey   加锁key
	 * @param waitTime  尝试获取锁等待时间(ms)
	 * @param lockCount 尝试获取锁的次数
	 */
	void onLockFailure(String lockKey, long waitTime, int lockCount);

}
