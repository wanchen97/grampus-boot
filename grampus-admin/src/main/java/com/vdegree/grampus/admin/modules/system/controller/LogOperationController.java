package com.vdegree.grampus.admin.modules.system.controller;

import com.vdegree.grampus.common.core.constant.Constant;
import com.vdegree.grampus.common.core.result.Result;
import com.vdegree.grampus.common.mybatis.page.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vdegree.grampus.admin.modules.system.dto.LogOperationDTO;
import com.vdegree.grampus.admin.modules.system.service.LogOperationService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * 操作日志表(LogOperation) 表控制层
 *
 * @author Beck
 * @since 2021-05-31 16:43:11
 */
@Api(tags = "操作日志表")
@RestController
@AllArgsConstructor
@RequestMapping("logOperation")
public class LogOperationController {

	private final LogOperationService logOperationService;

	@ApiOperation("分页查询操作日志")
	@ApiImplicitParams({
			@ApiImplicitParam(name = Constant.PAGE_NUM, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.PAGE_SIZE, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = Constant.WITH_COUNT, value = "查询数据总量(true、false)", paramType = "query", dataType = "Boolean"),
			@ApiImplicitParam(name = "module", value = "所属模块", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "successful", value = "是否成功", paramType = "query", dataType = "Boolean")
	})
	@GetMapping("page")
	@PreAuthorize("hasAuthority('log:operation:page')")
	public Result<PageData<LogOperationDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
		PageData<LogOperationDTO> page = logOperationService.queryPage(params);
		return Result.success(page);
	}
}
