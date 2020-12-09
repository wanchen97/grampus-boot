package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysMenuDao;
import com.vdegree.grampus.admin.modules.system.entity.SysMenu;
import com.vdegree.grampus.admin.modules.system.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单表(SysMenu)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:49:31
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

}