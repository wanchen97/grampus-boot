package com.vdegree.grampus.common.core.result;

import com.vdegree.grampus.common.core.utils.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Title: 响应实体工具类
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
@Getter
@Setter
@ToString
@ApiModel(description = "返回信息")
@NoArgsConstructor
public class Result<T> implements Serializable {
	private static final long serialVersionUID = -406541324632704646L;
	private static final String DEFAULT_SUCCESS_PHRASE = "Success";
	private static final String DEFAULT_ERROR_PHRASE = "Failure";
	private static final String DEFAULT_ERROR_CODE = "0";
	private static final int SUCCESS_STATUS_CODE = 200;
	private static final int ERROR_STATUS_CODE = 500;

	/**
	 * 消息
	 */
	@ApiModelProperty(value = "消息", required = true)
	private String message;
	/**
	 * 数据
	 */
	@ApiModelProperty(value = "数据", required = true)
	private T data;
	/**
	 * 消息状态码
	 */
	@ApiModelProperty(value = "消息状态码", required = true)
	private int status;
	/**
	 * 消息错误码
	 */
	@ApiModelProperty(value = "消息错误码", required = true)
	private String errorCode;

	public static <T> Result<T> success() {
		String msg = defaultMessage(SUCCESS_STATUS_CODE, null);
		return restResult(SUCCESS_STATUS_CODE, null, DEFAULT_ERROR_CODE, msg);
	}

	public static <T> Result<T> success(T data) {
		String msg = defaultMessage(SUCCESS_STATUS_CODE, null);
		return restResult(SUCCESS_STATUS_CODE, data, DEFAULT_ERROR_CODE, msg);
	}

	public static <T> Result<T> success(T data, String msg) {
		msg = defaultMessage(SUCCESS_STATUS_CODE, msg);
		return restResult(SUCCESS_STATUS_CODE, data, DEFAULT_ERROR_CODE, msg);
	}

	public static <T> Result<T> error() {
		String msg = defaultMessage(ERROR_STATUS_CODE, null);
		return restResult(ERROR_STATUS_CODE, null, ErrorCode.BASE_ERROR_CODE, msg);
	}

	public static <T> Result<T> error(String msg) {
		msg = defaultMessage(ERROR_STATUS_CODE, msg);
		return restResult(ERROR_STATUS_CODE, null, ErrorCode.BASE_ERROR_CODE, msg);
	}

	public static <T> Result<T> error(String errorCode, String msg) {
		msg = defaultMessage(ERROR_STATUS_CODE, msg);
		return restResult(ERROR_STATUS_CODE, null, errorCode, msg);
	}

	public static <T> Result<T> error(int status, String msg) {
		msg = defaultMessage(ERROR_STATUS_CODE, msg);
		return restResult(status, null, ErrorCode.BASE_ERROR_CODE, msg);
	}

	public static <T> Result<T> error(T data) {
		String msg = defaultMessage(ERROR_STATUS_CODE, null);
		return restResult(ERROR_STATUS_CODE, data, ErrorCode.BASE_ERROR_CODE, msg);
	}

	public static <T> Result<T> error(T data, String msg) {
		msg = defaultMessage(ERROR_STATUS_CODE, msg);
		return restResult(ERROR_STATUS_CODE, data, ErrorCode.BASE_ERROR_CODE, msg);
	}

	private static <T> Result<T> restResult(int status, T data, String errorCode, String message) {
		Result<T> result = new Result<>();
		result.setStatus(status);
		result.setData(data);
		result.setErrorCode(errorCode);
		result.setMessage(message);
		return result;
	}

	private static String defaultMessage(int status, String msg) {
		if (StringUtil.isBlank(msg)) {
			return status == ERROR_STATUS_CODE ?
					DEFAULT_ERROR_PHRASE : DEFAULT_SUCCESS_PHRASE;
		}
		return msg;
	}
}
