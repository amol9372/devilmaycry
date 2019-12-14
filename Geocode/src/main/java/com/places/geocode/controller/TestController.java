package com.places.geocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.places.geocode.practice.Model;

@RestController
public class TestController {
    
	@Autowired
	@Qualifier("parent")
	private Model model; 
	
	@GetMapping("/name")
	public String getName() {
		return model.toString();
	}
	
}
