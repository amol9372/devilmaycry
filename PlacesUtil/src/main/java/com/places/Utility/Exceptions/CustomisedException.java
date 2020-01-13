package com.places.Utility.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomisedException extends ResponseEntityExceptionHandler {
   
	@ExceptionHandler(PlaceNotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		PlacesExceptionResponse exceptionResponse = new PlacesExceptionResponse();
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setTimeStamp(new Date());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
