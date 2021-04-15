package com.vdegree.grampus.admin.modules.system.security.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Title: system user details
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-15
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
	@JsonIgnore
	private String password;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 所属部门ID
	 */
	private Long deptId;

	/**
	 * 是否超级管理员(0普通 1超管)
	 */
	private Integer superAdmin;

	/**
	 * 是否启用(0停用 1启用)
	 */
	private Integer enabled;

	/**
	 * 拥有权限
	 */
	private String permissions;

	/**
	 * 拥有权限集合
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList(permissions);
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.getUserNo();
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}
}
