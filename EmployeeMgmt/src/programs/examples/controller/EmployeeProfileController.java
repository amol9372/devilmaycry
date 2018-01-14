package programs.examples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.model.EmployeeInfo;
import programs.examples.service.ProfileService;

@Controller
public class EmployeeProfileController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProfileController.class);

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/profile.jsp", method = RequestMethod.GET)
	public ModelAndView userProfile(@RequestParam(value = "empid") int empid) {	
		ModelAndView profileView = new ModelAndView();
		EmployeeInfo employeeInfo = profileService.getEmployeeInfo(empid);
		profileView.setViewName("profile");
		profileView.addObject("employee",employeeInfo);
		return profileView;
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView userProfile(@ModelAttribute EmployeeInfo employeeInfo) {
		return new ModelAndView("profile");
	}
	
	
}
