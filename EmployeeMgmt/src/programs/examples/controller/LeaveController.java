package programs.examples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.model.LoginModel;

@Controller
@SessionAttributes("employeeSession")
public class LeaveController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/leave/{userId}", method = RequestMethod.GET)
	public ModelAndView leave(@PathVariable int userId) {
		ModelAndView leaveView = new ModelAndView();
		leaveView.setViewName("leave");
		leaveView.addObject("empid", userId);
		return leaveView;
	}
	
	@RequestMapping(value = "/applyLeave", method = RequestMethod.GET)
	public ModelAndView applyleave(@PathVariable int userId) {
		ModelAndView leaveView = new ModelAndView();
		leaveView.setViewName("leave");
		leaveView.addObject("empid", userId);
		return leaveView;
	}
}
