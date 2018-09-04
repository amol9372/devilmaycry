package com.lucene.search.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TestController 
{
	@RequestMapping("/test")
	public ModelAndView testPage2(){
		return new ModelAndView("testview");
	}
	
	@RequestMapping("/test")
	public ModelAndView googleOauth2(){
		return new ModelAndView("testview");
	}
	
}
