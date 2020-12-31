package com.vdegree.grampus.admin.modules.system.security.roles.dao;

import com.vdegree.grampus.common.mybatis.annotation.MyBatisMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * Title: system role dao
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-18
 */
@MyBatisMapper
public interface SystemRoleDao {

	/**
	 * 获取用户所有权限标识
	 *
	 * @param userId 用户ID
	 * @return 权限标识
	 */
	Set<String> getPermissions(@Param("userId") Long userId);
}