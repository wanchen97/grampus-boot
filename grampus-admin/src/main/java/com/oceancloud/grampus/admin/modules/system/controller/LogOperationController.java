package com.oceancloud.grampus.admin.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oceancloud.grampus.admin.modules.system.entity.LogOperation;
import com.oceancloud.grampus.admin.modules.system.excel.LogOperationExcel;
import com.oceancloud.grampus.admin.modules.system.query.LogOperationQuery;
import com.oceancloud.grampus.framework.core.result.Result;
import com.oceancloud.grampus.framework.core.utils.BeanUtil;
import com.oceancloud.grampus.framework.excel.annotation.ResponseExcel;
import com.oceancloud.grampus.framework.mybatis.page.PageData;
import com.oceancloud.grampus.framework.mybatis.page.PageQuery;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oceancloud.grampus.admin.modules.system.dto.LogOperationDTO;
import com.oceancloud.grampus.admin.modules.system.service.LogOperationService;

import java.util.List;

/**
 * 操作日志表(LogOperation) 表控制层
 *
 * @author Beck
 * @since 2021-05-31
 */
@Tag(name = "日志管理")
@RestController
@AllArgsConstructor
@RequestMapping("/system/log/operation")
public class LogOperationController {

	private final LogOperationService logOperationService;

	@Operation(summary = "操作日志分页查询")
	@GetMapping("page")
	@PreAuthorize("hasAuthority('log:operation:list')")
	public Result<PageData<LogOperationDTO>> page(PageQuery pageQuery, LogOperationQuery params) {
		PageData<LogOperationDTO> page = logOperationService.queryPage(pageQuery, params);
		return Result.success(page);
	}

	@Operation(summary = "操作日志导出")
	@GetMapping("export")
	@ResponseExcel(name = "操作日志")
	@PreAuthorize("hasAuthority('log:operation:export')")
	@Parameters({
			@Parameter(name = "module", description = "所属模块", in = ParameterIn.QUERY),
			@Parameter(name = "successful", description = "是否成功(true、false)", in = ParameterIn.QUERY),
	})
	public List<LogOperationExcel> export(@Parameter(hidden = true) LogOperationQuery params) {
		LogOperation queryParams = BeanUtil.copy(params, LogOperation.class);
		List<LogOperation> list = logOperationService.fastList(new QueryWrapper<>(queryParams));
		return BeanUtil.copyList(list, LogOperationExcel.class);
	}
}
