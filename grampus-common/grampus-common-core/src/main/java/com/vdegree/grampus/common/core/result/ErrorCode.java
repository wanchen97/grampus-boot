package com.vdegree.grampus.common.core.result;

/**
 * 错误编码，由5位数字组成，前2位为模块编码，后3位为业务编码
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-5
 */
public interface ErrorCode {
	/**
	 * code
	 */
	Integer INTERNAL_SERVER_ERROR = 500;
	Integer UNAUTHORIZED = 401;
	Integer FORBIDDEN = 403;

	/**
	 * errorCode
	 */
	/**
	 * 基础错误码
	 */
	String BASE_ERROR_CODE = "BASE_ERROR_CODE";
	/**
	 * 接口入参通用异常
	 */
	String BASE_PARAMS_ERROR = "BASE_PARAMS_ERROR";
	/**
	 * 签名错误异常
	 */
	String SIGNATURE_ERROR = "SIGNATURE_ERROR";
	/**
	 * RPC调度异常
	 */
	String RPC_INVOKE_ERROR = "RPC_INVOKE_ERROR";
	/**
	 * 修改密码与原密码一致异常
	 */
	String SAME_PASSWORD_ERROR = "SAME_PASSWORD_ERROR";
	/**
	 * 会员不存在异常
	 */
	String MEMBER_NOT_EXISTED = "MEMBER_NOT_EXISTED";
	/**
	 * 密码错误异常
	 */
	String MEMBER_PASSWORD_ERROR = "MEMBER_PASSWORD_ERROR";
	/**
	 * 验证码错误异常
	 */
	String CAPTCHA_ERROR = "CAPTCHA_ERROR";
	/**
	 * 会员账号冻结异常
	 */
	String MEMBER_FREEZE_ERROR = "MEMBER_FREEZE_ERROR";
	/**
	 * 对方会员账号冻结异常
	 */
	String TARGET_MEMBER_FREEZE_ERROR = "TARGET_MEMBER_FREEZE_ERROR";
	/**
	 * 参数解析异常(加密接口)
	 */
	String PARAMS_DECODE_ERROR = "PARAMS_DECODE_ERROR";
	/**
	 * 会员已删除
	 */
	String MEMBER_DELETED_ERROR = "MEMBER_DELETED_ERROR";

	String SUB_MENU_EXIST = "SUB_MENU_EXIST";
}
