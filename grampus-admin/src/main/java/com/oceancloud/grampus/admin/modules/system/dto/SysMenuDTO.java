package com.oceancloud.grampus.admin.modules.system.dto;

import com.oceancloud.grampus.framework.core.utils.tree.TreeNode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 系统菜单DTO
 *
 * @author Beck
 * @since 2021-04-01
 */
@Data
@Schema(description = "系统菜单")
public class SysMenuDTO extends TreeNode<SysMenuDTO> {
	private static final long serialVersionUID = 5330634077811336459L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 父级菜单ID
	 */
	@Schema(description = "父菜单ID", example = "顶级结点则不传或传入0")
	private Long parentId;
	/**
	 * 菜单类型(0菜单 1按钮)
	 */
	@Schema(description = "菜单类型(0菜单 1按钮)", required = true)
	private Integer type;
	/**
	 * 菜单名
	 */
	@Schema(description = "菜单名", required = true)
	private String menuName;
	/**
	 * 权限标识
	 */
	@Schema(description = "权限标识", example = "只有按钮类型才需要传入")
	private String permission;
	/**
	 * 菜单路径
	 */
	@Schema(description = "菜单路径", example = "只有菜单类型才需要传入")
	private String path;
	/**
	 * 图标
	 */
	@Schema(description = "图标")
	private String icon;
	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;
}