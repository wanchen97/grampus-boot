package com.oceancloud.grampus.admin.modules.system.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 操作日志表(LogOperation) 表Excel类
 *
 * @author Beck
 * @since 2021-05-31
 */
@Setter
@Getter
@ToString
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class LogOperationExcel implements Serializable {
	private static final long serialVersionUID = -64891032904391963L;
	/**
	 * 所属模块
	 */
	@ExcelProperty("所属模块")
	private String module;
	/**
	 * 操作对象
	 */
	@ExcelProperty("操作对象")
	private String subject;
	/**
	 * 描述
	 */
	@ExcelProperty("描述")
	private String description;
	/**
	 * RequestMethod
	 */
	@ExcelProperty("请求方式")
	private String requestMethod;
	/**
	 * RequestUri
	 */
	@ExcelProperty("请求地址")
	private String requestUri;
	/**
	 * RequestParam
	 */
	@ExcelProperty("请求入参")
	private String requestParam;
	/**
	 * RequestBody
	 */
	@ExcelProperty("请求Body")
	private String requestBody;
	/**
	 * 是否成功(0失败 1成功)
	 */
	@ExcelProperty("是否成功(0失败 1成功)")
	private Boolean successful;
	/**
	 * 类方法
	 */
	@ExcelProperty("类方法")
	private String classMethod;
	/**
	 * 异常信息
	 */
	@ExcelProperty("异常信息")
	private String exceptionDetail;
	/**
	 * 请求IP
	 */
	@ExcelProperty("请求IP")
	private String requestIp;
	/**
	 * 请求开始时间
	 */
	@ExcelProperty("请求开始时间")
	private LocalDateTime requestStartTime;
	/**
	 * 请求结束时间
	 */
	@ExcelProperty("请求结束时间")
	private LocalDateTime requestEndTime;
	/**
	 * 请求耗时
	 */
	@ExcelProperty("请求耗时")
	private Long costTime;
	/**
	 * UA信息
	 */
	@ExcelProperty("UA信息")
	private String userAgent;
}
