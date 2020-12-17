package com.vdegree.grampus.admin.modules.system.security.users;

import com.vdegree.grampus.admin.modules.system.entity.SysUser;
import com.vdegree.grampus.admin.modules.system.enums.SysUserEnabledEnum;
import com.vdegree.grampus.admin.modules.system.security.exception.UserDisabledException;
import com.vdegree.grampus.admin.modules.system.security.exception.UserNotFoundException;
import com.vdegree.grampus.admin.modules.system.service.SysUserService;
import com.vdegree.grampus.common.core.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Title: system user details service
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-15
 */
@Service
public class SystemUserDetailsService implements UserDetailsService {

	@Autowired
	private SysUserService sysUserService;

	@Override
	public UserDetails loadUserByUsername(String userNo) throws UsernameNotFoundException {
		// TODO use cache
		SysUser user = sysUserService.getSysUserByUserNo(userNo);

		// 用户不存在
		if (user == null) {
			throw new UserNotFoundException();
		}

		// 用户被禁用
		if (SysUserEnabledEnum.DISABLED.getValue().equals(user.getEnabled())) {
			throw new UserDisabledException();
		}

		return buildUserDetails(user);
	}


	public UserDetails buildUserDetails(SysUser user) {
		return BeanCopyUtil.copy(user, SystemUserDetails.class);
	}
}
