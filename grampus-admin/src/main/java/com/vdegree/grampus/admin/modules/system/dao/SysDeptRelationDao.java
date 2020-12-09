package com.vdegree.grampus.admin.modules.system.dao;

import com.vdegree.grampus.admin.modules.system.entity.SysDeptRelation;
import com.vdegree.grampus.common.mybatis.annotation.MyBatisMapper;
import com.vdegree.grampus.common.mybatis.mapper.BaseMapper;

/**
 * 部门关系表(SysDeptRelation)表数据库访问层
 *
 * @author Beck
 * @since 2020-12-09 19:47:17
 */
@MyBatisMapper
public interface SysDeptRelationDao extends BaseMapper<SysDeptRelation> {

}