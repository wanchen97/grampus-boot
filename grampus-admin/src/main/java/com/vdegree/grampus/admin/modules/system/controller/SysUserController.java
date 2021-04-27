package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.admin.modules.system.dto.PasswordDTO;
import com.vdegree.grampus.admin.modules.system.dto.SysUserDTO;
import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
import com.vdegree.grampus.admin.modules.system.security.utils.SecurityUtils;
import com.vdegree.grampus.admin.modules.system.service.SysUserRoleService;
import com.vdegree.grampus.admin.modules.system.service.SysUserService;
import com.vdegree.grampus.common.core.constant.Constant;
import com.vdegree.grampus.common.core.result.ErrorCode;
import com.vdegree.grampus.common.core.result.Result;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.common.mybatis.page.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Title: 系统用户管理
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-21
 */
@Api(tags = "用户管理")
@AllArgsConstructor
@RestController
@RequestMapping("/system/user")
public class SysUserController {
	private final SysUserService sysUserService;
	private final SysUserRoleService sysUserRoleService;
	private final PasswordEncoder passwordEncoder;

	@GetMapping("page")
	@ApiOperation("分页")
	@ApiImplicitParams({
			@ApiImplicitParam(name = Constant.PAGE_NUM, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.PAGE_SIZE, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = Constant.WITH_COUNT, value = "查询数据总量(true、false)", paramType = "query", dataType = "Boolean"),
			@ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "postId", value = "岗位ID", paramType = "query", dataType = "String")
	})
	@PreAuthorize("hasAuthority('sys:user:list')")
	public Result<PageData<SysUserDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
		PageData<SysUserDTO> result = sysUserService.queryPage(params);
		return Result.success(result);
	}

	@GetMapping("{id}")
	@ApiOperation("信息")
	@PreAuthorize("hasAuthority('sys:user:info')")
	public Result<SysUserDTO> get(@PathVariable("id") Long id) {
		SysUserDTO result = sysUserService.queryById(id);
		// 用户角色列表
		List<Long> roleIdList = sysUserRoleService.getRoleIdList(id);
		result.setRoleIdList(roleIdList);
		return Result.success(result);
	}

	@ApiOperation("登录用户信息")
	@GetMapping("info")
	public Result<SysUserDTO> info() {
		SysUserDTO result = BeanUtil.copy(SecurityUtils.getUserDetails(), SysUserDTO.class);
		return Result.success(result);
	}

	@ApiOperation("保存")
	@PostMapping
	@PreAuthorize("hasAuthority('sys:user:save')")
	public Result<Void> save(@RequestBody SysUserDTO dto) {
		sysUserService.save(dto);
		return Result.success();
	}

	@ApiOperation("修改")
	@PutMapping
	@PreAuthorize("hasAuthority('sys:user:update')")
	public Result<Void> update(@RequestBody SysUserDTO dto) {
		sysUserService.modifyById(dto);
		return Result.success();
	}

	@ApiOperation("修改密码")
	@PutMapping("password")
	public Result<Void> password(@RequestBody PasswordDTO dto) {
		SystemUserDetails user = SecurityUtils.getUserDetails();
		if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
			return Result.error(ErrorCode.USER_PASSWORD_ERROR);
		}
		sysUserService.updatePassword(user.getId(), dto.getNewPassword());
		return Result.success();
	}

	@ApiOperation("删除")
	@DeleteMapping
	@PreAuthorize("hasAuthority('sys:user:delete')")
	public Result<Void> delete(@RequestBody Long[] ids) {
		sysUserService.deleteBatchIds(Arrays.asList(ids));
		return Result.success();
	}
}