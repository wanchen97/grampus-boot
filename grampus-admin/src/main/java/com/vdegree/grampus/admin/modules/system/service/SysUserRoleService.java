package com.vdegree.grampus.admin.modules.system.service;

import com.vdegree.grampus.common.mybatis.service.BaseService;
import com.vdegree.grampus.admin.modules.system.entity.SysUserRole;

import java.util.List;

/**
 * 用户角色关联表(SysUserRole)表服务接口
 *
 * @author Beck
 * @since 2020-12-09 19:51:17
 */
public interface SysUserRoleService extends BaseService<SysUserRole> {

	/**
	 * 获取用户角色
	 *
	 * @param userId 用户ID
	 * @return 用户角色列表
	 */
	List<SysUserRole> getUserRole(Long userId);

	/**
	 * 获取用户所属角色ID
	 *
	 * @param userId 用户ID
	 * @return 用户角色ID列表
	 */
    List<Long> getRoleIdList(Long userId);
}