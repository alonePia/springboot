package com.hotv.springboot.entity;

/**
 * 用户
 * @author hotv
 *
 */
public class User {

	/**
	 * userId
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 地址
	 */
	private String address;

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
	 * 地址
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
