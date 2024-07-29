package com.college.college.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.college.college.exception.RecordAlreadyExistException;
import com.college.college.exception.ErrorResponse;
import com.college.college.exception.NoSuchRecordException;

@RestControllerAdvice
public class GlobalExceptionsHandler {
	
	@ExceptionHandler(value= NoSuchRecordException.class)
	public ErrorResponse handleNoSuchStudentException(NoSuchRecordException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value= RecordAlreadyExistException.class)
	public ErrorResponse handleElementAlreadyExistException(RecordAlreadyExistException ex) {
		return new ErrorResponse(HttpStatus.FOUND.value(), ex.getMessage());
	}

}
