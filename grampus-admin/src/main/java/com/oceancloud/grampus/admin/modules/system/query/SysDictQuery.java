package com.oceancloud.grampus.admin.modules.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * SysDictQuery
 *
 * @author Beck
 * @since 2021-08-20
 */
@Data
@Schema(description = "字典类型")
public class SysDictQuery implements Serializable {
	private static final long serialVersionUID = -3279630681521547485L;
	/**
	 * 字典类型
	 */
	@Schema(description = "字典类型")
	private String dictType;
	/**
	 * 字典名称
	 */
	@Schema(description = "字典名称")
	private String dictName;
}
