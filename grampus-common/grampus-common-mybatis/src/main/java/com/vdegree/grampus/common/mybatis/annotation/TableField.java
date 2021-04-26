package com.vdegree.grampus.common.mybatis.annotation;

import java.lang.annotation.*;

/**
 * Title: 表数据自动填充注解
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-21
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TableField {

	/**
	 * 字段自动填充策略
	 */
	FieldFill fill() default FieldFill.DEFAULT;
}
