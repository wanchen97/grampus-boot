package com.vdegree.grampus.common.mybatis.enums;

import lombok.Getter;

/**
 * Title: 删除标识枚举
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
public enum DelFlagEnum {
	/**
	 * 正常
	 */
	NORMAL(0),
	/**
	 * 删除
	 */
	DELETE(1);

	@Getter
	private final int value;

	DelFlagEnum(int value) {
		this.value = value;
	}
}