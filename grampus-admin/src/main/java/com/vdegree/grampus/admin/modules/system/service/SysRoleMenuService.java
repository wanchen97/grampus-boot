package com.vdegree.grampus.admin.modules.system.service;

import com.vdegree.grampus.common.mybatis.service.BaseService;
import com.vdegree.grampus.admin.modules.system.entity.SysRoleMenu;

import java.util.List;

/**
 * 角色菜单表(SysRoleMenu)表服务接口
 *
 * @author Beck
 * @since 2020-12-09 19:50:43
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenu> {

	/**
	 * 获取角色菜单ID列表
	 *
	 * @param roleId 角色ID
	 * @return 菜单ID列表
	 */
	List<Long> getMenuIdList(Long roleId);
}