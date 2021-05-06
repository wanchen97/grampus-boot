package com.vdegree.grampus.admin.modules.system.security.exception;

import com.vdegree.grampus.common.core.exception.BaseException;
import com.vdegree.grampus.common.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author Beck
 * @date 2020-12-16
 */
@Slf4j
@RestControllerAdvice
public class SystemExceptionHandler {

	/**
	 * 通用异常
	 */
	@ExceptionHandler(Exception.class)
	public Result<Object> handleException(Exception e) {
		if (e instanceof BaseException) {
			BaseException ex = (BaseException) e;
			Result.error(ex.getCode(), null);
		}
		log.error(e.getMessage(), e);
		return Result.error(SystemSecurityErrorCode.BASE_ERROR_CODE, null);
	}

	/**
	 * 检索用户信息异常
	 */
	@ExceptionHandler(InternalAuthenticationServiceException.class)
	public Result<Object> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
		log.error(e.getMessage());
		if (e.getCause() instanceof BaseException) {
			BaseException ex = (BaseException) e.getCause();
			return Result.error(ex.getCode(), null);
		}
		return Result.error(SystemSecurityErrorCode.USER_PASSWORD_ERROR, null);
	}

	/**
	 * 密码错误异常
	 */
	@ExceptionHandler(BadCredentialsException.class)
	public Result<Object> handleBadCredentialsException(BadCredentialsException e) {
		log.error(e.getMessage());
		return Result.error(SystemSecurityErrorCode.USER_PASSWORD_ERROR, null);
	}

	/**
	 * 接口权限异常
	 */
	@ExceptionHandler(AccessDeniedException.class)
	public Result<Object> handleAccessDeniedException(AccessDeniedException e) {
		log.error(e.getMessage());
		return Result.error(SystemSecurityErrorCode.USER_ACCESS_DENIED_ERROR, null);
	}
}
