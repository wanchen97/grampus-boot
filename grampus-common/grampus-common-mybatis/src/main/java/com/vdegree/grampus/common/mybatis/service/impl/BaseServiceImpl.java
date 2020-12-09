package com.vdegree.grampus.common.mybatis.service.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import com.vdegree.grampus.common.mybatis.mapper.BaseMapper;
import com.vdegree.grampus.common.mybatis.service.BaseService;
import com.vdegree.grampus.common.mybatis.utils.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

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
	public void logicDelete(Long[] ids, Class<T> entity) {

	}

	@Override
	public void insert(T entity) {
		baseMapper.insertSelective(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBatch(List<T> entityList) {
		this.insertBatch(entityList, 100);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBatch(List<T> entityList, int batchSize) {
		if (CollectionUtils.isEmpty(entityList)) {
			throw new IllegalArgumentException("Error: entityList must not be empty");
		}
		if (entityList.size() <= batchSize) {
			for (T entity : entityList) {
				baseMapper.insertSelective(entity);
			}
		}
		List<List<T>> partitionList = Lists.partition(entityList, batchSize);
		partitionList.forEach(anEntityList -> {
			for (T entity : entityList) {
				baseMapper.insertSelective(entity);
			}
		});
	}

	@Override
	public void updateById(T entity) {
		baseMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void update(T entity, Example example) {
		baseMapper.updateByExampleSelective(entity, example);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateBatchById(List<T> entityList) {
		this.updateBatchById(entityList, 100);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateBatchById(List<T> entityList, int batchSize) {
		if (CollectionUtils.isEmpty(entityList)) {
			throw new IllegalArgumentException("Error: entityList must not be empty");
		}
		if (entityList.size() <= batchSize) {
			for (T entity : entityList) {
				baseMapper.updateByPrimaryKeySelective(entity);
			}
		}
		List<List<T>> partitionList = Lists.partition(entityList, batchSize);
		partitionList.forEach(anEntityList -> {
			for (T entity : entityList) {
				baseMapper.updateByPrimaryKeySelective(entity);
			}
		});
	}

	@Override
	public T selectById(Serializable id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Serializable id) {
		baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteBatchIds(Collection<? extends Serializable> idList) {
		baseMapper.deleteByIds(Joiner.on(",").join(idList));
	}
}
