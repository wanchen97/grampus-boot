package com.vdegree.grampus.common.mybatis.handler;

import com.vdegree.grampus.common.mybatis.annotation.TableField;
import org.apache.ibatis.mapping.SqlCommandType;

import java.lang.reflect.Field;

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
	 * @param tableField     当前变量的TableField注解
	 * @param paramObj       查询的参数对象
	 * @param field          当前字段字段
	 */
	void fillField(SqlCommandType sqlCommandType, TableField tableField, Object paramObj, Field field) throws IllegalAccessException;
}
