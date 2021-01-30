package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.admin.modules.system.dto.SysDeptDTO;
import com.vdegree.grampus.admin.modules.system.entity.SysDept;
import com.vdegree.grampus.admin.modules.system.service.SysDeptService;
import com.vdegree.grampus.common.core.result.Result;
import com.vdegree.grampus.common.core.utils.BeanCopyUtil;
import com.vdegree.grampus.admin.modules.system.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/dept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;

	@GetMapping("/list")
	public Result<List<SysDeptDTO>> list() {
		List<SysDept> list = sysDeptService.selectList(new SysDept());
		List<SysDeptDTO> deptList = BeanCopyUtil.copyList(list, SysDeptDTO.class);
		return Result.success(TreeUtils.build(deptList));
	}

	@GetMapping("/{id}")
	public Result<SysDeptDTO> get(@PathVariable Long id) {
		SysDept sysDept = sysDeptService.selectById(id);
		return Result.success(BeanCopyUtil.copy(sysDept, SysDeptDTO.class));
	}

	@PostMapping("/save")
	public Result<Void> save(@RequestBody SysDeptDTO sysDeptDTO) {
		SysDept sysDept = BeanCopyUtil.copy(sysDeptDTO, SysDept.class);
		sysDeptService.insert(sysDept);
		return Result.success();
	}

	@PutMapping("/update")
	public Result<Void> update(@RequestBody SysDeptDTO sysDeptDTO) {
		SysDept sysDept = BeanCopyUtil.copy(sysDeptDTO, SysDept.class);
		sysDeptService.updateById(sysDept);
		return Result.success();
	}

	@DeleteMapping("/{id}")
	public Result<Void> delete(@PathVariable Long id) {
		sysDeptService.deleteById(id);
		return Result.success();
	}
}
