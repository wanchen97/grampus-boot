package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dto.SysMenuDTO;
import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
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
		return null;
	}

	@Override
	public void save(SysMenuDTO dto) {

	}

	@Override
	public void update(SysMenuDTO dto) {

	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public List<SysMenuDTO> getMenuList(Integer type) {
		return null;
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
	public List<SysMenuDTO> getListPid(Long pid) {
		return null;
	}
}