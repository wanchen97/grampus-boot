package com.oceancloud.grampus.admin.modules.security.filter;

import com.oceancloud.grampus.admin.code.ErrorCode;
import com.oceancloud.grampus.admin.modules.security.exception.TokenExpiredException;
import com.oceancloud.grampus.admin.modules.security.exception.TokenParsedException;
import com.oceancloud.grampus.admin.modules.security.manager.JwtTokenManager;
import com.oceancloud.grampus.admin.modules.security.users.SystemUserDetails;
import com.oceancloud.grampus.framework.core.constant.Constant;
import com.oceancloud.grampus.framework.core.exception.ApiException;
import com.oceancloud.grampus.framework.core.result.Result;
import com.oceancloud.grampus.framework.core.utils.JSONUtil;
import com.oceancloud.grampus.framework.core.utils.StringUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/**
 * Jwt认证过滤器
 *
 * @author Beck
 * @since 2020-12-15
 */
@Component
@AllArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private final JwtTokenManager tokenManager;
	private final UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String jwt = resolveToken(request);
		if (StringUtil.isNotBlank(jwt) && SecurityContextHolder.getContext().getAuthentication() == null) {
			try {
				// TODO Token失效依赖于JWT，无法强制踢出
				tokenManager.validateToken(jwt);
			} catch (ExpiredJwtException e) {
				handleAuthenticationFailure(response, new TokenExpiredException());
				return;
			} catch (Exception e) {
				handleAuthenticationFailure(response, new TokenParsedException());
				return;
			}
			String subject = tokenManager.getSubject(jwt);
			SystemUserDetails userDetails = (SystemUserDetails) userDetailsService.loadUserByUsername(subject);
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		chain.doFilter(request, response);
	}

	/**
	 * Get token from header.
	 */
	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(Constant.AUTHORIZATION_HEADER);
		if (StringUtil.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return bearerToken;
	}

	/**
	 * Handle Authentication Failure.
	 */
	@SneakyThrows
	private void handleAuthenticationFailure(HttpServletResponse response, ApiException e) {
		String code, msg;
		if (e instanceof TokenExpiredException) {
			TokenExpiredException ex = (TokenExpiredException) e;
			code = ex.getCode();
			msg = ex.getMessage();
		} else if (e instanceof TokenParsedException) {
			TokenParsedException ex = (TokenParsedException) e;
			code = ex.getCode();
			msg = ex.getMessage();
		} else {
			code = ErrorCode.Global.UNKNOWN_ERROR_CODE.getCode();
			msg = ErrorCode.Global.UNKNOWN_ERROR_CODE.getMsg();
		}
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(Objects.requireNonNull(JSONUtil.writeValueAsString(Result.unauthorized(code, msg))));
	}
}
