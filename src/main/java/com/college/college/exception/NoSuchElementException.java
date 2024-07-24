package com.college.college.exception;

public class NoSuchElementException extends RuntimeException {
	
	private static final long serialVersionUID = 2029934713214854196L;
	
	private String msg;
	
	public NoSuchElementException() {}
	
	public NoSuchElementException(String msg) {
		super(msg);
		this.msg=msg;
	}

}
