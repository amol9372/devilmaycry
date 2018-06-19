package com.online.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/testApi2")
@Controller
public class TestController2 
{
	@RequestMapping("/showHomePage")
    public String showHome(){
    	return "/static/about.html";
    }
	
	@RequestMapping("/testStaticResources")
    public String showCss(){
    	return "/assets/css/icons.css";
    }
	
}
