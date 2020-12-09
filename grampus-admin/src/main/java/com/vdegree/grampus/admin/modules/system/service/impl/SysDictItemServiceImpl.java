package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysDictItemDao;
import com.vdegree.grampus.admin.modules.system.entity.SysDictItem;
import com.vdegree.grampus.admin.modules.system.service.SysDictItemService;
import org.springframework.stereotype.Service;

/**
 * 字典数据表(SysDictItem)表服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:48:32
 */
@Service("sysDictItemService")
public class SysDictItemServiceImpl extends BaseServiceImpl<SysDictItemDao, SysDictItem> implements SysDictItemService {

}