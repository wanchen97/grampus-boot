package com.vdegree.grampus.admin.modules.system.service;

import com.vdegree.grampus.common.mybatis.service.BaseService;
import com.vdegree.grampus.admin.modules.system.entity.SysUser;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author Beck
 * @since 2020-12-09 19:50:58
 */
public interface SysUserService extends BaseService<SysUser> {

	/**
	 * 根据会员号获取会员数据
	 *
	 * @param userNo 会员号
	 * @return 会员实体
	 */
	SysUser getSysUserByUserNo(String userNo);
}