package com.oceancloud.grampus.admin.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统语言表DTO
 *
 * @author Beck
 * @since 2021-06-08
 */
@Data
@Schema(description = "系统语言表")
public class SysLanguageDTO implements Serializable {
	private static final long serialVersionUID = -53877326603873018L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 表名
	 */
	@Schema(description = "表名")
	private String tableName;
	/**
	 * 表数据ID
	 */
	@Schema(description = "表数据ID")
	private Long tableId;
	/**
	 * 字段名
	 */
	@Schema(description = "字段名")
	private String fieldName;
	/**
	 * 字段值
	 */
	@Schema(description = "字段值")
	private String fieldValue;
	/**
	 * 语言
	 */
	@Schema(description = "语言")
	private String language;
}
