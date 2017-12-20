package programs.examples.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import programs.examples.dao.LoginDao;
import programs.examples.model.LoginModel;

public class AuthenticationService 
{

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);
	
	private static AuthenticationService authenticationService;
	
	LoginDao loginDao = LoginDao.getLoginInstance();
    
	private boolean firstTimeLogin = false;
	
    public static AuthenticationService getAuthenticationInstance(){
    	if(authenticationService == null)
    		authenticationService = new AuthenticationService();
    	return authenticationService;
    } 
    
    public String authenticateUser(LoginModel loginModel){
    	String login = "Not Authenticated";
    	if(loginModel.getUserid()!=0 && loginModel.getPassword_hash()!=null){
    		firstTimeLogin = loginModel.getFirst_login();  		
    		if(firstTimeLogin)
    		 LOGGER.info(" First time user [{}] ",loginModel.toString());
    		 
    		login = "Authenticated";
    	}
    	else {
    		LOGGER.info(" UserID or Password dosent match [{}] ",loginModel.toString());
    	}
    	return login;
    }
    
}

