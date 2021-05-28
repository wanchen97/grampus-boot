package com.vdegree.grampus.common.log.aspect;

import com.vdegree.grampus.common.core.utils.ClassUtil;
import com.vdegree.grampus.common.core.utils.Exceptions;
import com.vdegree.grampus.common.core.utils.JSONUtil;
import com.vdegree.grampus.common.core.utils.chars.StringPool;
import com.vdegree.grampus.common.core.utils.spring.SpringContextHolder;
import com.vdegree.grampus.common.log.annotation.RequestLog;
import com.vdegree.grampus.common.log.event.LogEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * 请求日志AOP处理器 TODO 考虑发布订阅是否使用Redis实现
 *
 * @author Beck
 * @since 2021-05-27
 */
@Slf4j
@AllArgsConstructor
public class LogInterceptor implements MethodInterceptor {

	private final ApplicationContext applicationContext;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Environment environment = applicationContext.getEnvironment();
		// 应用名、注解、类、方法信息
		String applicationName = environment.getProperty("spring.application.name");
		RequestLog requestLog = invocation.getMethod().getAnnotation(RequestLog.class);
		String strClassName = invocation.getThis().getClass().getName();
		String strMethodName = invocation.getMethod().getName();
		log.info("[class]:{},[method]:{}", strClassName, strMethodName);
		LogEvent event = new LogEvent();
		event.setModule(applicationName);
		event.setDescription(requestLog.value());
		event.setClassMethod(strClassName + StringPool.HASH + strMethodName);
		event.setData(getPostJson(invocation));
		// 执行时间
		long startNs = System.nanoTime();
		try {
			Object result = invocation.proceed();
			// 耗时
			event.setCostTime(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs));
			event.setSuccessful(Boolean.TRUE);
			// 发送异步日志事件
			applicationContext.publishEvent(event);
			return result;
		} catch (Throwable e) {
			// 耗时
			event.setCostTime(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs));
			// 异常详情
			event.setExceptionDetail(Exceptions.getStackTraceAsString(e));
			event.setSuccessful(Boolean.FALSE);
			// 发送异步日志事件
			applicationContext.publishEvent(event);
			throw e;
		}
	}

	private static String getPostJson(MethodInvocation invocation) {
		Object[] args = invocation.getArguments();
		Method method = invocation.getMethod();
		// 一次请求只能有一个 request body
		Object requestBodyValue = null;
		for (int i = 0; i < args.length; i++) {
			// 读取方法参数
			MethodParameter methodParam = ClassUtil.getMethodParameter(method, i);
			RequestBody requestBody = methodParam.getParameterAnnotation(RequestBody.class);
			// 如果是body的json则是对象
			if (requestBody != null) {
				requestBodyValue = args[i];
				break;
			}
		}
		return requestBodyValue == null ? null : JSONUtil.writeValueAsString(requestBodyValue);
	}
}
