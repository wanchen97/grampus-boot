package com.vdegree.grampus.admin.modules.system.dto;

import com.vdegree.grampus.admin.modules.system.utils.TreeNode;
import lombok.Data;

import java.util.Date;

/**
 * 部门表(SysDept)实体类
 *
 * @author Beck
 * @since 2020-12-03 20:06:54
 */
@Data
public class SysDeptDTO extends TreeNode<SysDeptDTO> {
	private static final long serialVersionUID = -4286031575713376186L;
	/**
	 * 数据ID
	 */
	private Long id;
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
	private Integer delFlag;
}