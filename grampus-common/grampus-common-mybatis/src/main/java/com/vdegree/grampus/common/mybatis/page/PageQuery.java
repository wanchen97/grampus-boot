package com.vdegree.grampus.common.mybatis.page;

import lombok.Data;

import java.io.Serializable;

/**
 * Title: 分页查询参数
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-12
 */
@Data
public class PageQuery implements Serializable {
	private static final long serialVersionUID = 5153822821409425132L;
	/**
	 * 当前页数
	 */
	protected Integer pageNum;
	/**
	 * 每页数据量
	 */
	protected Integer pageSize;
	/**
	 * 排序字段
	 */
	protected String orderField;
	/**
	 * 排序（asc升序 desc倒序）
	 */
	protected String order;
}
