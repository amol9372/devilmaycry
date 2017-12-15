package programs.examples.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import programs.examples.model.LoginModel;

public class RegisterService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);
	
    private static RegisterService registerService;
    
    public static RegisterService getRegisterInstance(){
    	if(registerService == null)
    		registerService = new RegisterService();
    	return registerService;
    }
    
    public void registerEmployeeByAdmin(LoginModel loginModel){
    	LOGGER.info("Saving Employee login info ",loginModel.toString());
    	//save Employee
    }
    
    void registerEmployee(){
    	
    }
}
