package com.vdegree.grampus.admin.modules.system.dao;

import com.vdegree.grampus.admin.modules.system.entity.SysMenu;
import com.vdegree.grampus.common.mybatis.annotation.MyBatisMapper;
import com.vdegree.grampus.common.mybatis.mapper.BaseMapper;

/**
 * 菜单表(SysMenu)表数据库访问层
 *
 * @author Beck
 * @since 2020-12-09 19:49:29
 */
@MyBatisMapper
public interface SysMenuDao extends BaseMapper<SysMenu> {

}