package com.vdegree.grampus.admin.modules.system.security.exception;

import com.vdegree.grampus.common.core.exception.BaseException;
import com.vdegree.grampus.common.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Title: 全局异常处理器
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-16
 */
@Slf4j
@RestControllerAdvice
public class SystemExceptionHandler {

	@ExceptionHandler(BaseException.class)
	public Result<Object> handleBaseException(BaseException e){
		log.error(e.getMessage(), e);
		return Result.error(e.getCode(), null);
	}

	@ExceptionHandler(Exception.class)
	public Result<Object> handleException(Exception e){
		if (e instanceof BaseException) {
			BaseException ex = (BaseException) e;
			Result.error(ex.getCode(), null);
		}
		log.error(e.getMessage(), e);
		return Result.error(SystemSecurityErrorCode.BASE_ERROR_CODE, null);
	}

	@ExceptionHandler(InternalAuthenticationServiceException.class)
	public Result<Object> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
		log.error(e.getMessage());
		if (e.getCause() instanceof BaseException) {
			BaseException ex = (BaseException) e.getCause();
			return Result.error(ex.getCode(), null);
		}
		return Result.error(SystemSecurityErrorCode.USER_PASSWORD_ERROR, null);
	}

	@ExceptionHandler(BadCredentialsException.class)
	public Result<Object> handleBadCredentialsException(BadCredentialsException e) {
		log.error(e.getMessage());
		return Result.error(SystemSecurityErrorCode.USER_PASSWORD_ERROR, null);
	}
}
