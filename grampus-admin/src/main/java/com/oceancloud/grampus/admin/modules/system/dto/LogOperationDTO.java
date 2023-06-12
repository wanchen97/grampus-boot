package com.oceancloud.grampus.admin.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 操作日志表(LogOperation) 表数据传输对象
 *
 * @author Beck
 * @since 2021-05-31
 */
@Data
@Schema(description = "操作日志表")
public class LogOperationDTO implements Serializable {
	private static final long serialVersionUID = -62482078918584463L;
	/**
	 * 数据ID
	 */
	@Schema(description = "数据ID")
	private Long id;
	/**
	 * 所属模块
	 */
	@Schema(description = "所属模块")
	private String module;
	/**
	 * 操作对象
	 */
	@Schema(description = "操作对象")
	private String subject;
	/**
	 * 描述
	 */
	@Schema(description = "描述")
	private String description;
	/**
	 * RequestMethod
	 */
	@Schema(description = "RequestMethod")
	private String requestMethod;
	/**
	 * RequestUri
	 */
	@Schema(description = "RequestUri")
	private String requestUri;
	/**
	 * RequestParam
	 */
	@Schema(description = "RequestParam")
	private String requestParam;
	/**
	 * RequestBody
	 */
	@Schema(description = "RequestBody")
	private String requestBody;
	/**
	 * 是否成功(0失败 1成功)
	 */
	@Schema(description = "是否成功(0失败 1成功)")
	private Boolean successful;
	/**
	 * 类方法
	 */
	@Schema(description = "类方法")
	private String classMethod;
	/**
	 * 异常信息
	 */
	@Schema(description = "异常信息")
	private String exceptionDetail;
	/**
	 * 请求IP
	 */
	@Schema(description = "请求IP")
	private String requestIp;
	/**
	 * 请求开始时间
	 */
	@Schema(description = "请求开始时间")
	private LocalDateTime requestStartTime;
	/**
	 * 请求结束时间
	 */
	@Schema(description = "请求结束时间")
	private LocalDateTime requestEndTime;
	/**
	 * 请求耗时
	 */
	@Schema(description = "请求耗时")
	private Long costTime;
	/**
	 * UA信息
	 */
	@Schema(description = "UA信息")
	private String userAgent;
}
