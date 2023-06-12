package com.oceancloud.grampus.admin.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 字典类型DTO
 *
 * @author Beck
 * @since 2021-04-12
 */
@Data
@Schema(description = "字典类型")
public class SysDictDTO implements Serializable {
	private static final long serialVersionUID = -3004268085455455303L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 字典类型
	 */
	@Schema(description = "字典类型", required = true)
	private String dictType;
	/**
	 * 字典名称
	 */
	@Schema(description = "字典名称", required = true)
	private String dictName;
	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;
	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;
	/**
	 * 创建者
	 */
	@Schema(description = "创建者")
	private String createBy;
	/**
	 * 创建日期
	 */
	@Schema(description = "创建日期")
	private LocalDateTime createDate;
}
