package com.vdegree.grampus.common.mybatis.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * Title: CRUD基类(Mapper继承该接口后，无需编写mapper.xml文件，即可获得CRUD功能)
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T>, InsertListMapper<T>, ConditionMapper<T> {

}
