package com.hotv.springboot.core;

public class ResponseData {
	
	/**
	 * 未避免默认值导致返回参数与实际结果不一致的请款 无参构造函数注释 慎用
	 */
	/*public ResponseData(){
		this.code = 1;
		this.success = true;
		this.message = "操作成功";
	}*/
	
	public ResponseData(boolean success){
		if(success){
			this.code = 1;
			this.message = "操作成功";
		}else{
			this.code = 0;
			this.message = "操作失败";
		}
	}
	
	public ResponseData(boolean success,String message){
		this.message = message;
		if(success){
			this.code = 1;
		}else{
			this.code = 0;
		}
	}

	/**
	 * 返回code 仅允许当前类访问
	 */
	private int code;

	/**
	 * 返回内容
	 */
	private String message;

	/**
	 * 返回标识
	 */
	private boolean success;

	/**
	 * 返回code
	 */
	public int getCode() {
		return code;
	}

	/*public void setCode(int code) {
		this.code = code;
	}*/

	/**
	 * 返回内容
	 */
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 返回标识
	 */
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
