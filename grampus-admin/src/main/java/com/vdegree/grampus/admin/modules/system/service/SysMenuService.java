package com.vdegree.grampus.admin.modules.system.service;

import com.vdegree.grampus.admin.modules.system.dto.SysMenuDTO;
import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
import com.vdegree.grampus.common.mybatis.service.BaseService;
import com.vdegree.grampus.admin.modules.system.entity.SysMenu;

import java.util.List;
import java.util.Set;

/**
 * 菜单表(SysMenu)表服务接口
 *
 * @author Beck
 * @since 2020-12-09 19:49:30
 */
public interface SysMenuService extends BaseService<SysMenu> {

	SysMenuDTO get(Long id);

	void save(SysMenuDTO dto);

	void update(SysMenuDTO dto);

	void delete(Long id);

	/**
	 * 菜单列表（全部）
	 *
	 * @param type 菜单类型
	 */
	List<SysMenuDTO> getMenuList(Integer type);

	/**
	 * 用户菜单列表
	 *
	 * @param userDetail 用户信息
	 * @param type       菜单类型
	 */
	List<SysMenuDTO> getUserMenuList(SystemUserDetails userDetail, Integer type);

	/**
	 * 用户菜单导航
	 *
	 * @param userDetail 用户信息
	 */
	List<SysMenuDTO> getUserMenuNavList(SystemUserDetails userDetail);

	/**
	 * 获取用户权限标识
	 */
	Set<String> getUserPermissions(SystemUserDetails userDetail);

	/**
	 * 根据父菜单，查询子菜单
	 *
	 * @param pid 父菜单ID
	 */
	List<SysMenuDTO> getListByPid(Long pid);
}