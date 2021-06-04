package com.vdegree.grampus.common.xxljob.config;

import com.vdegree.grampus.common.xxljob.properties.XxlJobProperties;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * XxlJobAutoConfiguration
 *
 * @author Beck
 * @since 2021-06-03
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(XxlJobProperties.class)
public class XxlJobAutoConfiguration {

	@Bean
	public XxlJobSpringExecutor xxlJobExecutor(XxlJobProperties properties, Environment environment) {
		log.info(">>>>>>>>>>> xxl-job config init.");
		XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
		xxlJobSpringExecutor.setAdminAddresses(properties.getAdminProperties().getAddresses());
		xxlJobSpringExecutor.setAppname(environment.getProperty("spring.application.name"));
		xxlJobSpringExecutor.setIp(properties.getExecutorProperties().getIp());
		xxlJobSpringExecutor.setPort(properties.getExecutorProperties().getPort());
		xxlJobSpringExecutor.setAccessToken(properties.getAccessToken());
		xxlJobSpringExecutor.setLogPath(properties.getExecutorProperties().getLogpath());
		xxlJobSpringExecutor.setLogRetentionDays(properties.getExecutorProperties().getLogretentiondays());
		return xxlJobSpringExecutor;
	}
}
