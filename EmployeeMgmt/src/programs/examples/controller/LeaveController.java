package programs.examples.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("session")
public class LeaveController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	private int count;
	
	@RequestMapping(value = "/leave.jsp", method = RequestMethod.GET)
	public ModelAndView leave(HttpSession session) {
		ModelAndView leaveView = new ModelAndView();
		leaveView.setViewName("leave");
		int userid = (int) session.getAttribute("userid");
		leaveView.addObject("session", userid);
		leaveView.addObject("count", count);
		leaveView.addObject("sessionCreatedTime",new Date(session.getCreationTime()));
		leaveView.addObject("lastAccessedTime",new Date(session.getLastAccessedTime()));
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
