package com.oceancloud.grampus.admin.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 字典详情DTO
 *
 * @author Beck
 * @since 2021-04-13
 */
@Data
@Schema(description = "字典详情")
public class SysDictItemDTO implements Serializable {
	private static final long serialVersionUID = -8288240035977175413L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 字典ID
	 */
	@Schema(description = "字典ID", required = true)
	private Long dictId;
	/**
	 * 字典类型
	 */
	@Schema(description = "字典类型", example = "入参不需要传入,后台自动根据dictId所属字段类型填充")
	private String dictType;
	/**
	 * 字典标签
	 */
	@Schema(description = "字典标签", required = true)
	private String dictLabel;
	/**
	 * 字典值
	 */
	@Schema(description = "字典值", required = true)
	private String dictValue;
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
