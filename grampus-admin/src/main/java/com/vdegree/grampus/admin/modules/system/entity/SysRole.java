package com.vdegree.grampus.admin.modules.system.entity;

import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Table;
import java.util.Date;

/**
 * 角色表(SysRole)实体类
 *
 * @author Beck
 * @since 2020-12-09 19:50:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_role")
public class SysRole extends BaseEntity {
	private static final long serialVersionUID = 748889808530861432L;
	/**
	 * 角色名
	 */
	private String roleName;
	/**
	 * 角色编号
	 */
	private String roleCode;
	/**
	 * 创建者
	 */
	private Long createBy;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 更新者
	 */
	private Long updateBy;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 删除标识(0正常 1删除)
	 */
	@LogicDelete
	private Integer delFlag;
}