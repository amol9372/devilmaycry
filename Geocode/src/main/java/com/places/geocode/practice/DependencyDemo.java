package com.places.geocode.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.places.geocode.model.Location;

@Component
public class DependencyDemo {
	
	private Location location;
	
	@Autowired
	public void setEmployee(Location location) {
		this.location = location;
	}
	
	public void getLocation() {
		System.out.println(location.getLat());;
	}
}
