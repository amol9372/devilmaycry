package com.spring.boot.Init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ConfigurationProperties(prefix = "abc")
@RestController
public class SampleController {
	
   @Autowired	
   private Environment env;	
   
   @GetMapping("/sample")	
   public String showSamplePage() {
	   return "sample : " + env.getProperty("message");
   }
}
