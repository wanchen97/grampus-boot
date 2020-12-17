package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.common.mybatis.enums.DelFlagEnum;
import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysUserDao;
import com.vdegree.grampus.admin.modules.system.entity.SysUser;
import com.vdegree.grampus.admin.modules.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:50:59
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

    @Override
    public SysUser getSysUserByUserNo(String userNo) {
        return sysUserDao.selectOne(SysUser.builder().userNo(userNo).delFlag(DelFlagEnum.NORMAL.getValue()).build());
    }
}