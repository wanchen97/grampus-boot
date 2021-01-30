package com.vdegree.grampus.common.lock.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * redisson 重入锁
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-29
 */
@Slf4j
@RequiredArgsConstructor
public class RedissonLockStrategy extends AbstractLockStrategy<RLock> implements LockStrategy<RLock> {

	private final RedissonClient redissonClient;

	@Override
	public RLock lock(String lockKey, String lockValue, long expire, long waitTime) {
		try {
			final RLock lockInstance = redissonClient.getLock(lockKey);
			final boolean locked = lockInstance.tryLock(waitTime, expire, TimeUnit.MILLISECONDS);
			return obtainLockInstance(locked, lockInstance);
		} catch (InterruptedException e) {
			return null;
		}
	}

	@Override
	public boolean releaseLock(String lockKey, String lockValue, RLock lockInstance) {
		if (lockInstance.isHeldByCurrentThread()) {
			try {
				return lockInstance.forceUnlockAsync().get();
			} catch (ExecutionException | InterruptedException e) {
				return false;
			}
		}
		return false;
	}

}
