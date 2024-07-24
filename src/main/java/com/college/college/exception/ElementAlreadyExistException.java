package com.college.college.exception;

public class ElementAlreadyExistException extends RuntimeException{
	
	private String msg;
	
	public ElementAlreadyExistException() {}
	
	public ElementAlreadyExistException(String msg) {
		super(msg);
		this.msg=msg;
	}

}
