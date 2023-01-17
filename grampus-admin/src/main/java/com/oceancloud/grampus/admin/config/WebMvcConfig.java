package com.oceancloud.grampus.admin.config;

import com.oceancloud.grampus.framework.core.utils.date.DatePattern;
import com.oceancloud.grampus.framework.core.utils.date.DateUtil;
import com.oceancloud.grampus.framework.core.utils.jackson.convert.EnhancedMappingJackson2HttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.beans.PropertyEditorSupport;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * SpringMVC入参/响应数据处理
 *
 * @author Beck
 * @since 2021-04-20
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	// ~ ======================= 入参数据处理（时间支持时间戳以及其他格式） ===============================

	@Bean
	public ConfigurableWebBindingInitializer configurableWebBindingInitializer(FormattingConversionService mvcConversionService, Validator mvcValidator) {
		ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
		initializer.setConversionService(mvcConversionService);
		initializer.setValidator(mvcValidator);
		// 装配自定义属性编辑器
		initializer.setPropertyEditorRegistrar(propertyEditorRegistry -> {
			// Date 类型转换
			propertyEditorRegistry.registerCustomEditor(Date.class, new PropertyEditorSupport() {
				@Override
				public void setAsText(String text) {
					setValue(parse(text));
				}
			});
			// LocalDate 类型转换
			propertyEditorRegistry.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
				@Override
				public void setAsText(String text) {
					setValue(parse(text).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				}
			});
			// LocalDateTime 类型转换
			propertyEditorRegistry.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
				@Override
				public void setAsText(String text) {
					setValue(parse(text).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
				}
			});
		});
		return initializer;
	}

	private static final String[] PARSE_PATTERNS = {
			"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
			"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	private static final DateTimeFormatter[] DATE_TIME_FORMATTERS = {
			DatePattern.JDK_DATETIME_FORMAT,
			DatePattern.NORM_DATETIME_FORMAT,
			DatePattern.UTC_FORMAT,
			DatePattern.NORM_DATETIME_MS_FORMAT,
			DatePattern.NORM_DATE_FORMAT,
			DatePattern.NORM_DATETIME_MINUTE_FORMAT
	};

	/**
	 * 日期字符串解析 TODO DateUtil存在缺陷，无法使用yyyy-MM-dd解析2022-12-9
	 */
	private static Date parse(Object dateTimeString) {
		if (dateTimeString == null) {
			return null;
		}
		try {
			long timestamp = Long.parseLong(String.valueOf(dateTimeString));
			return new Date(timestamp);
		} catch (Exception ignore) {
			// do nothing
		}
		for (DateTimeFormatter formatter : DATE_TIME_FORMATTERS) {
			try {
				return DateUtil.parse(dateTimeString.toString(), formatter);
			} catch (Exception ignore) {
				// do nothing
			}
		}
		for (String parsePattern : PARSE_PATTERNS) {
			try {
				return DateUtil.parse(dateTimeString.toString(), parsePattern);
			} catch (Exception ignore) {
				// do nothing
			}
		}
		return null;
	}

	// ~ ======================= 响应数据处理（Long类型转换为String类型、时间统一为时间戳） ===============================

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new ByteArrayHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		converters.add(new ResourceHttpMessageConverter());
		converters.add(new AllEncompassingFormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		converters.add(new EnhancedMappingJackson2HttpMessageConverter());
	}
}
