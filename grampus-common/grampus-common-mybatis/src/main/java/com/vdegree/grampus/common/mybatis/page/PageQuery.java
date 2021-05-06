package com.vdegree.grampus.common.mybatis.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询参数
 *
 * @author Beck
 * @date 2021-04-12
 */
@ApiModel("分页查询参数")
@Data
public class PageQuery implements Serializable {
	private static final long serialVersionUID = 5153822821409425132L;
	/**
	 * 当前页数
	 */
	@ApiModelProperty("当前页数")
	protected Integer pageNum;
	/**
	 * 每页数据量
	 */
	@ApiModelProperty("每页数据量")
	protected Integer pageSize;
	/**
	 * 排序字段
	 */
	@ApiModelProperty("排序字段")
	protected String orderField;
	/**
	 * 排序（asc升序 desc倒序）
	 */
	@ApiModelProperty("排序（asc升序 desc倒序）")
	protected String order;
	/**
	 * 是否查count（true查count false不查count）
	 */
	@ApiModelProperty("是否查count（true查count false不查count）")
	protected Boolean withCount;
}
