package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysRoleMenuDao;
import com.vdegree.grampus.admin.modules.system.entity.SysRoleMenu;
import com.vdegree.grampus.admin.modules.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色菜单表(SysRoleMenu)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:50:44
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuDao, SysRoleMenu> implements SysRoleMenuService {

	@Override
	public List<Long> getMenuIdList(Long roleId) {
		List<SysRoleMenu> list = baseMapper.selectByExample(Example.builder(SysRoleMenu.class)
				.select("menuId")
				.where(Sqls.custom().andEqualTo("roleId", roleId))
				.build());
		return list.stream().map(SysRoleMenu::getMenuId).distinct().collect(Collectors.toList());
	}
}