package com.places.Utility.Exceptions;

@SuppressWarnings("serial")
public class PlaceNotFoundException extends Exception{
	
	private String message;
	
	public PlaceNotFoundException(String message) {
	   this.message = message; 
	} 
	
	@Override
	public String getMessage() {
		return this.message;
	}
    
}
