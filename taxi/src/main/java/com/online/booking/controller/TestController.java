package com.online.booking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testApi")
public class TestController 
{
	@RequestMapping(value = "/getName")
    public String testApi(){
    	return "Amol";
    }
}
