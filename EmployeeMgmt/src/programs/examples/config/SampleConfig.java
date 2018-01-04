package programs.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import programs.examples.model.EmployeeInfo;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "programs.examples")
public class SampleConfig 
{
	@Bean
    public EmployeeInfo employeeInfo(){
    	return new EmployeeInfo();
    }
}
