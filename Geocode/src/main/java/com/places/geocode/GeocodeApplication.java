package com.places.geocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "com.places.geocode")
@EnableSwagger2
public class GeocodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeocodeApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
}
