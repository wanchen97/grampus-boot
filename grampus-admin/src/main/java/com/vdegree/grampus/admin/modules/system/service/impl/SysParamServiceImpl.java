package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysParamDao;
import com.vdegree.grampus.admin.modules.system.entity.SysParam;
import com.vdegree.grampus.admin.modules.system.service.SysParamService;
import org.springframework.stereotype.Service;

/**
 * 公共参数表(SysParam)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:49:55
 */
@Service("sysParamService")
public class SysParamServiceImpl extends BaseServiceImpl<SysParamDao, SysParam> implements SysParamService {

}