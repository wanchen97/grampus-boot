package com.oceancloud.grampus.admin.modules.system.dto;

import com.oceancloud.grampus.framework.core.utils.tree.TreeNode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 系统部门DTO
 *
 * @author Beck
 * @since 2020-12-03
 */
@Data
@Schema(description = "系统部门")
public class SysDeptDTO extends TreeNode<SysDeptDTO> {
	private static final long serialVersionUID = -4286031575713376186L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 父级部门ID
	 */
	@Schema(description = "父级部门ID", example = "顶级结点则不传或传入0")
	private Long parentId;
	/**
	 * 部门名称
	 */
	@Schema(description = "部门名称", required = true)
	private String deptName;
	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;
	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private LocalDateTime createDate;
}