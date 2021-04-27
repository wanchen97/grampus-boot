package com.vdegree.grampus.common.mybatis.interceptor;

import com.vdegree.grampus.common.mybatis.annotation.TableField;
import com.vdegree.grampus.common.mybatis.handler.FieldFillHandler;
import com.vdegree.grampus.common.mybatis.utils.ReflectionKit;
import lombok.AllArgsConstructor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Title: 字段填充插件
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-26
 */
@AllArgsConstructor
@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
public class FieldFillInterceptor implements Interceptor {

	private final FieldFillHandler fieldFillHandler;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		// 获取 SQL 命令
		SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
		// 获取 查询的参数的实体对象
		Object paramObj = invocation.getArgs()[1];
		// 获取 实体类的所有私有变量
		List<Field> declaredFields = ReflectionKit.getFieldList(paramObj.getClass());
		// 获取 标注TableField的所有私有变量
		List<Field> tableFields = declaredFields.stream()
				.filter(field -> field.isAnnotationPresent(TableField.class))
				.collect(Collectors.toList());
		fieldFillHandler.fill(new TableFieldObject(sqlCommandType, tableFields, paramObj));
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		}
		return target;
	}

	@Override
	public void setProperties(Properties properties) {

	}
}
