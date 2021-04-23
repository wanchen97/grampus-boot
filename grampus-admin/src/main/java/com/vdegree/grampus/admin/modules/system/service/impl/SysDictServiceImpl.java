package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.admin.modules.system.dto.SysDictDTO;
import com.vdegree.grampus.admin.modules.system.dao.SysDictDao;
import com.vdegree.grampus.admin.modules.system.entity.SysDict;
import com.vdegree.grampus.admin.modules.system.service.SysDictService;
import com.vdegree.grampus.common.mybatis.service.impl.EnhancedBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典表 服务实现类
 *
 * @author Beck
 * @since 2020-12-09 19:47:47
 */
@Service("sysDictService")
public class SysDictServiceImpl extends EnhancedBaseServiceImpl<SysDictDao, SysDict, SysDictDTO> implements SysDictService {

	@Override
	public List<SysDict> getSysDictList() {
		return baseMapper.getSysDictList();
	}
}