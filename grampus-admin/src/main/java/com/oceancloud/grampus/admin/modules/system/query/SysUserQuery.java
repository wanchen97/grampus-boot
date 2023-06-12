package com.oceancloud.grampus.admin.modules.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * SysUserQuery
 *
 * @author Beck
 * @since 2021-08-20
 */
@Data
@Schema(description = "系统用户")
public class SysUserQuery implements Serializable {
	private static final long serialVersionUID = 4348801592592671669L;
	/**
	 * 员工号
	 */
	@Schema(description = "员工号")
	private String userNo;
	/**
	 * 姓名
	 */
	@Schema(description = "姓名")
	private String name;
}
