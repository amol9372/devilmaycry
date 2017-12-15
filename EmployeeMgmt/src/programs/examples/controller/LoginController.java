package programs.examples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.model.LoginModel;
import programs.examples.service.RegisterService;

public class LoginController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login.jsp" , method = RequestMethod.GET)
	public ModelAndView userLoginPage(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute LoginModel loginModel){
		LOGGER.info("Employee trying to login",loginModel.toString());
		return new ModelAndView("login");
	}
}
