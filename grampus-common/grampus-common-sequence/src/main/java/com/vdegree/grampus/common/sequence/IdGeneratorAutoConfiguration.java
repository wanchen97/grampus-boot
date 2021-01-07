package com.vdegree.grampus.common.sequence;

import com.vdegree.grampus.common.sequence.builder.SnowflakeIdGeneratorBuilder;
import com.vdegree.grampus.common.sequence.generator.IdGenerator;
import com.vdegree.grampus.common.sequence.properties.SnowflakeIdGeneratorProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Title: IdGeneratorAutoConfiguration
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-03
 */
@Configuration
@ComponentScan("com.vdegree.grampus.common.sequence")
@ConditionalOnMissingBean(IdGenerator.class)
public class IdGeneratorAutoConfiguration {

	/**
	 * snowflak 算法作为ID生成器实现
	 */
	@Bean
	@ConditionalOnBean(SnowflakeIdGeneratorProperties.class)
	public IdGenerator idGenerator(SnowflakeIdGeneratorProperties snowflakeIdGeneratorProperties) {
		return SnowflakeIdGeneratorBuilder.builder()
				.dataCenterId(snowflakeIdGeneratorProperties.getDataCenterId())
				.workerId(snowflakeIdGeneratorProperties.getWorkerId())
				.build();
	}
}
