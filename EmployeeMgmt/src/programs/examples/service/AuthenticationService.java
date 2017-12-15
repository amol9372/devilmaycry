package programs.examples.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import programs.examples.model.LoginModel;

public class AuthenticationService 
{
private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);
	
    private static AuthenticationService authenticationService;
    
    public static AuthenticationService getAuthenticationInstance(){
    	if(authenticationService == null)
    		authenticationService = new AuthenticationService();
    	return authenticationService;
    } 
    
    public void authenticateUser(LoginModel loginModel){
    	
    }
}
