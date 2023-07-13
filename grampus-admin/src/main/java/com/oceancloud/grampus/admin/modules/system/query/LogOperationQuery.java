package com.oceancloud.grampus.admin.modules.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * LogOperationQuery
 *
 * @author Beck
 * @since 2021-08-20
 */
@Data
@Schema(description = "操作日志表")
public class LogOperationQuery implements Serializable {
	private static final long serialVersionUID = 767638546842396520L;
	/**
	 * 所属模块
	 */
	@Schema(description = "所属模块")
	private String module;
	/**
	 * 是否成功(true、false)
	 */
	@Schema(description = "是否成功(true、false)")
	private Boolean successful;
}
