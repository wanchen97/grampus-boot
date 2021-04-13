package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.admin.modules.system.dto.SysDictItemDTO;
import com.vdegree.grampus.admin.modules.system.service.SysDictItemService;
import com.vdegree.grampus.common.core.result.Result;
import io.swagger.annotations.Api;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Title: 字典数据项接口
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-09
 */
@Api(tags = "字典详情管理")
@RestController
@AllArgsConstructor
@RequestMapping("/dict/item")
public class SysDictItemController {

	private final SysDictItemService sysDictItemService;

	@ApiOperation("字典详细")
	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('sys:dict:info')")
	public Result<SysDictItemDTO> get(@PathVariable("id") Long id) {
		SysDictItemDTO sysDictItemDTO = sysDictItemService.queryById(id);
		return Result.success(sysDictItemDTO);
	}

	@PostMapping
	@ApiOperation("保存字典详细")
	@PreAuthorize("hasAuthority('sys:dict:save')")
	public Result<Void> save(@RequestBody SysDictItemDTO dto){
		sysDictItemService.save(dto);
		return Result.success();
	}

	@PutMapping
	@ApiOperation("更新字典详情")
	@PreAuthorize("hasAuthority('sys:dict:update')")
	public Result<Void> update(@RequestBody SysDictItemDTO dto){
		sysDictItemService.modifyById(dto);
		return Result.success();
	}

	@DeleteMapping
	@ApiOperation("删除字典详情")
	@PreAuthorize("hasAuthority('sys:dict:delete')")
	public Result<Void> delete(@RequestBody Long[] ids){
		sysDictItemService.deleteBatchIds(Arrays.asList(ids));
		return Result.success();
	}
}
