package practice.amol.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/user")
	public String loginUser() {
		return "USER - You have reached home";
	}
	
	@GetMapping("/admin")
	public String loginAdmin() {
		return "ADMIN - You have reached home";
	}
}
