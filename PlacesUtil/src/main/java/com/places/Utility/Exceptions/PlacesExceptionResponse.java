package com.places.Utility.Exceptions;

import java.util.Date;

public class PlacesExceptionResponse {
    
	private String message;
	private Date timeStamp;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
