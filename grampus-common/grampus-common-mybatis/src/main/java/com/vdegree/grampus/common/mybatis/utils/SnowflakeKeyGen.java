package com.vdegree.grampus.common.mybatis.utils;

import com.vdegree.grampus.common.sequence.generator.IdGenerator;
import tk.mybatis.mapper.genid.GenId;

/**
 * Title: Snowflake ID生成器
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
public class SnowflakeKeyGen implements GenId<Long> {

	private static IdGenerator idGenerator;

	@Override
	public Long genId(String table, String column) {
		return idGenerator.genKey();
	}

	public static void initIdGenerator(IdGenerator idGenerator) {
		SnowflakeKeyGen.idGenerator = idGenerator;
	}
}
