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
 * 增强的基础服务类，简化Entity与DTO的转换
 *
 * @author Beck
 * @since 2021-04-12
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
		T entity = BeanUtil.copy(dto, getCurrentEntityClass());
		updateById(entity);
	}

	@Override
	public D queryById(Serializable id) {
		T result = selectById(id);
		return BeanUtil.copy(result, getCurrentDtoClass());
	}

	@Override
	public D queryOne(D dto) {
		T params = BeanUtil.copy(dto, getCurrentEntityClass());
		T result = selectOne(params);
		return BeanUtil.copy(result, getCurrentDtoClass());
	}

	@Override
	public List<D> queryList(D dto) {
		T params = BeanUtil.copy(dto, getCurrentEntityClass());
		List<T> result = selectList(params);
		return BeanUtil.copyList(result, getCurrentDtoClass());
	}

	@Override
	public List<D> queryAll() {
		List<T> result = selectAll();
		return BeanUtil.copyList(result, getCurrentDtoClass());
	}

	@Override
	public int queryCount(D dto) {
		T params = BeanUtil.copy(dto, getCurrentEntityClass());
		return selectCount(params);
	}

	@Override
	public PageData<D> queryPage(Map<String, Object> params) {
		PageData<T> result = selectPage(params, getCurrentEntityClass());
		List<D> dList = BeanUtil.copyList(result.getList(), getCurrentDtoClass());
		return new PageData<>(result, dList);
	}

	@Override
	public PageData<D> queryPage(D dto, int pageNum, int pageSize) {
		return this.queryPage(dto, pageNum, pageSize, true);
	}

	@Override
	public PageData<D> queryPage(D dto, int pageNum, int pageSize, boolean withCount) {
		return this.queryPage(dto, pageNum, pageSize, withCount, null, null);
	}

	@Override
	public PageData<D> queryPage(D dto, int pageNum, int pageSize, boolean withCount, String orderField, String order) {
		T entity = BeanUtil.copy(dto, getCurrentEntityClass());
		PageData<T> result = selectPage(entity, pageNum, pageSize, withCount, orderField, order);
		List<D> dList = BeanUtil.copyList(result.getList(), getCurrentDtoClass());
		return new PageData<>(result, dList);
	}
}
