package com.sc.developer.exception;

public class DevException extends Exception{

	private static final long serialVersionUID = -251669483287769025L;
	
	private int code = 0;
	private String message = "";
	
	public DevException(int code ,String message){
		super(message);
		this.code = code;
		this.message = message;
	}

	/*
	 * get set method
	 */
	
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
	
}
