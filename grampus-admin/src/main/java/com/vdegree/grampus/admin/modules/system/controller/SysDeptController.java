package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.admin.modules.system.dto.SysDeptDTO;
import com.vdegree.grampus.admin.modules.system.entity.SysDept;
import com.vdegree.grampus.admin.modules.system.service.SysDeptService;
import com.vdegree.grampus.common.core.result.Result;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.admin.modules.system.utils.TreeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Title: 部门管理
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-21
 */
@Api(tags = "部门管理")
@RestController
@RequestMapping("/dept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;

	@ApiOperation("部门列表")
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('sys:dept:list')")
	public Result<List<SysDeptDTO>> list() {
		List<SysDept> list = sysDeptService.selectList(new SysDept());
		List<SysDeptDTO> deptList = BeanUtil.copyList(list, SysDeptDTO.class);
		return Result.success(TreeUtils.build(deptList));
	}

	@ApiOperation("部门信息")
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('sys:dept:info')")
	public Result<SysDeptDTO> get(@PathVariable Long id) {
		SysDept sysDept = sysDeptService.selectById(id);
		return Result.success(BeanUtil.copy(sysDept, SysDeptDTO.class));
	}

	@ApiOperation("部门保存")
	@PostMapping("/save")
	@PreAuthorize("hasAuthority('sys:dept:save')")
	public Result<Void> save(@RequestBody SysDeptDTO sysDeptDTO) {
		SysDept sysDept = BeanUtil.copy(sysDeptDTO, SysDept.class);
		sysDeptService.insert(sysDept);
		return Result.success();
	}

	@ApiOperation("部门更新")
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('sys:dept:update')")
	public Result<Void> update(@RequestBody SysDeptDTO sysDeptDTO) {
		SysDept sysDept = BeanUtil.copy(sysDeptDTO, SysDept.class);
		sysDeptService.updateById(sysDept);
		return Result.success();
	}

	@ApiOperation("部门删除")
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('sys:dept:delete')")
	public Result<Void> delete(@PathVariable Long id) {
		sysDeptService.deleteById(id);
		return Result.success();
	}
}
