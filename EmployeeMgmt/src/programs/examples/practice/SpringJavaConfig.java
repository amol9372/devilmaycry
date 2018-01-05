package programs.examples.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import programs.examples.config.SampleConfig;
import programs.examples.model.EmployeeInfo;

@Component
public class SpringJavaConfig 
{
    public static void main(String args[]){
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SampleConfig.class);  
    	EmployeeInfo employee = ctx.getBean(EmployeeInfo.class);
    	employee.setUserId(123123);
    	System.out.println(employee);
    }
}

class EmployeeService
{
	private EmployeeInfo employeeInfo;

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

}