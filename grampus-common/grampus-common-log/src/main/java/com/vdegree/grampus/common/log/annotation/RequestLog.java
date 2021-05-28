package com.vdegree.grampus.common.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求日志注解
 *
 * @author Beck
 * @since 2021-05-27
 */
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RequestLog {

	/**
	 * @return 业务模块
	 */
	String module() default "";

	/**
	 * @return 描述
	 */
	String value();

}
