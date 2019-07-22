package com.espire.powerbi.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.espire.powerbi.Config.SpringConfig;
import com.espire.powerbi.Model.LoginModel;
import com.espire.powerbi.Model.PowerBiModel;
import com.espire.powerbi.Model.PowerBiReportModel;
import com.espire.powerbi.Service.PowerBiService;
import com.espire.powerbi.Utils.PowerbiUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

@Controller
@RequestMapping("/powerbi")
public class PowerBiController {
	
	@Autowired
	private PowerBiService powerBiService;
	
	@Autowired
	private PowerbiUtils powerbiUtils;
	
	@RequestMapping("/viewautomatedreports")
	public ModelAndView viewAutomatedReports2(@RequestParam("domain") String domain) throws JsonProcessingException {	
		ModelAndView reportView = new ModelAndView();
		
		if (domain.equals("IMPELLAM")) {
			reportView.setViewName("loginpage");
			return reportView;
		}
		
		List<PowerBiReportModel> reportList = powerbiUtils.getReportsFromFile(domain);		
		
		reportList.stream().filter(l -> l.getReportId().equals("sdafwsfw"));
		
		
		if(reportList == null){
			reportView.setViewName("errorpage");
			reportView.addObject("errorMessage", "No Reports are added for this URL");
			return reportView;
		}
	
		reportView.setViewName("powerbi4");
		
		for(PowerBiReportModel powerBiReportModel : reportList){
			String accessToken = powerBiService.getAccessToken();			
			powerBiReportModel.setEmbedToken(powerBiService.getEmbedToken(powerBiReportModel, accessToken));			
		}
		
		PowerBiModel powerBiModel = new PowerBiModel();
		powerBiModel.setReportList(reportList);
		
		Gson gson = new Gson();
		String reportJson = gson.toJson(powerBiModel);
		System.out.println(reportJson);
		
		com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
		reportView.addObject("reportJson", objectMapper.writeValueAsString(reportJson));

		return reportView;
	}
	
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute LoginModel loginModel){
		ModelAndView reportView = new ModelAndView();
		if(loginModel.getUserid().equalsIgnoreCase("impellam") && loginModel.getPassw().equals("espire@12")){
			List<PowerBiReportModel> reportList = powerbiUtils.getReportsFromFile("IMPELLAM");		
			
			if(reportList == null){
				reportView.setViewName("errorpage");
				reportView.addObject("errorMessage", "No Reports are added for this URL");
				return reportView;
			}
		
			reportView.setViewName("powerbi4");
			
			for(PowerBiReportModel powerBiReportModel : reportList){
				String accessToken = powerBiService.getAccessToken();			
				powerBiReportModel.setEmbedToken(powerBiService.getEmbedToken(powerBiReportModel, accessToken));			
			}
			
			PowerBiModel powerBiModel = new PowerBiModel();
			powerBiModel.setReportList(reportList);
			
			Gson gson = new Gson();
			String reportJson = gson.toJson(powerBiModel);
			System.out.println(reportJson);
			
			com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
			try {
				reportView.addObject("reportJson", objectMapper.writeValueAsString(reportJson));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			reportView.setViewName("loginpage");
			reportView.addObject("invalid", "Invalid UserId/Password , Please try again");
		}
		
		return reportView;
	}
	
	@GetMapping("/login.jsp")
	public ModelAndView loginPage(){
		ModelAndView reportView = new ModelAndView();
		reportView.setViewName("loginpage");
		return reportView;
	}
	
	
	
    
}
