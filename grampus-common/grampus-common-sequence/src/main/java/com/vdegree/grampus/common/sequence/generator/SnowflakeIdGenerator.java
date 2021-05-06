package com.vdegree.grampus.common.sequence.generator;

import com.vdegree.grampus.common.sequence.utils.SnowflakeIdWorker;
import lombok.AllArgsConstructor;

/**
 * Snowflake ID生成器
 *
 * @author Beck
 * @since 2020-12-03
 */
@AllArgsConstructor
public class SnowflakeIdGenerator implements IdGenerator {

	private final SnowflakeIdWorker snowflakeIdWorker;

	@Override
	public long genKey() {
		return snowflakeIdWorker.nextId();
	}
}
