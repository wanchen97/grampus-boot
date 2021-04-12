package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.admin.modules.system.dto.SysDictDTO;
import com.vdegree.grampus.admin.modules.system.entity.SysDict;
import com.vdegree.grampus.admin.modules.system.service.SysDictService;
import com.vdegree.grampus.common.core.constant.Constant;
import com.vdegree.grampus.common.core.result.Result;
import com.vdegree.grampus.common.core.utils.BeanUtil;
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
 * Title: 字典管理
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-21
 */
@Api(tags = "字典管理")
@RestController
@AllArgsConstructor
@RequestMapping("/dict")
public class SysDictController {

	private final SysDictService sysDictService;

	@GetMapping("page")
	@ApiOperation("字典分页查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = Constant.PAGE_NUM, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.PAGE_SIZE, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = Constant.WITH_COUNT, value = "查询数据总量(true、false)", paramType = "query", dataType = "Boolean"),
			@ApiImplicitParam(name = "dictType", value = "字典类型", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dictName", value = "字典名称", paramType = "query", dataType = "String")
	})
	@PreAuthorize("hasAuthority('sys:dict:list')")
	public Result<PageData<SysDict>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
		PageData<SysDict> page = sysDictService.selectPage(params, SysDict.class);
		return Result.success(page);
	}

	@GetMapping("{id}")
	@ApiOperation("字典信息")
	@PreAuthorize("hasAuthority('sys:dict:info')")
	public Result<SysDictDTO> get(@PathVariable("id") Long id) {
		SysDict data = sysDictService.selectById(id);
		return Result.success(BeanUtil.copy(data, SysDictDTO.class));
	}

	@PostMapping
	@ApiOperation("字典保存")
	@PreAuthorize("hasAuthority('sys:dict:save')")
	public Result<Void> save(@RequestBody SysDictDTO params) {
		sysDictService.insert(BeanUtil.copy(params, SysDict.class));
		return Result.success();
	}

	@PutMapping
	@ApiOperation("字典修改")
	@PreAuthorize("hasAuthority('sys:dict:update')")
	public Result<Void> update(@RequestBody SysDictDTO params) {
		sysDictService.updateById(BeanUtil.copy(params, SysDict.class));
		return Result.success();
	}

	@DeleteMapping
	@ApiOperation("字典删除")
	@PreAuthorize("hasAuthority('sys:dict:delete')")
	public Result<Void> delete(@RequestBody Long[] ids) {
		sysDictService.deleteBatchIds(Arrays.asList(ids));
		return Result.success();
	}

	@GetMapping("all")
	@ApiOperation("所有字典数据")
	public Result<List<SysDictDTO>> all() {
		List<SysDict> list = sysDictService.selectAll();
		return Result.success(BeanUtil.copyList(list, SysDictDTO.class));
	}

	@GetMapping("list")
	@ApiOperation("字典列表")
	public Result<List<SysDictDTO>> list() {
		List<SysDict> list = sysDictService.getSysDictList();
		return Result.success(BeanUtil.copyList(list, SysDictDTO.class));
	}
}
