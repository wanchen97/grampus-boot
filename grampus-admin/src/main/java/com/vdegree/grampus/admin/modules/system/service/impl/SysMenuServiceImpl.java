package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dto.SysMenuDTO;
import com.vdegree.grampus.admin.modules.system.enums.MenuTypeEnum;
import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.common.core.utils.StringUtil;
import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysMenuDao;
import com.vdegree.grampus.admin.modules.system.entity.SysMenu;
import com.vdegree.grampus.admin.modules.system.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 菜单表(SysMenu)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:49:31
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

	@Override
	public SysMenuDTO get(Long id) {
		SysMenu sysMenu = baseMapper.selectByPrimaryKey(id);
		return BeanUtil.copy(sysMenu, SysMenuDTO.class);
	}

	@Override
	public void save(SysMenuDTO dto) {
		SysMenu sysMenu = BeanUtil.copy(dto, SysMenu.class);
		baseMapper.insert(sysMenu);
	}

	@Override
	public void update(SysMenuDTO dto) {
		SysMenu sysMenu = BeanUtil.copy(dto, SysMenu.class);
		baseMapper.updateByPrimaryKeySelective(sysMenu);
	}

	@Override
	public void delete(Long id) {
		baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SysMenuDTO> getMenuList(Integer type) {
		SysMenu param = new SysMenu();
		param.setType(type);
		List<SysMenu> list = baseMapper.select(param);
		return BeanUtil.copyList(list, SysMenuDTO.class);
	}

	@Override
	public List<SysMenuDTO> getUserMenuList(SystemUserDetails userDetail, Integer type) {
		List<SysMenu> menuList = baseMapper.queryUserMenuList(userDetail.getId(), type);
		return BeanUtil.copyList(menuList, SysMenuDTO.class);
	}

	@Override
	public List<SysMenuDTO> getUserMenuNavList(SystemUserDetails userDetail) {
		return this.getUserMenuList(userDetail, MenuTypeEnum.MENU.getValue());
	}

	@Override
	public Set<String> getUserPermissions(SystemUserDetails userDetail) {
		List<SysMenuDTO> menuNavList = this.getUserMenuNavList(userDetail);
		Set<String> permissions = menuNavList.stream()
				.filter(sysMenu -> StringUtil.isNotBlank(sysMenu.getPermission()))
				.map(sysMenu -> sysMenu.getPermission().trim().split(","))
				.flatMap(Arrays::stream)
				.collect(Collectors.toSet());
		return permissions;
	}

	@Override
	public List<SysMenuDTO> getListByPid(Long pid) {
		SysMenu sysMenu = new SysMenu();
		sysMenu.setParentId(pid);
		List<SysMenu> sysMenus = baseMapper.select(sysMenu);
		return BeanUtil.copyList(sysMenus, SysMenuDTO.class);
	}
}