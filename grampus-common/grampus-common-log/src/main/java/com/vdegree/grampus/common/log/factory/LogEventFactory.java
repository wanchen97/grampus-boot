package com.vdegree.grampus.common.log.factory;

import com.vdegree.grampus.common.core.constant.Constant;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.common.core.utils.ClassUtil;
import com.vdegree.grampus.common.core.utils.JSONUtil;
import com.vdegree.grampus.common.core.utils.ObjectUtil;
import com.vdegree.grampus.common.core.utils.StringUtil;
import com.vdegree.grampus.common.core.utils.WebUtil;
import com.vdegree.grampus.common.core.utils.chars.CharPool;
import com.vdegree.grampus.common.core.utils.chars.StringPool;
import com.vdegree.grampus.common.log.event.LogEvent;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 系统日志构建工厂类
 *
 * @author Beck
 * @since 2021-05-28
 */
public class LogEventFactory {

	/**
	 * 构造 LogEvent
	 *
	 * @return LogEvent
	 */
	public static LogEvent buildLogEvent(MethodInvocation invocation) {
		LogEvent event = new LogEvent();
		HttpServletRequest request = WebUtil.getRequest();
		String requestMethod = request.getMethod();
		String requestUri = request.getRequestURI();
		event.setRequestMethod(requestMethod);
		event.setRequestUri(requestUri);
		// 请求信息 GET /api/test/xx
		String requestInfo = requestMethod + StringPool.SPACE + requestUri;
		// paramMap
		Map<String, String[]> paraMap = request.getParameterMap();
		if (ObjectUtil.isEmpty(paraMap)) {
			event.setRequestParam(requestInfo);
		} else {
			StringBuilder builder = new StringBuilder(requestInfo).append(CharPool.QUESTION_MARK);
			paraMap.forEach((key, values) -> {
				builder.append(key).append(CharPool.EQUALS);
				if ("password".equalsIgnoreCase(key)) {
					builder.append("******");
				} else {
					builder.append(StringUtil.join(values));
				}
				builder.append(CharPool.AMPERSAND);
			});
			builder.deleteCharAt(builder.length() - 1);
			event.setRequestParam(builder.toString());
		}
		// 获取请求 ip 和 ua
		event.setRequestIp(WebUtil.getIP());
		event.setAuthorization(request.getHeader(Constant.AUTHORIZATION_HEADER));
		event.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
		// 设置post json数据
		event.setRequestBody(getPostJson(invocation));
		return event;
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
		Map<String, Object> requestBodyMap = BeanUtil.toMap(requestBodyValue);
		if (requestBodyMap.containsKey("password")) {
			requestBodyMap.put("password", "******");
		}
		return requestBodyValue == null ? null : JSONUtil.writeValueAsString(requestBodyValue);
	}
}