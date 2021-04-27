package com.vdegree.grampus.common.mybatis.handler;

import com.vdegree.grampus.common.mybatis.interceptor.TableFieldObject;

/**
 * Title: 字段填充处理器
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-26
 */
@FunctionalInterface
public interface FieldFillHandler {

	/**
	 * 填充字段
	 *
	 * @param tableFieldObject TableField注解标注的实体对象信息
	 */
	void fill(TableFieldObject tableFieldObject);
}
