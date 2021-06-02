package com.vdegree.grampus.admin.modules.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * SysUserReqDTO
 *
 * @author Beck
 * @since 2021-06-02
 */
@ApiModel("系统用户")
@Data
public class SysUserReqDTO implements Serializable {
	private static final long serialVersionUID = 1318536021225511284L;
	/**
	 * 数据ID
	 */
	@ApiModelProperty("数据ID")
	private Long id;
	/**
	 * 员工号
	 */
	@ApiModelProperty("员工号")
	private String userNo;
	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String name;
	/**
	 * 密码
	 */
	@ApiModelProperty("密码")
	private String password;
	/**
	 * 性别
	 */
	@ApiModelProperty("性别")
	private Integer gender;
	/**
	 * 所属部门ID
	 */
	@ApiModelProperty("所属部门ID")
	private Long deptId;
	/**
	 * 是否启用(0停用 1启用)
	 */
	@ApiModelProperty("是否启用(0停用 1启用)")
	private Integer enabled;
	/**
	 * 用户所属角色列表
	 */
	@ApiModelProperty("用户所属角色列表")
	private List<Long> roleIdList;
}
