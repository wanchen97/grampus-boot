package com.vdegree.grampus.admin.modules.system.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

/**
 * Title: SpringMVC响应数据处理（Long类型转换为String类型、时间统一为时间戳）
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-20
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new ByteArrayHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		converters.add(new ResourceHttpMessageConverter());
		converters.add(new AllEncompassingFormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		converters.add(jackson2HttpMessageConverter());
	}

	@Bean
	public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter =
				new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		// 统一时间戳,忽略未知属性
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// Long类型转换为String类型(兼容JS长整数精度丢失问题)
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		objectMapper.registerModule(simpleModule);
		jackson2HttpMessageConverter.setObjectMapper(objectMapper);
		return jackson2HttpMessageConverter;
	}
}
