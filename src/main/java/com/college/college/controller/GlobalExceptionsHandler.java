package com.college.college.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.college.college.exception.ElementAlreadyExistException;
import com.college.college.exception.ErrorResponse;
import com.college.college.exception.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionsHandler {
	
	@ExceptionHandler(value= NoSuchElementException.class)
	public ErrorResponse handleNoSuchStudentException(NoSuchElementException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value= ElementAlreadyExistException.class)
	public ErrorResponse handleElementAlreadyExistException(ElementAlreadyExistException ex) {
		return new ErrorResponse(HttpStatus.FOUND.value(), ex.getMessage());
	}

}
