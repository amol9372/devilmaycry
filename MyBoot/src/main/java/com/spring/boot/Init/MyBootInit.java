package com.spring.boot.Init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.spring.boot")
@SpringBootApplication
public class MyBootInit {
    public static void main(String[] args) {
    	
		SpringApplication.run(MyBootInit.class, args);
	}
}
