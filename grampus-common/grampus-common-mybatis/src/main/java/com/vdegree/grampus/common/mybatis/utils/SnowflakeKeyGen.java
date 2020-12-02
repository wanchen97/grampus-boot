package com.vdegree.grampus.common.mybatis.utils;

import tk.mybatis.mapper.genid.GenId;

/**
 * Title: Snowflake ID生成器
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
public class SnowflakeKeyGen implements GenId<Long> {

	@Override
	public Long genId(String table, String column) {
		return null;
	}
}
