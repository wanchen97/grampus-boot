package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dao.SysDeptDao;
import com.vdegree.grampus.admin.modules.system.entity.SysDept;
import com.vdegree.grampus.admin.modules.system.service.SysDeptService;
import com.vdegree.grampus.common.mybatis.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 部门表(SysDept)表服务实现类
 *
 * @author Beck
 * @since 2020-12-03 20:06:59
 */
@Slf4j
@Service("sysDeptService")
public class SysDeptServiceImpl extends BaseServiceImpl<SysDeptDao, SysDept> implements SysDeptService {

	@Autowired
	private SysDeptDao sysDeptDao;


}