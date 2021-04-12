package com.vdegree.grampus.common.mybatis.service.impl;

import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.common.core.utils.ReflectUtil;
import com.vdegree.grampus.common.mybatis.mapper.BaseMapper;
import com.vdegree.grampus.common.mybatis.page.PageData;
import com.vdegree.grampus.common.mybatis.service.EnhancedBaseService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Title: 增强的基础服务类，简化Entity与DTO的转换
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-12
 */
public class EnhancedBaseServiceImpl<M extends BaseMapper<T>, T, D> extends BaseServiceImpl<M, T> implements EnhancedBaseService<T, D> {

	protected Class<T> getCurrentEntityClass() {
		return (Class<T>) ReflectUtil.getSuperClassGenericType(getClass(), 1);
	}

	protected Class<D> getCurrentDtoClass() {
		return (Class<D>) ReflectUtil.getSuperClassGenericType(getClass(), 2);
	}


	@Override
	public void save(D dto) {
		T entity = BeanUtil.copy(dto, getCurrentEntityClass());
		insert(entity);
		BeanUtil.copy(entity, dto);
	}

	@Override
	public void saveBatch(List<D> dtoList) {
		saveBatch(dtoList, 100);
	}

	@Override
	public void saveBatch(List<D> dtoList, int batchSize) {
		List<T> entityList = BeanUtil.copyList(dtoList, getCurrentEntityClass());
		insertBatch(entityList, batchSize);
		BeanUtil.copyList(entityList, dtoList, getCurrentDtoClass());
	}

	@Override
	public void modifyById(D dto) {
		
	}

	@Override
	public D queryById(Serializable id) {
		return null;
	}

	@Override
	public D queryOne(D dto) {
		return null;
	}

	@Override
	public List<D> queryList(D dto) {
		return null;
	}

	@Override
	public List<D> queryAll() {
		return null;
	}

	@Override
	public int queryCount(D dto) {
		return 0;
	}

	@Override
	public PageData<D> queryPage(Map<String, Object> params, Class<D> clazz) {
		return null;
	}

	@Override
	public PageData<D> queryPage(D dto, int pageNum, int pageSize) {
		return null;
	}

	@Override
	public PageData<D> queryPage(D dto, int pageNum, int pageSize, boolean withCount) {
		return null;
	}

	@Override
	public PageData<D> queryPage(D dto, int pageNum, int pageSize, boolean withCount, String orderField, String order) {
		return null;
	}
}
