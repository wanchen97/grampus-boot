package com.vdegree.grampus.admin.modules.system.service.impl;

import com.vdegree.grampus.common.mybatis.service.impl.EnhancedBaseServiceImpl;
import com.vdegree.grampus.admin.modules.system.dao.SysLanguageDao;
import com.vdegree.grampus.admin.modules.system.entity.SysLanguage;
import com.vdegree.grampus.admin.modules.system.dto.SysLanguageDTO;
import com.vdegree.grampus.admin.modules.system.service.SysLanguageService;
import org.springframework.stereotype.Service;

/**
 * 系统语言表 表服务实现类
 *
 * @author Beck
 * @since 2021-06-08 10:42:16
 */
@Service("sysLanguageService")
public class SysLanguageServiceImpl extends EnhancedBaseServiceImpl<SysLanguageDao, SysLanguage, SysLanguageDTO> implements SysLanguageService {

}
