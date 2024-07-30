package com.oceancloud.grampus.admin.modules.security.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 系统用户详情
 *
 * @author Beck
 * @since 2020-12-15
 */
@Data
public class SystemUserDetails implements UserDetails {
	private static final long serialVersionUID = -2384821650336456082L;

	/**
	 * 用户ID
	 */
	private Long id;

	/**
	 * 员工号
	 */
	private String userNo;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 所属角色ID
	 */
	private List<Long> roleIds;

	/**
	 * 所属部门ID
	 */
	private Long deptId;

	/**
	 * 是否超级管理员(0普通 1超管)
	 */
	private Integer superAdmin;

	/**
	 * 是否启用(0停用 1启用)	TODO 待解决BeanUtil.copy无法将SysUser的enabled拷贝到SystemUserDetails
	 */
	private Integer status;

	/**
	 * 拥有权限
	 */
	private String permissions;

	/**
	 * 拥有权限集合
	 */
	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList(permissions);
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	/**
	 * authentication.getName()
	 * if (this.getPrincipal() instanceof UserDetails) {
	 *     return ((UserDetails) this.getPrincipal()).getUsername();
	 * }
	 */
	@Override
	@JsonIgnore
	public String getUsername() {
		return this.getUserNo();
	}

	/**
	 * DefaultPreAuthenticationChecks.
	 * void check(UserDetails user)
	 */
	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * DefaultPostAuthenticationChecks.
	 * void check(UserDetails user)
	 */
	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
