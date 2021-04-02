package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.admin.modules.system.dto.SysMenuDTO;
import com.vdegree.grampus.admin.modules.system.service.SysMenuService;
import com.vdegree.grampus.common.core.result.ErrorCode;
import com.vdegree.grampus.common.core.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title: 菜单管理
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-21
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class SysMenuController {

	private final SysMenuService sysMenuService;

//	@GetMapping("nav")
//	public Result<List<SysMenuDTO>> nav(){
//		List<SysMenuDTO> list = sysMenuService.getUserMenuNavList(SecurityUser.getUser());
//		return Result.success(list);
//	}
//
//	@GetMapping("permissions")
//	public Result<Set<String>> permissions(){
//		Set<String> set = sysMenuService.getUserPermissions(SecurityUser.getUser());
//		return Result.success(set);
//	}

	@GetMapping("list")
	@PreAuthorize("hasAuthority('sys:menu:list')")
	public Result<List<SysMenuDTO>> list(Integer type) {
		List<SysMenuDTO> list = sysMenuService.getMenuList(type);
		return Result.success(list);
	}

	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('sys:menu:info')")
	public Result<SysMenuDTO> get(@PathVariable("id") Long id) {
		SysMenuDTO data = sysMenuService.get(id);
		return Result.success(data);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('sys:menu:save')")
	public Result<Void> save(@RequestBody SysMenuDTO dto) {
		sysMenuService.save(dto);
		return Result.success();
	}

	@PutMapping
	@PreAuthorize("hasAuthority('sys:menu:update')")
	public Result<Void> update(@RequestBody SysMenuDTO dto) {
		sysMenuService.update(dto);
		return Result.success();
	}

	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('sys:menu:delete')")
	public Result<Void> delete(@PathVariable("id") Long id) {
		//判断是否有子菜单或按钮
		List<SysMenuDTO> list = sysMenuService.getListPid(id);
		if (list.size() > 0) {
			return Result.error(ErrorCode.SUB_MENU_EXIST);
		}
		sysMenuService.delete(id);
		return Result.success();
	}

//	@GetMapping("select")
//	@PreAuthorize("hasAuthority('sys:menu:select')")
//	public Result<List<SysMenuDTO>> select(){
//		List<SysMenuDTO> list = sysMenuService.getUserMenuList(SecurityUser.getUser(), null);
//		return Result.success(list);
//	}
}