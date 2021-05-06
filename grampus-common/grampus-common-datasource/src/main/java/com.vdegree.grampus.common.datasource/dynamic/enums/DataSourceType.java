package com.vdegree.grampus.common.datasource.dynamic.enums;

import lombok.Getter;

/**
 * 数据源枚举类
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
public enum DataSourceType {
	/**
	 * API主库
	 */
	MASTER("master"),
	/**
	 * API从库
	 */
	SLAVE("slave");

	@Getter
	private final String name;

	DataSourceType(String name) {
		this.name = name;
	}
}
