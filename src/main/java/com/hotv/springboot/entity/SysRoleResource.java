package com.hotv.springboot.entity;

/**
 * 角色资源
 * 
 * @author hotv
 * @since 2017-11-11
 */
public class SysRoleResource {

	/**
	 * roleId
	 */
	private Long roleId;

	/**
	 * 角色资源
	 */
	private String resource;

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
	 * 角色资源
	 */
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

}
