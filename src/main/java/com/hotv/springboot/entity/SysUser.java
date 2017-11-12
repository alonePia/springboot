package com.hotv.springboot.entity;

/**
 * 用户
 * 
 * @author hotv
 * @since 2017-11-11
 */
public class SysUser {
	
	public SysUser(){}
	
	public SysUser(String username,String password){}

	/**
	 * userId
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 登录密码
	 */
	private String password;

	/**
	 * userId
	 */
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 用户名
	 */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 登录密码
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
