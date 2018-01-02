package programs.examples.service;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import programs.examples.dao.LoginDao;
import programs.examples.model.LoginModel;
import programs.examples.model.PasswordChangeModel;
import programs.examples.utils.EmployeeHelper;

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
    
	public String authenticateUser(LoginModel loginModel, Environment env) {
		String login = "Not Authenticated";
		try {
			LoginModel loginModelDB = loginDao.validateUser(loginModel, env);
			firstTimeLogin = loginModelDB.getFirst_login() == 1 ? true : false;
			
			if (!EmployeeHelper.isEmpty(loginModelDB.getPassword_hash())
					&& loginModelDB.getPassword_hash().equals(EmployeeHelper.getHashFromPassword(loginModel.getPassword_hash()))) {
				if (firstTimeLogin) {
					LOGGER.info("User Authenticated : First time user [{}] ", loginModel.toString());
					login = "Authenticated First time Login";
				} else {
					LOGGER.info("User Authenticated [{}] ", loginModel.toString());
					login = "Authenticated";
					LOGGER.info(" Updating login info [{}] ", loginModel.toString());
					loginDao.updateLoginInfo(loginModel, env);
				}

			} else
				LOGGER.error("User/Password dosent match [{}] ", loginModel.toString());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	public String changePasswordFirstTimeUser(PasswordChangeModel passwordChangeModel,Environment env){	
		return loginDao.changePassword(passwordChangeModel, env);
	}
    
}

