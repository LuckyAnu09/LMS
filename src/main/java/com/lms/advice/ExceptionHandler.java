package com.lms.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lms.exception.BatchNotFoundException;
import com.lms.exception.ProgramNotFoundException;

@RestControllerAdvice
public class ExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	
	public Map<String,String> programException(MethodArgumentNotValidException ex)
	{
		Map<String,String> errorMap = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error ->{
			
			errorMap.put(error.getField(), error.getDefaultMessage());});
		
		
		
		
		
		return errorMap;
		
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(ProgramNotFoundException.class)
	public Map<String,String> programNotFound(ProgramNotFoundException ex)
	{
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("error details", ex.getMessage());
		
		return errorMap;
		
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(BatchNotFoundException.class)
	public Map<String,String> batchNotFound(BatchNotFoundException ex)
	{
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("error details", ex.getMessage());
		
		return errorMap;
		
	}

}
