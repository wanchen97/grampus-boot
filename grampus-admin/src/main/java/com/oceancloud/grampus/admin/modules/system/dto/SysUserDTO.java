package com.oceancloud.grampus.admin.modules.system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 系统用户DTO
 *
 * @author Beck
 * @since 2021-04-14
 */
@Data
@Schema(description = "系统用户")
public class SysUserDTO implements Serializable {
	private static final long serialVersionUID = -2668695231780758833L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 员工号
	 */
	@Schema(description = "员工号")
	private String userNo;
	/**
	 * 姓名
	 */
	@Schema(description = "姓名")
	private String name;
	/**
	 * 密码
	 */
	@Schema(description = "密码")
	@JsonIgnore
	private String password;
	/**
	 * 性别
	 */
	@Schema(description = "性别")
	private Integer gender;
	/**
	 * 所属部门ID
	 */
	@Schema(description = "所属部门ID")
	private Long deptId;
	/**
	 * 是否超级管理员(0普通 1超管)
	 */
	@Schema(description = "是否超级管理员(0普通 1超管)")
	private Integer superAdmin;
	/**
	 * 是否启用(0停用 1启用)
	 */
	@Schema(description = "是否启用(0停用 1启用)")
	private Integer status;
	/**
	 * 用户所属角色列表
	 */
	@Schema(description = "用户所属角色列表")
	private List<Long> roleIdList;
	/**
	 * 创建者
	 */
	@Schema(description = "创建者")
	private String createBy;
	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private LocalDateTime createDate;
	/**
	 * 更新者
	 */
	@Schema(description = "更新者")
	private String updateBy;
	/**
	 * 更新时间
	 */
	@Schema(description = "更新时间")
	private LocalDateTime updateDate;
}
