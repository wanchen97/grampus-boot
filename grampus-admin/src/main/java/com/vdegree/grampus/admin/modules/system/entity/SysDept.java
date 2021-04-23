package com.vdegree.grampus.admin.modules.system.entity;

import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Table;
import java.util.Date;

/**
 * 部门表 实体类
 *
 * @author Beck
 * @since 2020-12-03 20:06:54
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_dept")
public class SysDept extends BaseEntity {
	private static final long serialVersionUID = 950431345148076167L;
	/**
	 * 父级部门ID
	 */
	private Long parentId;
	/**
	 * 部门名称
	 */
	private String deptName;
	/**
	 * 排序
	 */
	private Integer sort;
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
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 删除标识(0正常 1删除)
	 */
	@LogicDelete
	private Integer delFlag;
}