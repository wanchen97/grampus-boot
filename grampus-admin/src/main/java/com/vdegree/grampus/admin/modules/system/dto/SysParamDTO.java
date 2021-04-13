package com.vdegree.grampus.admin.modules.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Title: 系统参数DTO
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-13
 */
@Data
@ApiModel("系统参数")
public class SysParamDTO implements Serializable {
	private static final long serialVersionUID = -6988841582283661929L;
	/**
	 * 数据ID
	 */
	@ApiModelProperty("数据ID")
	private Long id;
	/**
	 * 参数编码
	 */
	@ApiModelProperty("参数编码")
	private String code;
	/**
	 * 参数值
	 */
	@ApiModelProperty("参数值")
	private String value;
	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String remark;
	/**
	 * 创建者
	 */
	@ApiModelProperty("创建者")
	private Long createBy;
	/**
	 * 创建日期
	 */
	@ApiModelProperty("创建日期")
	private Date createDate;
	/**
	 * 更新者
	 */
	@ApiModelProperty("更新者")
	private Long updateBy;
	/**
	 * 更新日期
	 */
	@ApiModelProperty("更新日期")
	private Date updateDate;
}
