package com.oceancloud.grampus.admin.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * SysUserReqDTO
 *
 * @author Beck
 * @since 2021-06-02
 */
@Data
@Schema(description = "系统用户")
public class SysUserReqDTO implements Serializable {
	private static final long serialVersionUID = 1318536021225511284L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 员工号
	 */
	@Schema(description = "员工号", required = true)
	private String userNo;
	/**
	 * 姓名
	 */
	@Schema(description = "姓名", required = true)
	private String name;
	/**
	 * 密码
	 */
	@Schema(description = "密码", required = true)
	private String password;
	/**
	 * 性别
	 */
	@Schema(description = "性别", required = true)
	private Integer gender;
	/**
	 * 所属部门ID
	 */
	@Schema(description = "所属部门ID", required = true)
	private Long deptId;
	/**
	 * 是否启用(0停用 1启用)
	 */
	@Schema(description = "是否启用(0停用 1启用)", required = true)
	private Integer status;
	/**
	 * 用户所属角色列表
	 */
	@Schema(description = "用户所属角色列表", required = true)
	private List<Long> roleIdList;
}
