package com.vdegree.grampus.admin.modules.system.entity;

import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Table;
import java.util.Date;

/**
 * 用户表(SysUser)实体类
 *
 * @author Beck
 * @since 2020-12-09 19:50:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_user")
public class SysUser extends BaseEntity {
	private static final long serialVersionUID = 633586235310501193L;

	/**
	 * 员工号
	 */
	private String userNo;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 所属部门ID
	 */
	private Long deptId;

	/**
	 * 是否超级管理员(0普通 1超管)
	 */
	private Integer superAdmin;

	/**
	 * 是否启用(0停用 1启用)
	 */
	private Integer enabled;

	/**
	 * 创建者
	 */
	private Long createBy;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新者
	 */
	private Long updateBy;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	/**
	 * 删除标记(0正常 1删除)
	 */
	@LogicDelete
	private Integer delFlag;

}