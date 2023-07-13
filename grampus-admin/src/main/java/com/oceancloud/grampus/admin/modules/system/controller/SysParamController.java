package com.oceancloud.grampus.admin.modules.system.controller;

import com.oceancloud.grampus.admin.modules.system.dto.SysParamDTO;
import com.oceancloud.grampus.admin.modules.system.excel.SysParamExcel;
import com.oceancloud.grampus.admin.modules.system.query.SysParamQuery;
import com.oceancloud.grampus.admin.modules.system.service.SysParamService;
import com.oceancloud.grampus.framework.core.result.Result;
import com.oceancloud.grampus.framework.core.utils.BeanUtil;
import com.oceancloud.grampus.framework.excel.annotation.ResponseExcel;
import com.oceancloud.grampus.framework.log.annotation.RequestLog;
import com.oceancloud.grampus.framework.mybatis.page.PageData;
import com.oceancloud.grampus.framework.mybatis.page.PageQuery;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
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

import java.util.List;

/**
 * 系统参数管理
 *
 * @author Beck
 * @since 2021-01-21
 */
@Tag(name = "系统参数管理")
@RestController
@AllArgsConstructor
@RequestMapping("/system/param")
public class SysParamController {

	private final SysParamService sysParamService;

	@Operation(summary = "参数分页查询")
	@GetMapping("page")
	@PreAuthorize("hasAuthority('sys:param:list')")
	public Result<PageData<SysParamDTO>> page(PageQuery pageQuery, SysParamQuery params) {
		PageData<SysParamDTO> result = sysParamService.queryPage(pageQuery, params);
		return Result.success(result);
	}

	@Operation(summary = "参数信息")
	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('sys:param:info')")
	public Result<SysParamDTO> get(@PathVariable("id") Long id) {
		SysParamDTO result = sysParamService.queryById(id);
		return Result.success(result);
	}

	@RequestLog("保存参数")
	@Operation(summary = "保存参数")
	@PostMapping
	@PreAuthorize("hasAuthority('sys:param:save')")
	public Result<Void> save(@RequestBody SysParamDTO dto) {
		sysParamService.saveOne(dto);
		return Result.success();
	}

	@RequestLog("修改参数")
	@Operation(summary = "修改参数")
	@PutMapping
	@PreAuthorize("hasAuthority('sys:param:update')")
	public Result<Void> update(@RequestBody SysParamDTO dto) {
		sysParamService.modifyById(dto);
		return Result.success();
	}

	@RequestLog("删除参数")
	@Operation(summary = "删除参数")
	@DeleteMapping
	@PreAuthorize("hasAuthority('sys:param:delete')")
	public Result<Void> delete(@RequestBody List<Long> ids) {
		sysParamService.removeBatchByIds(ids);
		return Result.success();
	}

	@RequestLog("导出系统参数Excel")
	@Operation(summary = "Excel导出")
	@GetMapping("export")
	@ResponseExcel(name = "系统参数")
	@PreAuthorize("hasAuthority('sys:param:export')")
	@Parameters(@Parameter(name = "code", description = "参数编码", in = ParameterIn.QUERY))
	public List<SysParamExcel> export(@Parameter(hidden = true) @RequestParam SysParamQuery params) {
		List<SysParamDTO> list = sysParamService.queryList(BeanUtil.copy(params, SysParamDTO.class));
		return BeanUtil.copyList(list, SysParamExcel.class);
	}
}