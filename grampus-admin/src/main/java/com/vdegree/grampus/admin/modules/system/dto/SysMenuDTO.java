package com.vdegree.grampus.admin.modules.system.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Title: 系统菜单DTO
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-01
 */
@Data
public class SysMenuDTO implements Serializable {
	private static final long serialVersionUID = 5330634077811336459L;

	/**
	 * 父级菜单ID
	 */
	private Long parentId;

	/**
	 * 菜单类型(0菜单 1按钮)
	 */
	private Integer type;

	/**
	 * 菜单名
	 */
	private String menuName;

	/**
	 * 权限标识
	 */
	private String permission;

	/**
	 * 菜单路径
	 */
	private String path;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 删除标识(0正常 1删除)
	 */
	private Integer delFlag;
}