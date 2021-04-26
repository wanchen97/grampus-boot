package com.vdegree.grampus.admin.modules.system.config;

import com.vdegree.grampus.common.mybatis.handler.FieldFillHandler;
import com.vdegree.grampus.common.mybatis.interceptor.FieldFillInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: Mybatis配置类
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-26
 */
@Configuration
public class MybatisConfig {

	@Bean
	public FieldFillInterceptor fieldFillInterceptor(FieldFillHandler fieldFillHandler) {
		return new FieldFillInterceptor(fieldFillHandler);
	}
}
