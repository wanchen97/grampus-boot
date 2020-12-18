package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysUserRoleDao;
import com.vdegree.grampus.admin.modules.system.entity.SysUserRole;
import com.vdegree.grampus.admin.modules.system.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.util.List;

/**
 * 用户角色关联表(SysUserRole)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:51:18
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {

	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public List<SysUserRole> getUserRole(Long userId) {
//		return sysUserRoleDao.selectByExample(Example.builder(SysUserRole.class)
//				.where(Sqls.custom().andEqualTo("userId", userId)).build());
		return sysUserRoleDao.selectByExample(Example.builder(SysUserRole.class)
				.where(WeekendSqls.<SysUserRole>custom()
						.andEqualTo(SysUserRole::getUserId, userId)).build());
	}
}