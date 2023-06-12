package com.oceancloud.grampus.admin.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统参数DTO
 *
 * @author Beck
 * @since 2021-04-13
 */
@Data
@Schema(description = "系统参数")
public class SysParamDTO implements Serializable {
	private static final long serialVersionUID = -6988841582283661929L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 参数编码
	 */
	@Schema(description = "参数编码", required = true)
	private String code;
	/**
	 * 参数值
	 */
	@Schema(description = "参数值", required = true)
	private String value;
	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;
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
	/**
	 * 更新者
	 */
	@Schema(description = "更新者")
	private String updateBy;
	/**
	 * 更新日期
	 */
	@Schema(description = "更新日期")
	private LocalDateTime updateDate;
}
