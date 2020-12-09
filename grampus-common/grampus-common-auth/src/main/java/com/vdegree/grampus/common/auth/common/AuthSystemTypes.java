package com.vdegree.grampus.common.auth.common;

import lombok.Getter;

/**
 * Types of all auth implementations.
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
public enum AuthSystemTypes {

	/**
	 * System认证(Host端)
	 */
	SYSTEM("system"),
	/**
	 * Api认证(APP端)
	 */
	API("api"),
	/**
	 * Agency认证(Agecny端)
	 */
	AGENCY("agency");

	@Getter
	private String name;

	AuthSystemTypes(String name) {
		this.name = name;
	}
}
