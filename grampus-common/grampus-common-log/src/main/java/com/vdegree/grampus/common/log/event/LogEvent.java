package com.vdegree.grampus.common.log.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 通用日志事件模型
 *
 * @author Beck
 * @since 2021-05-27
 */
@Getter
@Setter
@ToString
public class LogEvent implements Serializable {
	private static final long serialVersionUID = -7159973353669869079L;
	/**
	 * 所属模块
	 */
	private String module;
	/**
	 * Header Authorization
	 */
	private String authorization;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * Request Method
	 */
	private String method;
	/**
	 * Request Param
	 */
	private String params;
	/**
	 * Request Body
	 */
	private String data;
	/**
	 * 是否成功(0失败,1成功)
	 */
	private Boolean successful;
	/**
	 * 类-方法
	 */
	private String classMethod;
	/**
	 * 异常信息
	 */
	private String exceptionDetail;
	/**
	 * 请求uri
	 */
	private String requestUri;
	/**
	 * 请求ip
	 */
	private String requestIp;
	/**
	 * 请求时间
	 */
	private LocalDateTime requestStartTime;
	/**
	 * 请求结束时间
	 */
	private LocalDateTime requestEndTime;
	/**
	 * 请求耗时
	 */
	private Long costTime;
	/**
	 * ua 信息
	 */
	private String userAgent;
}
