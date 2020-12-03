package com.vdegree.grampus.common.idgenerator.builder;

import com.vdegree.grampus.common.idgenerator.generator.IdGenerator;
import com.vdegree.grampus.common.idgenerator.generator.SnowflakeIdGenerator;
import com.vdegree.grampus.common.idgenerator.utils.SnowflakeIdWorker;
import lombok.Getter;
import lombok.Setter;

/**
 * Title: Snowflake ID生成器Builder
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-03
 */
@Getter
@Setter
public class SnowflakeIdGeneratorBuilder implements IdGeneratorBuilder {
	/**
	 * 机器ID(0-31)
	 */
	private long workerId;
	/**
	 * 数据中心ID(0-31)
	 */
	private long dataCenterId;

	public static SnowflakeIdGeneratorBuilder builder() {
		return new SnowflakeIdGeneratorBuilder();
	}

	@Override
	public IdGenerator build() {
		SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(workerId, dataCenterId);
		return new SnowflakeIdGenerator(snowflakeIdWorker);
	}

	public SnowflakeIdGeneratorBuilder workerId(long workerId) {
		this.workerId = workerId;
		return this;
	}

	public SnowflakeIdGeneratorBuilder dataCenterId(long dataCenterId) {
		this.dataCenterId = dataCenterId;
		return this;
	}
}
