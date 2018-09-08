package com.lucene.search.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lucene.search.Service.GoogleSigninService;

@Controller
@RequestMapping("/")
public class TestController 
{
	@Autowired
	private GoogleSigninService googleSigninService;
	
	@RequestMapping("/test")
	public ModelAndView testPage2(){
		return new ModelAndView("testview");
	}
	
	@RequestMapping("/googleOAuth")
	public void googleOauth2(){
		googleSigninService.oauth2Service();
	}
	
	@RequestMapping("/googleOAuthCallback")
	public void googleOauth2Callback(@RequestParam("code") String code){
		String accessToken = googleSigninService.getAccessToken(code);
	}
	
}
