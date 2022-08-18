package com.oceancloud.grampus.admin.modules.security.controller;

import com.google.common.collect.Maps;
import com.oceancloud.grampus.admin.modules.system.dto.SysUserDTO;
import com.oceancloud.grampus.admin.modules.system.dto.SysUserDetailsDTO;
import com.oceancloud.grampus.admin.modules.system.enums.RequestPlatformEnum;
import com.oceancloud.grampus.admin.modules.security.manager.JwtTokenManager;
import com.oceancloud.grampus.admin.modules.security.pojo.LoginReq;
import com.oceancloud.grampus.admin.modules.security.pojo.RegisterReq;
import com.oceancloud.grampus.admin.modules.security.users.SystemUserDetails;
import com.oceancloud.grampus.admin.modules.system.service.SysUserService;
import com.oceancloud.grampus.framework.core.result.Result;
import com.oceancloud.grampus.framework.core.utils.BeanUtil;
import com.oceancloud.grampus.framework.core.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 登陆控制器
 *
 * @author Beck
 * @since 2020-12-15
 */
@Api(tags = "登陆注册")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/system")
public class LoginController {

	private final AuthenticationManager authenticationManager;
	private final SysUserService sysUserService;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenManager jwtTokenManager;

	@ApiOperation("注册接口")
	@PostMapping("/register")
	public Result<Void> register(@RequestBody RegisterReq params) {
		String userNo = params.getUserNo();
		String password = params.getPassword();
		String name = params.getName();

		if (StringUtil.isBlank(userNo) || StringUtil.isBlank(password)) {
			throw new IllegalArgumentException("userNo or password is null!");
		}

		SysUserDTO userDTO = new SysUserDTO();
		userDTO.setUserNo(userNo);
		userDTO.setPassword(passwordEncoder.encode(password));
		userDTO.setName(name);
		sysUserService.saveOne(userDTO);
		return Result.success();
	}

	@ApiOperation("登录接口")
	@PostMapping("/login")
	public Result<Map<String, Object>> login(@RequestBody LoginReq params) {
		String username = params.getUserNo();
		String password = params.getPassword();
		Authentication authentication =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		SystemUserDetails userDetails = (SystemUserDetails) authentication.getPrincipal();
		SysUserDetailsDTO sysUserDetails = BeanUtil.copy(userDetails, SysUserDetailsDTO.class);

		String token = jwtTokenManager.createToken(authentication, RequestPlatformEnum.ADMIN);

		Map<String, Object> result = Maps.newHashMap();
		result.put("userDetails", sysUserDetails);
		result.put("token", token);
		return Result.success(result);
	}
}
