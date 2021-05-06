package com.vdegree.grampus.common.mybatis.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * CRUD基类(Mapper继承该接口后，无需编写mapper.xml文件，即可获得CRUD功能)
 * Project: grampus
 *
 * @author Beck
 * @since 2020-12-02
 */
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T>, ConditionMapper<T> {

}
