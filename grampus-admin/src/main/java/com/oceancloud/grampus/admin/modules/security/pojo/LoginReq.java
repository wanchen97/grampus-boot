package com.oceancloud.grampus.admin.modules.security.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 登录接口入参
 *
 * @author Beck
 * @since 2021-04-09
 */
@Data
@Schema(description = "登陆接口入参")
public class LoginReq implements Serializable {
	private static final long serialVersionUID = -2573260643888389101L;
	/**
	 * 员工号
	 */
	@Schema(description = "员工号")
	private String userNo;
	/**
	 * 密码
	 */
	@Schema(description = "密码")
	private String password;
}
