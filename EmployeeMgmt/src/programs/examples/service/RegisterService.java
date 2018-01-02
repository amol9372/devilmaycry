package programs.examples.service;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import programs.examples.dao.RegisterDao;
import programs.examples.model.LoginModel;
import programs.examples.utils.EmployeeHelper;

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
    
    public void registerEmployeeByAdmin(LoginModel loginModel,Environment env){
    	LOGGER.info("Saving Employee login info ",loginModel.toString());    	
    	registerDao.registerEmployeeByAdmin(loginModel,env);
    }
    
    void registerEmployee(){
    	
    }
}
