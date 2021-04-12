package com.vdegree.grampus.common.lock.aspect;

import com.vdegree.grampus.common.lock.LockInfo;
import com.vdegree.grampus.common.lock.LockKeyBuilder;
import com.vdegree.grampus.common.lock.LockTemplate;
import com.vdegree.grampus.common.lock.annotation.DistributedLock;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 分布式锁AOP处理器
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-29
 */
@Slf4j
@AllArgsConstructor
public class LockInterceptor implements MethodInterceptor {

	private final LockTemplate lockTemplate;

	private final LockKeyBuilder lockKeyBuilder;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		LockInfo lockInfo = null;
		try {
			DistributedLock distributedLock = invocation.getMethod().getAnnotation(DistributedLock.class);
			String key = lockKeyBuilder.buildKey(invocation, distributedLock.keys());
			lockInfo = lockTemplate.lock(key, distributedLock.leaseTime(), distributedLock.waitTime(), distributedLock.strategy());
			if (lockInfo != null) {
				return invocation.proceed();
			}
			return null;
		} finally {
			if (lockInfo != null) {
				final boolean releaseLock = lockTemplate.releaseLock(lockInfo);
				if (!releaseLock) {
					log.error("releaseLock fail,lockKey={},lockValue={}", lockInfo.getLockKey(),
							lockInfo.getLockValue());
				}
			}
		}
	}
}
