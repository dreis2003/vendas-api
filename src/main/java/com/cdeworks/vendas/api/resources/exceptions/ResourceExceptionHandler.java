package com.cdeworks.vendas.api.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cdeworks.vendas.api.exceptions.CDEWorksException;
import com.cdeworks.vendas.api.exceptions.CDEWorksNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	@ExceptionHandler(CDEWorksNotFoundException.class)
	public ResponseEntity<StandardError> notFoundException(CDEWorksNotFoundException ex, HttpServletRequest request) {
		
		StandardError stdError = new StandardError(HttpStatus.NOT_FOUND.value(), 
												   ex.getMessage(), 
												   System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(stdError);
				
	}
	
	@ExceptionHandler(CDEWorksException.class)
	public ResponseEntity<StandardError> defautlException(CDEWorksException ex, HttpServletRequest request) {
		
		StandardError stdError = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
												   ex.getMessage(), 
												   System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(stdError);
				
	}

}
