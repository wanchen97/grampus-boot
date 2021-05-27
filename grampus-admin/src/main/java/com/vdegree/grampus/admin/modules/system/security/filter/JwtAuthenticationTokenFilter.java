package com.vdegree.grampus.admin.modules.system.security.filter;

import com.vdegree.grampus.admin.modules.system.code.ErrorCode;
import com.vdegree.grampus.admin.modules.system.security.exception.TokenExpiredException;
import com.vdegree.grampus.admin.modules.system.security.exception.TokenParsedException;
import com.vdegree.grampus.admin.modules.system.security.manager.JwtTokenManager;
import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
import com.vdegree.grampus.common.core.constant.Constant;
import com.vdegree.grampus.common.core.exception.BaseException;
import com.vdegree.grampus.common.core.result.Result;
import com.vdegree.grampus.common.core.utils.JSONUtil;
import com.vdegree.grampus.common.core.utils.StringUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
				tokenManager.validateToken(jwt);
			} catch (ExpiredJwtException e) {
				handleAuthenticationFailure(response, new TokenExpiredException("token expired."));
				return;
			} catch (Exception e) {
				handleAuthenticationFailure(response, new TokenParsedException("token invalid."));
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
	private void handleAuthenticationFailure(HttpServletResponse response, BaseException e) {
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
		response.getWriter().write(Objects.requireNonNull(JSONUtil.writeValueAsString(Result.error(code, msg))));
	}
}
