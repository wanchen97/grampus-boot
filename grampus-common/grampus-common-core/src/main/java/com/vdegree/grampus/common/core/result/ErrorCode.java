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
    /** 基础错误码 */
    String BASE_ERROR_CODE = "110000";
    /** 接口入参通用异常 */
    String BASE_PARAMS_ERROR = "110001";
    /** 签名错误异常 */
    String SIGNATURE_ERROR = "110002";
    /** RPC调度异常 */
    String RPC_INVOKE_ERROR = "110003";
    /** 修改密码与原密码一致异常 */
    String SAME_PASSWORD_ERROR = "110004";
    /** 会员不存在异常 */
    String MEMBER_NOT_EXISTED = "110005";
    /** 密码错误异常 */
    String MEMBER_PASSWORD_ERROR = "110006";
    /** 验证码错误异常 */
    String CAPTCHA_ERROR = "110007";
    /** 会员账号冻结异常 */
    String MEMBER_FREEZE_ERROR = "110008";
    /** 对方会员账号冻结异常 */
    String TARGET_MEMBER_FREEZE_ERROR = "110009";
    /** 参数解析异常(加密接口) */
    String PARAMS_DECODE_ERROR = "110010";
    /** 会员已删除 */
    String MEMBER_DELETED_ERROR = "110011";
}
