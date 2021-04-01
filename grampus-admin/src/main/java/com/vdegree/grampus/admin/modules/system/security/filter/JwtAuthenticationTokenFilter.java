package com.vdegree.grampus.admin.modules.system.security.filter;

import com.vdegree.grampus.admin.modules.system.security.manager.JwtTokenManager;
import com.vdegree.grampus.common.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token过滤器
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-15
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenManager tokenManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String jwt = resolveToken(request);
		if (StringUtil.isNotBlank(jwt) && SecurityContextHolder.getContext().getAuthentication() == null) {
			this.tokenManager.validateToken(jwt);
			Authentication authentication = tokenManager.getAuthentication(jwt);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		chain.doFilter(request, response);
	}

	/**
	 * Get token from header.
	 */
	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtil.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return bearerToken;
	}
}
