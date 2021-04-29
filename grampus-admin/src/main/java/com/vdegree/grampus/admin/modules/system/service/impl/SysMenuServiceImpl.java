package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dto.SysMenuDTO;
import com.vdegree.grampus.admin.modules.system.enums.MenuTypeEnum;
import com.vdegree.grampus.admin.modules.system.security.enums.SuperAdminEnum;
import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
import com.vdegree.grampus.common.core.utils.tree.TreeUtils;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.admin.modules.system.dao.SysMenuDao;
import com.vdegree.grampus.admin.modules.system.entity.SysMenu;
import com.vdegree.grampus.admin.modules.system.service.SysMenuService;
import com.vdegree.grampus.common.core.utils.StringUtil;
import com.vdegree.grampus.common.mybatis.service.impl.EnhancedBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 菜单表 服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:49:31
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends EnhancedBaseServiceImpl<SysMenuDao, SysMenu, SysMenuDTO> implements SysMenuService {

	@Override
	public List<SysMenuDTO> getMenuList(Integer type) {
		SysMenu param = new SysMenu();
		param.setType(type);
		List<SysMenu> list = baseMapper.select(param);
		return BeanUtil.copyList(list, SysMenuDTO.class);
	}

	@Override
	public List<SysMenuDTO> getUserMenuList(SystemUserDetails userDetail, Integer type) {
		List<SysMenuDTO> sysMenuList;
		boolean isSuperAdmin = SuperAdminEnum.TRUE.getValue().equals(userDetail.getSuperAdmin());
		if (Boolean.TRUE.equals(isSuperAdmin)) {
			sysMenuList = this.getMenuList(type);
		} else {
			List<SysMenu> menuList = baseMapper.queryUserMenuList(userDetail.getId(), type);
			sysMenuList = BeanUtil.copyList(menuList, SysMenuDTO.class);
		}
		return TreeUtils.build(sysMenuList);
	}

	@Override
	public List<SysMenuDTO> getUserMenuNavList(SystemUserDetails userDetail) {
		return this.getUserMenuList(userDetail, MenuTypeEnum.MENU.getValue());
	}

	@Override
	public Set<String> getUserPermissions(SystemUserDetails userDetail) {
//		List<SysMenu> menuNavList =  baseMapper.queryUserMenuList(userDetail.getId(), null);
//		return menuNavList.stream()
//				.filter(sysMenu -> StringUtil.isNotBlank(sysMenu.getPermission()))
//				.map(sysMenu -> sysMenu.getPermission().trim().split(","))
//				.flatMap(Arrays::stream)
//				.collect(Collectors.toSet());
		return Arrays.stream(userDetail.getPermissions().trim().split(","))
				.filter(permission -> Objects.nonNull(permission)
						&& StringUtil.isNotBlank(permission))
				.collect(Collectors.toSet());
	}

	@Override
	public List<SysMenuDTO> getListByPid(Long pid) {
		SysMenu sysMenu = new SysMenu();
		sysMenu.setParentId(pid);
		List<SysMenu> sysMenus = baseMapper.select(sysMenu);
		return BeanUtil.copyList(sysMenus, SysMenuDTO.class);
	}
}