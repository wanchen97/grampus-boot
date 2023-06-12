package com.oceancloud.grampus.admin.modules.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * SysRoleQuery
 *
 * @author Beck
 * @since 2021-08-20
 */
@Data
@Schema(description = "系统角色")
public class SysRoleQuery implements Serializable {
	private static final long serialVersionUID = -2904937768611925344L;
	/**
	 * 角色名
	 */
	@Schema(description = "角色名")
	private String roleName;
	/**
	 * 角色编号
	 */
	@Schema(description = "角色编号")
	private String roleCode;
}