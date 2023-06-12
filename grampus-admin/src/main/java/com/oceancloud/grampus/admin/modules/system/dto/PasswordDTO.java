package com.oceancloud.grampus.admin.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 修改密码DTO
 *
 * @author Beck
 * @since 2021-04-14
 */
@Data
@Schema(description = "修改密码")
public class PasswordDTO implements Serializable {
	private static final long serialVersionUID = -4260149891670265974L;
	/**
	 * 原密码
	 */
	@Schema(description = "原密码", required = true)
	private String password;
	/**
	 * 新密码
	 */
	@Schema(description = "新密码", required = true)
	private String newPassword;
}