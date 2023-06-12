package com.oceancloud.grampus.admin.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 系统角色DTO
 *
 * @author Beck
 * @since 2021-08-20
 */
@Data
@Schema(description = "系统角色")
public class SysRoleDTO implements Serializable {
	private static final long serialVersionUID = -4592002714978614167L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 角色名
	 */
	@Schema(description = "角色名", required = true)
	private String roleName;
	/**
	 * 角色编号
	 */
	@Schema(description = "角色编号", required = true)
	private String roleCode;
	/**
	 * 角色菜单ID列表
	 */
	@Schema(description = "角色菜单ID列表，既该角色目前具有哪些权限")
	private List<Long> menuIdList;
	/**
	 * 创建者
	 */
	@Schema(description = "创建者")
	private String createBy;
	/**
	 * 创建日期
	 */
	@Schema(description = "创建日期")
	private LocalDateTime createDate;
	/**
	 * 更新者
	 */
	@Schema(description = "更新者")
	private String updateBy;
	/**
	 * 更新日期
	 */
	@Schema(description = "更新日期")
	private LocalDateTime updateDate;
}