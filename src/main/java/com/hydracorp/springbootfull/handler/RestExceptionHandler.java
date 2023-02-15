package com.hydracorp.springbootfull.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hydracorp.springbootfull.model.erro.ErrorMessage;
import com.hydracorp.springbootfull.model.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceHandlerNotFoundException(ResourceNotFoundException e){
		ErrorMessage erro = new ErrorMessage("Not found", HttpStatus.NOT_FOUND.value(), e.getMessage());
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}
}
