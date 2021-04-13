package com.vdegree.grampus.common.mybatis.page;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * Title: 分页数据结构
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-12
 */
@Data
public class PageData<T> {
	/**
	 * 当前页
	 */
	private int pageNum;
	/**
	 * 每页的数量
	 */
	private int pageSize;
	/**
	 * 总页数
	 */
	private int pages;
	/**
	 * 是否为最后一页
	 */
	private boolean lastPage;
	/**
	 * 总记录数
	 */
	private long total;
	/**
	 * 列表数据
	 */
	private List<T> list;

	public PageData() {
	}

	public PageData(PageData<?> pageData, List<T> list) {
		this.setPageNum(pageData.getPageNum());
		this.setPageSize(pageData.getPageSize());
		this.setPages(pageData.getPages());
		this.setLastPage(pageData.isLastPage());
		this.setTotal(pageData.getTotal());
		this.setList(list);
	}

	public PageData(PageInfo<T> pageInfo) {
		this.setPageNum(pageInfo.getPageNum());
		this.setPageSize(pageInfo.getPageSize());
		this.setPages(pageInfo.getPages());
		this.setTotal(pageInfo.getTotal());
		this.setLastPage(pageInfo.isIsLastPage());
		this.setList(pageInfo.getList());
	}
}
