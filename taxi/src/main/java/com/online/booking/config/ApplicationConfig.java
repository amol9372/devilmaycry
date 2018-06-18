package com.online.booking.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan({ "com.online.booking" })
@PropertySource(value = { "classpath:public.properties" })
public class ApplicationConfig 
{

//	@Autowired
//	private Environment env;

//	@Bean
//	public ViewResolver jspViewResolver() {
//		UrlBasedViewResolver resolver = new ChainableUrlBasedViewResolver();
//		resolver.setPrefix("/resources/HTML/");
//		resolver.setSuffix(".html");
//		resolver.setOrder(0);
//		return resolver;
//	}
//	
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/HTML/**").addResourceLocations("/HTML/");
//    }
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}
	
	@Bean(name = "urlViewController")
    public UrlFilenameViewController getUrlViewController() {
        UrlFilenameViewController urlViewController = new UrlFilenameViewController();
        return urlViewController;
    }
     
    @Bean
    public SimpleUrlHandlerMapping getUrlHandlerMapping() {
        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.put("/**/*.html", "urlViewController");
         
        handlerMapping.setMappings(mappings);
        return handlerMapping;
    }
}
