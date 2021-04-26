package com.vdegree.grampus.common.mybatis.handler;

import org.apache.ibatis.mapping.SqlCommandType;

import java.lang.reflect.Field;
import java.util.List;

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
	 * @param sqlCommandType SQL类型(INSERT UPDATE DELETE...)
	 * @param fields         查询参数中标有TableField注解的字段
	 * @param paramObj       查询参数实体
	 */
	void fill(SqlCommandType sqlCommandType, List<Field> fields, Object paramObj) throws IllegalAccessException;
}
