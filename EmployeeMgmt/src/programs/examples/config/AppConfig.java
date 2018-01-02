package programs.examples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "programs.examples")
public class AppConfig
{
//	@Autowired
//	private static Environment env;
//	
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/view2/");
//		viewResolver.setOrder(0);
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
//	
//	@Bean
//	public InternalResourceViewResolver viewResolver2() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/view/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
//	
//	public static String getProperty(String key){
//		return env.getProperty(key);
//	}
	  @Bean
	  public ViewResolver jspViewResolver() {
	    UrlBasedViewResolver resolver = new ChainableUrlBasedViewResolver();
	    resolver.setPrefix("/WEB-INF/view/");
	    resolver.setSuffix(".jsp");
	    resolver.setOrder(0);
	    return resolver;
	  }
	  @Bean
	  public ViewResolver jspViewResolver2() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/view2/");
	    resolver.setSuffix(".jsp");
	    resolver.setOrder(1);
	    return resolver;
	  }
}
