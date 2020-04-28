package com.example.demo;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@RestController
public class CustomExceptionHandling extends ResponseEntityExceptionHandler {
	
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CustomException> handelAllException(Exception ex,WebRequest request){
		
		CustomException customRes=new 
				CustomException(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(customRes,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<CustomException> handelUSerNotFoundException(UserNotFoundException ex,WebRequest request){
		
		CustomException customRes=new 
				CustomException(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(customRes,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomException customRes=new 
				CustomException(new Date(),"Validation Failed",ex.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(customRes,HttpStatus.BAD_REQUEST);
	}

}
