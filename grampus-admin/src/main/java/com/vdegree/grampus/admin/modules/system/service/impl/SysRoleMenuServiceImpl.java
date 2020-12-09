package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysRoleMenuDao;
import com.vdegree.grampus.admin.modules.system.entity.SysRoleMenu;
import com.vdegree.grampus.admin.modules.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * 角色菜单表(SysRoleMenu)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:50:44
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuDao, SysRoleMenu> implements SysRoleMenuService {

}