package programs.examples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.init.ConfigInititalizer;
import programs.examples.model.LoginModel;
import programs.examples.service.AuthenticationService;

@Controller
public class LoginController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	private AuthenticationService authenticationService = AuthenticationService.getAuthenticationInstance();
	
	@RequestMapping(value = "/login.jsp" , method = RequestMethod.GET)
	public ModelAndView userLoginPage(){
		ConfigInititalizer config = ConfigInititalizer.getConfig();
		System.out.println(config.getProperty("DRIVER_NAME"));
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute LoginModel loginModel) {
		LOGGER.info("Employee trying to login [{}] ", loginModel.toString());
		ModelAndView loginView = new ModelAndView();
		loginView.addObject("loginModel", loginModel);
		String login = authenticationService.authenticateUser(loginModel);
		switch (login) {
		case "Authenticated":
			loginView.setViewName("dashboard");
			break;
		case "Authenticated First time Login":
			loginView.setViewName("changepassword");
			break;	
		case "Not Authenticated":
			loginView.setViewName("login");
			loginView.addObject("invalid", "invalid user/password");
			break;
		}

		return loginView;
	}
	
	@RequestMapping(value = "/changePassword" , method = RequestMethod.POST)
	public ModelAndView userPasswordChange(@ModelAttribute LoginModel loginModel){
		LOGGER.info("Employee trying to change password [{}] ",loginModel.toString());
		authenticationService.authenticateUser(loginModel);
		return new ModelAndView("passwordchangesuccess");
	}
	
}
