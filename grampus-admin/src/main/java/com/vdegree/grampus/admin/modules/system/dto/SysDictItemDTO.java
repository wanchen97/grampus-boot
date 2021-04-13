package com.vdegree.grampus.admin.modules.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Title: 字典详情
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-13
 */
@Data
@ApiModel("字典详情")
public class SysDictItemDTO implements Serializable {
	private static final long serialVersionUID = -8288240035977175413L;
	/**
	 * 数据ID
	 */
	@ApiModelProperty("数据ID")
	private Long id;
	/**
	 * 字典ID
	 */
	@ApiModelProperty("字典ID")
	private Long dictId;
	/**
	 * 字典标签
	 */
	@ApiModelProperty("字典标签")
	private String dictLabel;
	/**
	 * 字典值
	 */
	@ApiModelProperty("字典值")
	private String dictValue;
	/**
	 * 排序
	 */
	@ApiModelProperty("排序")
	private Integer sort;
	/**
	 * 创建者
	 */
	@ApiModelProperty("创建者")
	private Long createBy;
	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private Date createDate;
	/**
	 * 更新者
	 */
	@ApiModelProperty("更新者")
	private Long updateBy;
	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
	private Date updateDate;
}