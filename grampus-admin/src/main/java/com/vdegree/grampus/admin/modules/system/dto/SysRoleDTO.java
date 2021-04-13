package com.vdegree.grampus.admin.modules.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统角色DTO
 *
 * @author Beck
 * @since 2020-12-09 19:50:15
 */
@ApiModel("系统角色")
@Data
public class SysRoleDTO implements Serializable {
	private static final long serialVersionUID = -4592002714978614167L;
	/**
	 * 角色名
	 */
	@ApiModelProperty("角色名")
	private String roleName;
	/**
	 * 角色编号
	 */
	@ApiModelProperty("角色编号")
	private String roleCode;
	/**
	 * 创建者
	 */
	@ApiModelProperty("创建者")
	private Long createBy;
	/**
	 * 创建日期
	 */
	@ApiModelProperty("创建日期")
	private Date createDate;
	/**
	 * 更新者
	 */
	@ApiModelProperty("更新者")
	private Long updateBy;
	/**
	 * 更新日期
	 */
	@ApiModelProperty("更新日期")
	private Date updateDate;
}