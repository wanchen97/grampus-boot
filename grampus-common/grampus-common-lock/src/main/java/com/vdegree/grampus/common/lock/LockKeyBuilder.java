package com.vdegree.grampus.common.lock;

import org.aopalliance.intercept.MethodInvocation;

/**
 * LockKeyBuilder
 *
 * @author Beck
 * @since 2021-01-29
 */
public interface LockKeyBuilder {

	/**
	 * 构建key
	 *
	 * @param invocation     invocation
	 * @param definitionKeys 定义
	 * @return key
	 */
	String buildKey(MethodInvocation invocation, String[] definitionKeys);
}
