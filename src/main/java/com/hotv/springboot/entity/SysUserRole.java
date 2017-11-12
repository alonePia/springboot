package com.hotv.springboot.entity;

/**
 * 用户角色
 * 
 * @author hotv
 * @since 2017-11-11
 */
public class SysUserRole {

	/**
	 * roleId
	 */
	private Long roleId;

	/**
	 * 用户id
	 */
	private Long userId;

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
	 * 用户id
	 */
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
