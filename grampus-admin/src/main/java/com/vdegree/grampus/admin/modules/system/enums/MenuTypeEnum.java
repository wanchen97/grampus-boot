package com.vdegree.grampus.admin.modules.system.enums;

import lombok.Getter;

/**
 * Title: 菜单类型枚举
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-09
 */
public enum MenuTypeEnum {
	/**
	 * 菜单
	 */
	MENU(0),
	/**
	 * 按钮
	 */
	BUTTON(1);

	@Getter
	private int value;

	MenuTypeEnum(int value) {
		this.value = value;
	}
}
