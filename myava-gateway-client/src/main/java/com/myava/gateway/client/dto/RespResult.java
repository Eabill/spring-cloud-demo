package com.myava.gateway.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RespResult {

	private int code = 200;
	
	private String message = "操作成功";
	
	@JsonInclude(Include.NON_NULL)
	private Object data;
	
	public RespResult() {}
	
	public RespResult(Object data) {
		this.data = data;
	}
	
	public RespResult(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public RespResult(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
