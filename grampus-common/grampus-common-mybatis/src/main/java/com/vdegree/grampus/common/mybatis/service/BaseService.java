package com.vdegree.grampus.common.mybatis.service;

import com.vdegree.grampus.common.mybatis.page.PageData;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基础服务接口，所有Service接口都要继承(继承后即可获得BaseMapper的CRUD功能)
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
public interface BaseService<T> {

	/**
	 * <p>
	 * 插入一条记录（选择字段，策略插入）
	 * </p>
	 *
	 * @param entity 实体对象
	 */
	void insert(T entity);

	/**
	 * <p>
	 * 插入（批量），该方法不支持 Oracle、SQL Server
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 */
	void insertBatch(List<T> entityList);

	/**
	 * <p>
	 * 插入（批量）
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 * @param batchSize  插入批次数量
	 */
	void insertBatch(List<T> entityList, int batchSize);

	/**
	 * <p>
	 * 根据 ID 选择修改
	 * </p>
	 *
	 * @param entity 实体对象
	 */
	void updateById(T entity);

	/**
	 * <p>
	 * 根据 whereEntity 条件，更新记录
	 * </p>
	 *
	 * @param entity  实体对象
	 * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
	 */
	void update(T entity, Example example);

	/**
	 * <p>
	 * 根据ID 批量更新
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 */
	void updateBatchById(List<T> entityList);

	/**
	 * <p>
	 * 根据ID 批量更新
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 * @param batchSize  更新批次数量
	 */
	void updateBatchById(List<T> entityList, int batchSize);

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
	 * 条件查询
	 * </p>
	 *
	 * @param entity 实体
	 * @return 查询结果
	 */
	T selectOne(T entity);

	/**
	 * <p>
	 * 条件查询
	 * </p>
	 *
	 * @param entity 实体
	 * @return 查询结果
	 */
	List<T> selectList(T entity);

	/**
	 * <p>
	 * 查询所有
	 * </p>
	 *
	 * @return 查询结果
	 */
	List<T> selectAll();

	/**
	 * <p>
	 * 查询数据量
	 * </p>
	 *
	 * @return 查询结果
	 */
	int selectCount(T entity);

	/**
	 * <p>
	 * 分页条件查询
	 * </p>
	 *
	 * @param params 参数
	 * @param clazz  查询条件映射实体的类名
	 * @return 查询结果
	 */
	PageData<T> selectPage(Map<String, Object> params, Class<T> clazz);

	/**
	 * <p>
	 * 分页条件查询 (默认查count)
	 * </p>
	 *
	 * @param entity   查询实例
	 * @param pageNum  页码
	 * @param pageSize 每页数据量
	 * @return 查询结果
	 */
	PageData<T> selectPage(T entity, int pageNum, int pageSize);

	/**
	 * <p>
	 * 分页条件查询
	 * </p>
	 *
	 * @param entity    查询实例
	 * @param pageNum   页码
	 * @param pageSize  每页数据量
	 * @param withCount 是否查count(true查count false)
	 * @return 查询结果
	 */
	PageData<T> selectPage(T entity, int pageNum, int pageSize, boolean withCount);

	/**
	 * <p>
	 * 分页条件查询
	 * </p>
	 *
	 * @param entity     查询实例
	 * @param pageNum    页码
	 * @param pageSize   每页数据量
	 * @param orderField 排序字段
	 * @param order      排序方式(asc desc)
	 * @return 查询结果
	 */
	PageData<T> selectPage(T entity, int pageNum, int pageSize, boolean withCount, String orderField, String order);

	/**
	 * <p>
	 * 根据 ID 删除
	 * </p>
	 *
	 * @param id 主键ID
	 */
	void deleteById(Serializable id);

	/**
	 * <p>
	 * 删除（根据ID 批量删除）
	 * </p>
	 *
	 * @param idList 主键ID列表
	 */
	void deleteBatchIds(Collection<? extends Serializable> idList);
}
