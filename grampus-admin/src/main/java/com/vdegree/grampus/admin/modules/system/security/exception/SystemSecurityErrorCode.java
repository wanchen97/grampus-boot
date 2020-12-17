package com.vdegree.grampus.admin.modules.system.security.exception;

/**
 * Title: 用户认证错误码
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-16
 */
public interface SystemSecurityErrorCode {

	/** 基础错误码 */
	String BASE_ERROR_CODE = "120000";
	/** 接口入参通用异常 */
	String BASE_PARAMS_ERROR = "120001";
	/** 会员不存在异常 */
	String USER_NOT_EXISTED = "120002";
	/** 密码错误异常 */
	String USER_PASSWORD_ERROR = "120003";
	/** 用户账号禁用异常 */
	String USER_DISABLE_ERROR = "120004";
	/** 验证码错误异常 */
	String CAPTCHA_ERROR = "120005";
}
