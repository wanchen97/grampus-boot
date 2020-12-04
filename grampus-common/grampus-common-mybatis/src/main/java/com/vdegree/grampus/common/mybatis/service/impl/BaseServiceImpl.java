package com.vdegree.grampus.common.mybatis.service.impl;

import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import com.vdegree.grampus.common.mybatis.mapper.BaseMapper;
import com.vdegree.grampus.common.mybatis.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Collection;

/**
 * Title: 基础服务类，所有Service接口都要继承(继承后即可获得BaseMapper的CRUD功能)
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T> {

	@Autowired
	private M baseMapper;

	@Override
	public boolean logicDelete(Long[] ids, Class<T> entity) {
		return false;
	}

	@Override
	public boolean insert(T entity) {
		return false;
	}

	@Override
	public boolean insertBatch(Collection<T> entityList) {
		return false;
	}

	@Override
	public boolean insertBatch(Collection<T> entityList, int batchSize) {
		return false;
	}

	@Override
	public boolean updateById(T entity) {
		return false;
	}

	@Override
	public boolean update(T entity, Example example) {
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<T> entityList) {
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<T> entityList, int batchSize) {
		return false;
	}

	@Override
	public T selectById(Serializable id) {
		return null;
	}

	@Override
	public boolean deleteById(Serializable id) {
		return false;
	}

	@Override
	public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
		return false;
	}
}
