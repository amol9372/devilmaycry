package com.spring.boot.Init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.model.Employee;

@ConfigurationProperties(prefix = "abc")
@RestController
public class SampleController {
	
   @Autowired	
   private Environment env;	
   
   @Autowired
   private Employee employee;
   
   @GetMapping("/sample")	
   public String showSamplePage() {
	   employee.setId(23);
	   employee.setName("Amol");
	   return "sample : " + env.getProperty("message") + " : " + employee.toString();
   }
}
