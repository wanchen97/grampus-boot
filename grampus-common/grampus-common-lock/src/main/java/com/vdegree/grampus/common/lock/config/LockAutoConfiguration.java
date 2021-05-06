package com.vdegree.grampus.common.lock.config;

import com.vdegree.grampus.common.lock.DefaultLockFailureStrategy;
import com.vdegree.grampus.common.lock.DefaultLockKeyBuilder;
import com.vdegree.grampus.common.lock.LockFailureStrategy;
import com.vdegree.grampus.common.lock.LockKeyBuilder;
import com.vdegree.grampus.common.lock.LockTemplate;
import com.vdegree.grampus.common.lock.aspect.LockAnnotationAdvisor;
import com.vdegree.grampus.common.lock.aspect.LockInterceptor;
import com.vdegree.grampus.common.lock.properties.DistributedLockProperties;
import com.vdegree.grampus.common.lock.strategy.LockStrategy;
import com.vdegree.grampus.common.lock.strategy.RedisTemplateLockStrategy;
//import com.vdegree.grampus.common.lock.strategy.RedissonLockStrategy;
import lombok.AllArgsConstructor;
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * LockAutoConfiguration
 *
 * @author Beck
 * @date 2021-01-29
 */
@Configuration
@EnableConfigurationProperties(DistributedLockProperties.class)
@AllArgsConstructor
public class LockAutoConfiguration {

	private final DistributedLockProperties properties;

	@SuppressWarnings("rawtypes")
	@Bean
	@ConditionalOnMissingBean
	public LockTemplate lockTemplate(LockFailureStrategy lockFailureStrategy, List<LockStrategy> strategies) {
		LockTemplate lockTemplate = new LockTemplate();
		lockTemplate.setProperties(properties);
		lockTemplate.setLockFailureStrategy(lockFailureStrategy);
		lockTemplate.setStrategies(strategies);
		return lockTemplate;
	}

	@Bean
	@ConditionalOnMissingBean
	public LockKeyBuilder lockKeyBuilder() {
		return new DefaultLockKeyBuilder();
	}

	@Bean
	@ConditionalOnMissingBean
	public LockFailureStrategy lockFailureStrategy() {
		return new DefaultLockFailureStrategy();
	}

	@Bean
	@ConditionalOnMissingBean
	public LockInterceptor lockInterceptor(LockTemplate lockTemplate, LockKeyBuilder lockKeyBuilder) {
		return new LockInterceptor(lockTemplate, lockKeyBuilder);
	}

	@Bean
	@ConditionalOnMissingBean
	public LockAnnotationAdvisor lockAnnotationAdvisor(LockInterceptor lockInterceptor) {
		return new LockAnnotationAdvisor(lockInterceptor, Ordered.HIGHEST_PRECEDENCE);
	}

	@Configuration
	@ConditionalOnClass(RedisOperations.class)
	static class RedisStrategyAutoConfiguration {
		@Bean
		@Order(200)
		public RedisTemplateLockStrategy redisTemplateLockStrategy(StringRedisTemplate stringRedisTemplate) {
			return new RedisTemplateLockStrategy(stringRedisTemplate);
		}
	}

//	@Configuration
//	@ConditionalOnClass(Redisson.class)
//	static class RedissonStrategyAutoConfiguration {
//		@Bean
//		@Order(100)
//		public RedissonLockStrategy redissonLockStrategy(RedissonClient redissonClient) {
//			return new RedissonLockStrategy(redissonClient);
//		}
//	}
}
