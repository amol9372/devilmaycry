package programs.examples.controller;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.init.ConfigInititalizer;
import programs.examples.model.LoginModel;
import programs.examples.service.RegisterService;

@Controller
public class RegistrationController implements ServletContextAware
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	private RegisterService registerService = RegisterService.getRegisterInstance();
	//private ConfigInititalizer config = ConfigInititalizer.getConfig(getServletContext()); 
	
	@RequestMapping(value = "/register.jsp", method = RequestMethod.GET)
    public ModelAndView registerEmployeePage(){
		LOGGER.info("[{}] REGISTER Controller {} ");
	    ModelAndView model = new ModelAndView("register");
	    return model;
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerEmployee(@ModelAttribute LoginModel loginModel){
		LOGGER.info(" REGISTER Controller Now [{}] ",loginModel.toString());
		registerService.registerEmployeeByAdmin(loginModel);
	    ModelAndView model = new ModelAndView("registersuccess");	    
	    model.addObject("employee", loginModel);
	    return model;
    }

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
