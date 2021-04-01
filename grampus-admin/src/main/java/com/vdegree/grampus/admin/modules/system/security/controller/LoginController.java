package com.vdegree.grampus.admin.modules.system.security.controller;

import com.google.common.collect.Maps;
import com.vdegree.grampus.admin.modules.system.entity.SysUser;
import com.vdegree.grampus.admin.modules.system.security.manager.JwtTokenManager;
import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetailsService;
import com.vdegree.grampus.admin.modules.system.service.SysUserService;
import com.vdegree.grampus.common.core.result.Result;
import com.vdegree.grampus.common.core.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * Title: 登陆控制器
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-15
 */
@Slf4j
@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private SystemUserDetailsService systemUserDetailsService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenManager jwtTokenManager;

	@PostMapping("/register")
	public Result<Void> register(@RequestBody Map<String, Object> params) {
		String userNo = (String) params.get("userNo");
		String password = (String) params.get("password");
		String name = (String) params.get("name");

		if (StringUtil.isBlank(userNo) || StringUtil.isBlank(password)) {
			throw new IllegalArgumentException("userNo or password is null!");
		}

		SysUser sysUser = new SysUser();
		sysUser.setUserNo(userNo);
		sysUser.setPassword(passwordEncoder.encode(password));
		sysUser.setName(name);
		sysUser.setCreateDate(new Date());
		sysUser.setUpdateDate(new Date());
		sysUserService.insert(sysUser);
		return Result.success();
	}

	@PostMapping("/login")
	public Result<Map<String, Object>> login(@RequestBody Map<String, Object> params) {
		String username = (String) params.get("userNo");
		String password = (String) params.get("password");
		Authentication authentication =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		String token = jwtTokenManager.createToken(authentication);

		Map<String, Object> result = Maps.newHashMap();
		result.put("userDetails", userDetails);
		result.put("token", token);
		return Result.success(result);
	}
}
