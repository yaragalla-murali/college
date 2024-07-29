package com.college.college.exception;

public class NoSuchRecordException extends RuntimeException {
	
	private static final long serialVersionUID = 2029934713214854196L;
	
	
	
	public NoSuchRecordException() {}
	
	public NoSuchRecordException(String message) {
		super(message);
		
	}

}
