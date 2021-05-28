package com.vdegree.grampus.common.log.config;

import com.vdegree.grampus.common.log.aspect.LogAnnotationAdvisor;
import com.vdegree.grampus.common.log.aspect.LogInterceptor;
import com.vdegree.grampus.common.log.listener.LogEventListener;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * LogAutoConfiguration
 *
 * @author Beck
 * @since 2021-05-27
 */
@EnableAsync
@Configuration
@AllArgsConstructor
public class LogAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public LogInterceptor logInterceptor(ApplicationContext applicationContext) {
		return new LogInterceptor(applicationContext);
	}

	@Bean
	@ConditionalOnMissingBean
	public LogAnnotationAdvisor logAnnotationAdvisor(LogInterceptor logInterceptor) {
		return new LogAnnotationAdvisor(logInterceptor, Ordered.HIGHEST_PRECEDENCE);
	}

	@Bean
	public LogEventListener logEventListener() {
		return new LogEventListener();
	}
}
