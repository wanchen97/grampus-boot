package com.vdegree.grampus.admin.modules.system.entity;

import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * 操作日志表(LogOperation) 表实体类
 *
 * @author Beck
 * @since 2021-05-31 16:43:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "log_operation")
public class LogOperation extends BaseEntity {
	private static final long serialVersionUID = -64891032904391963L;
	/**
	 * 数据ID
	 */
	private Long id;
	/**
	 * 所属模块
	 */
	private String module;
	/**
	 * 操作对象
	 */
	private String subject;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * RequestMethod
	 */
	private String requestMethod;
	/**
	 * RequestUri
	 */
	private String requestUri;
	/**
	 * RequestParam
	 */
	private String requestParam;
	/**
	 * RequestBody
	 */
	private String requestBody;
	/**
	 * 是否成功(0失败 1成功)
	 */
	private Integer successful;
	/**
	 * 类方法
	 */
	private String classMethod;
	/**
	 * 异常信息
	 */
	private String exceptionDetail;
	/**
	 * 请求IP
	 */
	private String requestIp;
	/**
	 * 请求开始时间
	 */
	private Object requestStartTime;
	/**
	 * 请求结束时间
	 */
	private Object requestEndTime;
	/**
	 * 请求耗时
	 */
	private Long costTime;
	/**
	 * 请求令牌
	 */
	private String authorization;
	/**
	 * UA信息
	 */
	private String userAgent;
}
