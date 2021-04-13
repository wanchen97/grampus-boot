package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.admin.modules.system.dto.SysParamDTO;
import com.vdegree.grampus.admin.modules.system.service.SysParamService;
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
import java.util.Map;

/**
 * Title: 系统参数管理
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-01-21
 */
@Api(tags = "系统参数管理")
@RestController
@AllArgsConstructor
@RequestMapping("/param")
public class SysParamController {

	private final SysParamService sysParamService;

	@ApiOperation("分页")
	@GetMapping("page")
	@ApiImplicitParams({
			@ApiImplicitParam(name = Constant.PAGE_NUM, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.PAGE_SIZE, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "code", value = "参数编码", paramType = "query", dataType = "String")
	})
	@PreAuthorize("hasAuthority('sys:params:page')")
	public Result<PageData<SysParamDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
		PageData<SysParamDTO> result = sysParamService.queryPage(params);
		return Result.success(result);
	}

	@ApiOperation("信息")
	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('sys:params:info')")
	public Result<SysParamDTO> get(@PathVariable("id") Long id) {
		SysParamDTO result = sysParamService.queryById(id);
		return Result.success(result);
	}

	@ApiOperation("保存")
	@PostMapping
	@PreAuthorize("hasAuthority('sys:params:save')")
	public Result<Void> save(@RequestBody SysParamDTO dto) {
		sysParamService.save(dto);
		return Result.success();
	}

	@ApiOperation("修改")
	@PutMapping
	@PreAuthorize("hasAuthority('sys:params:update')")
	public Result<Void> update(@RequestBody SysParamDTO dto) {
		sysParamService.modifyById(dto);
		return Result.success();
	}

	@ApiOperation("删除")
	@DeleteMapping
	@PreAuthorize("hasAuthority('sys:params:delete')")
	public Result<Void> delete(@RequestBody Long[] ids) {
		sysParamService.deleteBatchIds(Arrays.asList(ids));
		return Result.success();
	}
}