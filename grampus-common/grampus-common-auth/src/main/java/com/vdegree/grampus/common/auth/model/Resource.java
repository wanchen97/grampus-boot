package com.vdegree.grampus.common.auth.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * Resource used in authorization.
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
@Data
@RequiredArgsConstructor
public class Resource implements Serializable {

	public static final String SPLITTER = ":";

	public static final String ANY = "*";

	private static final long serialVersionUID = 925971662931204553L;

	/**
	 * The unique key of resource.
	 */
	private String key;

	public String parseName() {
		return key.substring(0, key.lastIndexOf(SPLITTER));
	}
}
