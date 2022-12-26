package com.oceancloud.grampus.admin.modules.security.exception;

import com.oceancloud.grampus.admin.code.ErrorCode;
import com.oceancloud.grampus.framework.core.exception.ApiException;
import com.oceancloud.grampus.framework.core.result.Result;
import com.oceancloud.grampus.framework.core.utils.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 全局异常处理器
 *
 * @author Beck
 * @since 2020-12-16
 */
@Slf4j
@RestControllerAdvice
public class SystemExceptionHandler {

	/**
	 * 通用异常
	 */
	@ExceptionHandler(Exception.class)
	public Result<Object> handleException(Exception e) {
		if (e instanceof ApiException) {
			ApiException ex = (ApiException) e;
			return Result.error(ex.getCode(), null);
		}
		log.error(e.getMessage(), e);
		return Result.error(ErrorCode.Global.UNKNOWN_ERROR_CODE.getCode(), ErrorCode.Global.UNKNOWN_ERROR_CODE.getMsg());
	}

	/**
	 * 检索用户信息异常
	 */
	@ExceptionHandler(InternalAuthenticationServiceException.class)
	public Result<Object> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
		if (e.getCause() instanceof ApiException) {
			ApiException ex = (ApiException) e.getCause();
			return Result.error(ex.getCode(), null);
		}
		log.error(e.getMessage(), e);
		return Result.error(ErrorCode.Auth.USER_PASSWORD_ERROR.getCode(), ErrorCode.Auth.USER_PASSWORD_ERROR.getMsg());
	}

	/**
	 * 密码错误异常
	 */
	@ExceptionHandler(BadCredentialsException.class)
	public Result<Object> handleBadCredentialsException(BadCredentialsException e) {
		log.error(e.getMessage(), e);
		return Result.error(ErrorCode.Auth.USER_PASSWORD_ERROR.getCode(), ErrorCode.Auth.USER_PASSWORD_ERROR.getMsg());
	}

	/**
	 * 接口权限异常
	 */
	@ExceptionHandler(AccessDeniedException.class)
	public Result<Object> handleAccessDeniedException(AccessDeniedException e) {
		log.error(e.getMessage(), e);
		return Result.error(ErrorCode.Auth.USER_ACCESS_DENIED_ERROR.getCode(), ErrorCode.Auth.USER_ACCESS_DENIED_ERROR.getMsg());
	}

	/**
	 * Post请求参数校验异常
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		FieldError fieldError = ex.getBindingResult().getFieldError();
		return Result.error(ErrorCode.Global.PARAMS_ERROR_CODE.getCode(), fieldError.getDefaultMessage());
	}

	/**
	 * Get请求参数校验异常
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public Result<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> eSet = ex.getConstraintViolations();
		StringBuilder sb = new StringBuilder();
		if(!CollectionUtil.isEmpty(eSet)) {
			for (ConstraintViolation<?> constraintViolation : eSet) {
				sb.append(constraintViolation.getMessage()).append("::");
			}
		}
		return Result.error(ErrorCode.Global.PARAMS_ERROR_CODE.getCode(), sb.toString());
	}

	/**
	 * 方法签名参数错误异常
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public Result<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
		return Result.error(ErrorCode.Global.PARAMS_ERROR_CODE.getCode(), ex.getMessage());
	}
}
