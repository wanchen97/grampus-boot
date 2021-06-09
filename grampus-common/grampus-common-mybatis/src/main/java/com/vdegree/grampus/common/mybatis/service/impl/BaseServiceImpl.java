package com.vdegree.grampus.common.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.vdegree.grampus.common.core.constant.Constant;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.common.core.utils.StringUtil;
import com.vdegree.grampus.common.core.utils.chars.StringPool;
import com.vdegree.grampus.common.mybatis.mapper.BaseMapper;
import com.vdegree.grampus.common.mybatis.page.PageData;
import com.vdegree.grampus.common.mybatis.service.BaseService;
import com.vdegree.grampus.common.mybatis.utils.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基础服务类，所有Service接口都要继承(继承后即可获得BaseMapper的CRUD功能)
 * Project: grampus
 *
 * @author Beck
 * @since 2020-12-02
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T> {

	@Autowired
	protected M baseMapper;

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
	public T selectOne(T entity) {
		return baseMapper.selectOne(entity);
	}

	@Override
	public List<T> selectList(T entity) {
		return baseMapper.select(entity);
	}

	@Override
	public List<T> selectList(Map<String, Object> params, Class<T> clazz) {
		T entity = BeanUtil.toBean(params, clazz);
		return this.selectList(entity);
	}

	@Override
	public List<T> selectAll() {
		return baseMapper.selectAll();
	}

	@Override
	public int selectCount(T entity) {
		return baseMapper.selectCount(entity);
	}

	@Override
	public PageData<T> selectPage(Map<String, Object> params, Class<T> clazz) {
		T entity = BeanUtil.toBean(params, clazz);
		String pageNumStr = (String) params.get(Constant.PAGE_NUM);
		String pageSizeStr = (String) params.get(Constant.PAGE_SIZE);
		String withCountStr = (String) params.get(Constant.WITH_COUNT);
		// 分页字段
		int pageNum = params.containsKey(Constant.PAGE_NUM) ? Integer.parseInt(pageNumStr) : 1;
		int pageSize = params.containsKey(Constant.PAGE_SIZE) ? Integer.parseInt(pageSizeStr) : 10;
		// 排序字段
		String orderField = (String) params.get(Constant.ORDER_FIELD);
		String order = (String) params.get(Constant.ORDER);
		// 是否查count
		boolean withCount = !params.containsKey(Constant.WITH_COUNT) || Boolean.parseBoolean(withCountStr);
		return this.selectPage(entity, pageNum, pageSize, withCount, orderField, order);
	}

	@Override
	public PageData<T> selectPage(T entity, int pageNum, int pageSize) {
		return this.selectPage(entity, pageNum, pageSize, true);
	}

	@Override
	public PageData<T> selectPage(T entity, int pageNum, int pageSize, boolean withCount) {
		return this.selectPage(entity, pageNum, pageSize, withCount, null, null);
	}

	@Override
	public PageData<T> selectPage(T entity, int pageNum, int pageSize, boolean withCount, String orderField, String order) {
		Page<T> page = PageHelper.startPage(pageNum, pageSize, withCount);
		if (StringUtil.isNotBlank(orderField) && SqlUtil.isValidOrderBySql(orderField)) {
			page.setOrderBy(SqlUtil.camelToUnderline(orderField) + " " + (Constant.DESC.equalsIgnoreCase(order) ? Constant.DESC : Constant.ASC));
		}
		return new PageData<>(page.doSelectPageInfo(() -> baseMapper.select(entity)));
	}

	@Override
	public void deleteById(Serializable id) {
		baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteBatchIds(Collection<? extends Serializable> idList) {
		baseMapper.deleteByIds(Joiner.on(StringPool.COMMA).join(idList));
	}
}
