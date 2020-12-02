package com.vdegree.grampus.common.mybatis.service;

import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Collection;

/**
 * Title: 基础服务接口，所有Service接口都要继承(继承后即可获得BaseMapper的CRUD功能)
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
public interface BaseService<T> {

	/**
	 * 逻辑删除
	 *
	 * @param ids    ids
	 * @param entity 实体
	 * @return boolean
	 */
	boolean logicDelete(Long[] ids, Class<T> entity);

	/**
	 * <p>
	 * 插入一条记录（选择字段，策略插入）
	 * </p>
	 *
	 * @param entity 实体对象
	 */
	boolean insert(T entity);

	/**
	 * <p>
	 * 插入（批量），该方法不支持 Oracle、SQL Server
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 */
	boolean insertBatch(Collection<T> entityList);

	/**
	 * <p>
	 * 插入（批量）
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 * @param batchSize  插入批次数量
	 */
	boolean insertBatch(Collection<T> entityList, int batchSize);

	/**
	 * <p>
	 * 根据 ID 选择修改
	 * </p>
	 *
	 * @param entity 实体对象
	 */
	boolean updateById(T entity);

	/**
	 * <p>
	 * 根据 whereEntity 条件，更新记录
	 * </p>
	 *
	 * @param entity  实体对象
	 * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
	 */
	boolean update(T entity, Example example);

	/**
	 * <p>
	 * 根据ID 批量更新
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 */
	boolean updateBatchById(Collection<T> entityList);

	/**
	 * <p>
	 * 根据ID 批量更新
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 * @param batchSize  更新批次数量
	 */
	boolean updateBatchById(Collection<T> entityList, int batchSize);

	/**
	 * <p>
	 * 根据 ID 查询
	 * </p>
	 *
	 * @param id 主键ID
	 */
	T selectById(Serializable id);

	/**
	 * <p>
	 * 根据 ID 删除
	 * </p>
	 *
	 * @param id 主键ID
	 */
	boolean deleteById(Serializable id);

	/**
	 * <p>
	 * 删除（根据ID 批量删除）
	 * </p>
	 *
	 * @param idList 主键ID列表
	 */
	boolean deleteBatchIds(Collection<? extends Serializable> idList);
}
