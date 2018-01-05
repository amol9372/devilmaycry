package programs.examples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import programs.examples.model.EmployeeInfo;

//@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "programs.examples")
@PropertySource("classpath:application.properties")
public class SampleConfig 
{
	@Bean
    public EmployeeInfo employeeInfo(){
    	return new EmployeeInfo();
    }
	
	@Autowired
	private Environment env;
	
	public static void main(String args[]){
		
	}
	
}
