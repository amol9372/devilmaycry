package programs.examples.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import programs.examples.dao.RegisterDao;
import programs.examples.init.ConfigInititalizer;
import programs.examples.model.LoginModel;

public class RegisterService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);
	
    private static RegisterService registerService = null;
    
    private RegisterDao registerDao = RegisterDao.getRegisterInstance();
    
    public static RegisterService getRegisterInstance(){
    	if(registerService == null)
    		registerService = new RegisterService();
    	return registerService;
    }
    
    public void registerEmployeeByAdmin(LoginModel loginModel){
    	LOGGER.info("Saving Employee login info ",loginModel.toString());
    	registerDao.registerEmployeeByAdmin(loginModel);
    }
    
    void registerEmployee(){
    	
    }
}
