package com.vdegree.grampus.common.lock.annotation;

import com.vdegree.grampus.common.lock.strategy.LockStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 分布式锁注解
 *
 * @author Beck
 * @since 2021-01-29
 */
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DistributedLock {

	/**
	 * @return lock 执行器
	 */
	Class<? extends LockStrategy> strategy() default LockStrategy.class;

	/**
	 * @return KEY 默认包名+方法名
	 */
	String[] keys() default "";

	/**
	 * @return 锁过期时间 单位：毫秒
	 * <pre>
	 *     锁过期时间一定是要长于业务的执行时间. 未设置则为默认时间3秒
	 * </pre>
	 */
	long leaseTime() default 0;

	/**
	 * @return 尝试获取锁等待时间（在该时间获取锁失败，则自旋重试，重试间隔默认100ms） 单位：毫秒
	 * <pre>
	 *     结合业务,建议该时间不宜设置过长,特别在并发高的情况下. 未设置则为默认时间3秒
	 * </pre>
	 */
	long waitTime() default 0;

}
