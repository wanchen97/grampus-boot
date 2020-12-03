package com.vdegree.grampus.common.idgenerator.generator;

import com.vdegree.grampus.common.idgenerator.utils.SnowflakeIdWorker;
import lombok.AllArgsConstructor;

/**
 * Title: Snowflake ID生成器
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-03
 */
@AllArgsConstructor
public class SnowflakeIdGenerator implements IdGenerator {

	private final SnowflakeIdWorker snowflakeIdWorker;

	@Override
	public long genKey() {
		return snowflakeIdWorker.nextId();
	}
}
