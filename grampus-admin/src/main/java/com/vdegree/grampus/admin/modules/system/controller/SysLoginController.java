package com.vdegree.grampus.admin.modules.system.controller;

//import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.vdegree.grampus.common.auth.common.AuthConfigs;
//import com.vdegree.grampus.common.auth.common.AuthSystemTypes;
//import com.vdegree.grampus.common.auth.exception.AccessException;
//import com.vdegree.grampus.common.core.result.Result;
//import com.vdegree.grampus.admin.modules.system.security.utils.JwtTokenUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: 系统登陆接口
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-09
 */
@RestController
public class SysLoginController {

//	@Autowired
//	private JwtTokenUtils jwtTokenUtils;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private NacosUserDetailsServiceImpl userDetailsService;
//
//	@Autowired
//	private NacosRoleServiceImpl roleService;
//
//	@Autowired
//	private AuthConfigs authConfigs;
//
//	@Autowired
//	private NacosAuthManager authManager;
//
//	public static final String TOKEN = "token";
//
//	public static final String ACCESS_TOKEN = "accessToken";
//
//	public static final String TOKEN_TTL = "tokenTtl";
//
//	public static final String GLOBAL_ADMIN = "globalAdmin";
//
//	/**
//	 * Login to Grampus
//	 *
//	 * <p>This methods uses username and password to require a new token.
//	 *
//	 * @param username username of user
//	 * @param password password
//	 * @param response http response
//	 * @param request  http request
//	 * @return new token of the user
//	 * @throws AccessException if user info is incorrect
//	 */
//	@PostMapping("/login")
//	public Result login(@RequestParam String username, @RequestParam String password, HttpServletResponse response,
//						HttpServletRequest request) throws AccessException {
//
//		if (AuthSystemTypes.SYSTEM.name().equalsIgnoreCase(authConfigs.getAuthSystemType())) {
//			NacosUser user = (NacosUser) authManager.login(request);
//
//			response.addHeader(NacosAuthConfig.AUTHORIZATION_HEADER, NacosAuthConfig.TOKEN_PREFIX + user.getToken());
//
//			ObjectNode result = JacksonUtils.createEmptyJsonNode();
//			//            JSONObject result = new JSONObject();
//			result.put(ACCESS_TOKEN, user.getToken());
//			result.put(TOKEN_TTL, authConfigs.getTokenValidityInSeconds());
//			result.put(GLOBAL_ADMIN, user.isGlobalAdmin());
//			return result;
//		}
//
//		// 通过用户名和密码创建一个 Authentication 认证对象，实现类为 UsernamePasswordAuthenticationToken
//		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//
//		RestResult<String> rr = new RestResult<>();
//		try {
//			//通过 AuthenticationManager（默认实现为ProviderManager）的authenticate方法验证 Authentication 对象
//			Authentication authentication = authenticationManager.authenticate(authenticationToken);
//			//将 Authentication 绑定到 SecurityContext
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//			//生成Token
//			String token = jwtTokenUtils.createToken(authentication);
//			//将Token写入到Http头部
//			response.addHeader(AUTHORIZATION_HEADER, "Bearer " + token);
//			rr.setCode(200);
//			rr.setData("Bearer " + token);
//			return rr;
//		} catch (BadCredentialsException authentication) {
//			rr.setCode(401);
//			rr.setMessage("Login failed");
//			return rr;
//		}
//	}
}
