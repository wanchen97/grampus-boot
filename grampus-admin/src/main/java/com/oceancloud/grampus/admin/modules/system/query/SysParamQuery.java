package com.oceancloud.grampus.admin.modules.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * SysParamQuery
 *
 * @author Beck
 * @since 2021-08-20
 */
@Data
@Schema(description = "系统参数")
public class SysParamQuery implements Serializable {
	private static final long serialVersionUID = 5849555991146805823L;
	/**
	 * 参数编码
	 */
	@Schema(description = "参数编码")
	private String code;
}
