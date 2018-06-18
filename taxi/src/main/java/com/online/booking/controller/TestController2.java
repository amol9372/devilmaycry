package com.online.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/testApi2")
@Controller
public class TestController2 
{
	@RequestMapping("/showHomePage")
    public ModelAndView showHome(){
    	return new ModelAndView("about");
    }
}
