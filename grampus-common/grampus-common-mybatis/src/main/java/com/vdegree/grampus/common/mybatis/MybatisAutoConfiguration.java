package com.vdegree.grampus.common.mybatis;

import com.vdegree.grampus.common.sequence.generator.IdGenerator;
import com.vdegree.grampus.common.mybatis.utils.SnowflakeKeyGen;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Title: TK.Mybatis配置
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
@Configuration
@ComponentScan(basePackages = {"com.vdegree.grampus.common.mybatis"})
@MapperScan(basePackages = "com.vdegree.**.dao")
public class MybatisAutoConfiguration {

	@Component
	@RequiredArgsConstructor
	public static class KeyGenConfig implements InitializingBean {

		private final IdGenerator idGenerator;

		@Override
		public void afterPropertiesSet() throws Exception {
			SnowflakeKeyGen.initIdGenerator(idGenerator);
		}
	}
}
