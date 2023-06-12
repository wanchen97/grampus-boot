package com.oceancloud.grampus.admin.modules.security.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 注册接口入参
 *
 * @author Beck
 * @since 2021-04-09
 */
@Data
@Schema(description = "注册接口入参")
public class RegisterReq implements Serializable {
	private static final long serialVersionUID = -8157819258927558166L;
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
	/**
	 * 用户名
	 */
	@Schema(description = "用户名")
	private String name;
}
