package com.vdegree.grampus.admin.modules.system.config;

import com.vdegree.grampus.admin.modules.system.security.utils.SecurityUtils;
import com.vdegree.grampus.common.mybatis.annotation.FieldFill;
import com.vdegree.grampus.common.mybatis.annotation.TableField;
import com.vdegree.grampus.common.mybatis.handler.FieldFillHandler;
import com.vdegree.grampus.common.mybatis.interceptor.FieldFillInterceptor;
import org.apache.ibatis.mapping.SqlCommandType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;

/**
 * Title: 字段填充处理器
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-26
 */
@Configuration
public class MybatisConfig {
	private final static String CREATE_BY = "createBy";
	private final static String CREATE_DATE = "createDate";
	private final static String UPDATE_BY = "updateBy";
	private final static String UPDATE_DATE = "updateDate";

	@Bean
	public FieldFillInterceptor fieldFillInterceptor(FieldFillHandler fieldFillHandler) {
		return new FieldFillInterceptor(fieldFillHandler);
	}

	@Bean
	public FieldFillHandler fieldFillHandler() {
		return (SqlCommandType sqlCommandType, TableField tableField, Object paramObj, Field field) -> {
			Long currentUserId = Objects.requireNonNull(SecurityUtils.getUserDetails()).getId();
			Date currentDate = new Date();
			if (SqlCommandType.INSERT.equals(sqlCommandType)) {
				// INSERT SQL
				if (FieldFill.INSERT.equals(tableField.fill())
						|| FieldFill.INSERT_UPDATE.equals(tableField.fill())) {
					if (CREATE_BY.equals(field.getName())) {
						field.set(paramObj, currentUserId);
					} else if (CREATE_DATE.equals(field.getName())) {
						field.set(paramObj, currentDate);
					} else if (UPDATE_BY.equals(field.getName())) {
						field.set(paramObj, currentUserId);
					} else if (UPDATE_DATE.equals(field.getName())) {
						field.set(paramObj, currentDate);
					}
				}
			} else if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
				// UPDATE SQL
				if (FieldFill.UPDATE.equals(tableField.fill())
						|| FieldFill.INSERT_UPDATE.equals(tableField.fill())) {
					if (UPDATE_BY.equals(field.getName())) {
						field.set(paramObj, currentUserId);
					} else if (UPDATE_DATE.equals(field.getName())) {
						field.set(paramObj, currentDate);
					}
				}
			}
		};
	}
}
