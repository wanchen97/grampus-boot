package com.vdegree.grampus.common.lock;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 分布式锁Key生成器
 *
 * @author Beck
 * @since 2021-01-29
 */
public class DefaultLockKeyBuilder implements LockKeyBuilder {

	private static final String DEFAULT_KEY_PREFIX = "distributed_lock";

	private static final ParameterNameDiscoverer NAME_DISCOVERER = new DefaultParameterNameDiscoverer();

	private static final ExpressionParser PARSER = new SpelExpressionParser();

	@Override
	public String buildKey(MethodInvocation invocation, String[] definitionKeys) {
		StringBuilder sb = new StringBuilder(getKeyPrefix());
		Method method = invocation.getMethod();
//		sb.append(":").append(method.getDeclaringClass().getName()).append(".").append(method.getName()).append("#");
		sb.append(":");
		if (definitionKeys.length > 1 || !"".equals(definitionKeys[0])) {
			sb.append(getSpelDefinitionKey(definitionKeys, method, invocation.getArguments()));
		}
		return sb.toString();
	}

	protected String getSpelDefinitionKey(String[] definitionKeys, Method method, Object[] parameterValues) {
		EvaluationContext context = new MethodBasedEvaluationContext(null, method, parameterValues, NAME_DISCOVERER);
		List<String> definitionKeyList = new ArrayList<>(definitionKeys.length);
		for (String definitionKey : definitionKeys) {
			if (definitionKey != null && !definitionKey.isEmpty()) {
				String key = PARSER.parseExpression(definitionKey).getValue(context).toString();
				definitionKeyList.add(key);
			}
		}
		return StringUtils.collectionToDelimitedString(definitionKeyList, ".", "", "");
	}

	protected String getKeyPrefix() {
		return DEFAULT_KEY_PREFIX;
	}

}
