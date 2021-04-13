package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dto.SysRoleDTO;
import com.vdegree.grampus.admin.modules.system.dao.SysRoleDao;
import com.vdegree.grampus.admin.modules.system.entity.SysRole;
import com.vdegree.grampus.admin.modules.system.service.SysRoleService;
import com.vdegree.grampus.common.mybatis.service.impl.EnhancedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色表(SysRole)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:50:17
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends EnhancedBaseServiceImpl<SysRoleDao, SysRole, SysRoleDTO> implements SysRoleService {

}