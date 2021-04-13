package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.admin.modules.system.dto.SysRoleDTO;
import com.vdegree.grampus.admin.modules.system.service.SysRoleService;
import com.vdegree.grampus.common.core.constant.Constant;
import com.vdegree.grampus.common.core.result.Result;
import com.vdegree.grampus.common.mybatis.page.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * Title: 系统角色管理
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-21
 */
@Api(tags = "系统角色管理")
@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class SysRoleController {

	private final SysRoleService sysRoleService;

	@ApiOperation("角色分页查询")
	@GetMapping("page")
	@ApiImplicitParams({
			@ApiImplicitParam(name = Constant.PAGE_NUM, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.PAGE_SIZE, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "name", value = "角色名", paramType = "query", dataType = "String")
	})
	@PreAuthorize("hasAuthority('sys:role:page')")
	public Result<PageData<SysRoleDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
		PageData<SysRoleDTO> result = sysRoleService.queryPage(params);
		return Result.success(result);
	}

	@ApiOperation("角色列表")
	@GetMapping("list")
	@PreAuthorize("hasAuthority('sys:role:list')")
	public Result<List<SysRoleDTO>> list() {
		List<SysRoleDTO> result = sysRoleService.queryAll();
		return Result.success(result);
	}

	@ApiOperation("角色信息")
	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('sys:role:info')")
	public Result<SysRoleDTO> get(@PathVariable("id") Long id) {
		SysRoleDTO result = sysRoleService.queryById(id);

//		//查询角色对应的菜单
//		List<Long> menuIdList = sysRoleMenuService.getMenuIdList(id);
//		result.setMenuIdList(menuIdList);
//
//		//查询角色对应的数据权限
//		List<Long> deptIdList = sysRoleDataScopeService.getDeptIdList(id);
//		result.setDeptIdList(deptIdList);

		return Result.success(result);
	}

	@ApiOperation("保存角色")
	@PostMapping
	@PreAuthorize("hasAuthority('sys:role:save')")
	public Result<Void> save(@RequestBody SysRoleDTO dto) {
		sysRoleService.save(dto);
		return Result.success();
	}

	@ApiOperation("修改角色")
	@PutMapping
	@PreAuthorize("hasAuthority('sys:role:update')")
	public Result<Void> update(@RequestBody SysRoleDTO dto) {
		sysRoleService.modifyById(dto);
		return Result.success();
	}

	@ApiOperation("删除角色")
	@DeleteMapping
	@PreAuthorize("hasAuthority('sys:role:delete')")
	public Result<Void> delete(@RequestBody Long[] ids) {
		sysRoleService.deleteBatchIds(Arrays.asList(ids));
		return Result.success();
	}
}