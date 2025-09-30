package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	} 
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArg(IllegalArgumentException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
