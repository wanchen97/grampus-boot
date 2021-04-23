package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dao.SysDeptRelationDao;
import com.vdegree.grampus.admin.modules.system.entity.SysDeptRelation;
import com.vdegree.grampus.admin.modules.system.service.SysDeptRelationService;
import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 部门关系表 服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:47:18
 */
@Service("sysDeptRelationService")
public class SysDeptRelationServiceImpl extends BaseServiceImpl<SysDeptRelationDao, SysDeptRelation> implements SysDeptRelationService {

}