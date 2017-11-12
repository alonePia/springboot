package com.hotv.springboot.entity;

/**
 * 系统角色
 * 
 * @author hotv
 * @since 2017-11-11
 */
public class SysRole {

	/**
	 * roleId
	 */
	private Long roleId;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 角色名称
	 */
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
