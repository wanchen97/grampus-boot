package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dto.SysMenuDTO;
import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
import com.vdegree.grampus.common.core.utils.BeanUtil;
import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysMenuDao;
import com.vdegree.grampus.admin.modules.system.entity.SysMenu;
import com.vdegree.grampus.admin.modules.system.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
		return null;
	}

	@Override
	public List<SysMenuDTO> getUserMenuNavList(SystemUserDetails userDetail) {
		return null;
	}

	@Override
	public Set<String> getUserPermissions(SystemUserDetails userDetail) {

		return null;
	}

	@Override
	public List<SysMenuDTO> getListByPid(Long pid) {
		SysMenu sysMenu = new SysMenu();
		sysMenu.setParentId(pid);
		List<SysMenu> sysMenus = baseMapper.select(sysMenu);
		return BeanUtil.copyList(sysMenus, SysMenuDTO.class);
	}
}