package com.vdegree.grampus.admin.modules.system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Title: 系统用户DTO
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-14
 */
@ApiModel("系统用户")
@Data
public class SysUserDTO implements Serializable {
	private static final long serialVersionUID = -2668695231780758833L;
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
	@JsonIgnore
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
	 * 是否超级管理员(0普通 1超管)
	 */
	@ApiModelProperty("是否超级管理员(0普通 1超管)")
	private Integer superAdmin;
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
	/**
	 * 创建者
	 */
	@ApiModelProperty("创建者")
	private Long createBy;
	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private Date createDate;
	/**
	 * 更新者
	 */
	@ApiModelProperty("更新者")
	private Long updateBy;
	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
	private Date updateDate;
}
