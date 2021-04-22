package com.vdegree.grampus.admin.modules.system.entity;

import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * 部门关系表(SysDeptRelation)实体类
 *
 * @author Beck
 * @since 2020-12-09 19:47:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_dept_relation")
public class SysDeptRelation extends BaseEntity {
	private static final long serialVersionUID = -64195621401623961L;
	/**
	 * 部门ID
	 */
	private Long deptId;
	/**
	 * 所有子部门ID
	 */
	private Long childDeptId;
}