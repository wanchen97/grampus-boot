package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysDictDao;
import com.vdegree.grampus.admin.modules.system.entity.SysDict;
import com.vdegree.grampus.admin.modules.system.service.SysDictService;
import org.springframework.stereotype.Service;

/**
 * 字典表(SysDict)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:47:47
 */
@Service("sysDictService")
public class SysDictServiceImpl extends BaseServiceImpl<SysDictDao, SysDict> implements SysDictService {

}