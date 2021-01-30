package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.common.lock.annotation.DistributedLock;
import com.vdegree.grampus.common.lock.strategy.RedisTemplateLockStrategy;
import com.vdegree.grampus.common.lock.strategy.RedissonLockStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Title:
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-29
 */
@Slf4j
@Service
public class DemoService {

	@DistributedLock(keys = {"#userId", " #userId2", "#userId3"}, waitTime = 200, leaseTime = 40000, strategy = RedissonLockStrategy.class)
	public void testLock(String userId, String userId2, String userId3) throws InterruptedException {
		Thread.sleep(500);
		log.info("{} time:{}", Thread.currentThread().getName(), System.currentTimeMillis());
	}
}
