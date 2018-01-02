package programs.examples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.model.LoginModel;
import programs.examples.service.RegisterService;

@Controller
public class RegistrationController
{
	@Autowired
	private Environment env;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	
	private RegisterService registerService = RegisterService.getRegisterInstance();
	
	@RequestMapping(value = "/register.jsp", method = RequestMethod.GET)
    public ModelAndView registerEmployeePage(){
		LOGGER.info("[{}] REGISTER Controller {} ");
	    ModelAndView model = new ModelAndView("register");
	    return model;
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerEmployee(@ModelAttribute LoginModel loginModel){
		LOGGER.info(" REGISTER Controller Now [{}] ",loginModel.toString());
		registerService.registerEmployeeByAdmin(loginModel,env);
	    ModelAndView model = new ModelAndView("registersuccess");	    
	    model.addObject("employee", loginModel);
	    return model;
    }
	
	
}
