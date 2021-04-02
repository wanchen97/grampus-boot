package com.vdegree.grampus.common.auth.model;

import lombok.Data;

import java.io.Serializable;

/**
 * User information in authorization.
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -8002966873087151367L;

	/**
	 * Unique string representing user.
	 */
	private String username;

	/**
	 * password
	 */
	private String password;
}
