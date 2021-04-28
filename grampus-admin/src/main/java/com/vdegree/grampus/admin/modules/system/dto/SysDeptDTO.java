package com.vdegree.grampus.admin.modules.system.dto;

import com.vdegree.grampus.admin.modules.system.utils.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 系统部门DTO
 *
 * @author Beck
 * @since 2020-12-03 20:06:54
 */
@Data
@ApiModel("系统部门")
public class SysDeptDTO extends TreeNode<SysDeptDTO> {
	private static final long serialVersionUID = -4286031575713376186L;
	/**
	 * 数据ID
	 */
	@ApiModelProperty("数据ID")
	private Long id;
	/**
	 * 父级部门ID
	 */
	@ApiModelProperty("父级部门ID")
	private Long parentId;
	/**
	 * 部门名称
	 */
	@ApiModelProperty("部门名称")
	private String deptName;
	/**
	 * 排序
	 */
	@ApiModelProperty("排序")
	private Integer sort;
	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private LocalDateTimecreateDate;
}