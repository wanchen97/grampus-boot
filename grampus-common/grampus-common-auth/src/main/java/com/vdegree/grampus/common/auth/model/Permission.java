package com.vdegree.grampus.common.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Permission to auth.
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {

	private static final long serialVersionUID = -3583076254743606551L;

	/**
	 * An unique key of resource.
	 */
	private String resource;
}
