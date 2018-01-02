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

import programs.examples.model.EmployeeInfo;
import programs.examples.service.AuthenticationService;
import programs.examples.service.ProfileService;

@Controller
public class EmployeeProfileController 
{
	@Autowired
	private Environment env;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProfileController.class);

	private ProfileService profileService = ProfileService.getProfileInstance();

	@RequestMapping(value = "/profile.jsp", method = RequestMethod.GET)
	public ModelAndView userProfile() {
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView userProfile(@ModelAttribute EmployeeInfo employeeInfo) {
		return new ModelAndView("profile");
	}
	
	
}
