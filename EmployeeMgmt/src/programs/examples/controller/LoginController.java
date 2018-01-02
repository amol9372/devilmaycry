package programs.examples.controller;

import javax.validation.groups.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.model.LoginModel;
import programs.examples.model.PasswordChangeModel;
import programs.examples.service.AuthenticationService;
import programs.examples.utils.EmployeeStatusConstants;

@Controller
public class LoginController 
{	
	@Autowired
	private Environment env;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	private AuthenticationService authenticationService = AuthenticationService.getAuthenticationInstance();
	
	@RequestMapping(value = "/login.jsp" , method = RequestMethod.GET)
	public ModelAndView userLoginPage(){
		return new ModelAndView("Login");		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute LoginModel loginModel) {
		LOGGER.info("Employee trying to login [{}] ", loginModel.toString());
		ModelAndView loginView = new ModelAndView();
		loginView.addObject("loginModel", loginModel);
		String login = authenticationService.authenticateUser(loginModel,env);
		switch (login) {
		case "Authenticated":
			loginView.setViewName("dashboard");
			break;
		case "Authenticated First time Login":
			loginView.setViewName("changepassword");
			
			break;	
		case "Not Authenticated":
			loginView.setViewName("Login");
			loginView.addObject("invalid", "invalid user/password , Please try again");
			break;
	    default:
			loginView.setViewName("Login");
			loginView.addObject("invalid", "Login Error , Please try again");
			break;	
		}

		return loginView;
	}
	
	@RequestMapping(value = "/changePassword" , method = RequestMethod.POST)
	public ModelAndView userPasswordChange(@ModelAttribute PasswordChangeModel passwordChangeModel){
		LOGGER.info("Employee trying to change password [{}] ",passwordChangeModel.getUserid());
		ModelAndView passwordChangeView = new ModelAndView();
		String passwordStatus = authenticationService.changePasswordFirstTimeUser(passwordChangeModel, env);
		  switch(passwordStatus){
		    case EmployeeStatusConstants.PASSWORD_CHANGED:
		    	passwordChangeView.addObject("statusMessage", EmployeeStatusConstants.PASSWORD_CHANGED);		    	
		    	passwordChangeView.setViewName("changepassword");
		    	break;
		    case EmployeeStatusConstants.PASSWORD_CHANGE_ERROR:
		    	passwordChangeView.addObject("statusMessage", EmployeeStatusConstants.PASSWORD_CHANGE_ERROR);
		    	passwordChangeView.setViewName("changepassword");
		    	break;	
		    default:
		    	passwordChangeView.addObject("statusMessage", "Unable to change Password , Please try again");		    	
		    	passwordChangeView.setViewName("changepassword");
		  }
		return passwordChangeView;
	}
	
}
