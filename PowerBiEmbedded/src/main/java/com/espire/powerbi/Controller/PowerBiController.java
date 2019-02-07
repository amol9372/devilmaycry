package com.espire.powerbi.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.espire.powerbi.Config.SpringConfig;
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
	
	@RequestMapping("/viewpagewisereports1")
	public ModelAndView viewPageWiseReports() throws JsonProcessingException {
		//PowerBiReportModel powerBiReportModel = new PowerBiReportModel();
		List<PowerBiReportModel> reportList = new ArrayList<>();
		
		//String accessToken = powerBiService.getAccessToken();
		
		ModelAndView reportView = new ModelAndView();
		//reportView.addObject("embedToken", embedToken);
		reportView.setViewName("powerbi2");
		
		//reportList.add(new PowerBiReportModel("12b1b8d1-1703-4c8f-a2dc-118c12010652","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=12b1b8d1-1703-4c8f-a2dc-118c12010652&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		//reportList.add(new PowerBiReportModel("3a73c36a-603a-404c-bb62-07068010b2b4","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=3a73c36a-603a-404c-bb62-07068010b2b4&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
//		reportList.add(new PowerBiReportModel("1887fbcb-2caa-4f40-b9b1-6ddc4e466186","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=1887fbcb-2caa-4f40-b9b1-6ddc4e466186&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("1887fbcb-2caa-4f40-b9b1-6ddc4e466186","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=1887fbcb-2caa-4f40-b9b1-6ddc4e466186&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		
		reportList.add(new PowerBiReportModel("f353054b-1e85-4043-9e40-5eb91dc06d9b","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("ace7cbb9-b547-49ab-bb88-8cc7b968bbe7","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=ace7cbb9-b547-49ab-bb88-8cc7b968bbe7&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		
		reportList.add(new PowerBiReportModel("0f5071ec-0f45-4583-9b00-4be9698ee7ae","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=0f5071ec-0f45-4583-9b00-4be9698ee7ae&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("9d7d348a-ddaa-49d1-b5dd-445e9f3816fa","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=9d7d348a-ddaa-49d1-b5dd-445e9f3816fa&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));

		String embedToken[] = new String[reportList.size()];
		int i=0;
		for(PowerBiReportModel powerBiReportModel : reportList){
			String accessToken = powerBiService.getAccessToken();
			embedToken[i] = powerBiService.getEmbedToken(powerBiReportModel, accessToken);
			//powerBiReportModel.setEmbedToken(embedToken);
			i++;
		}
		
		PowerBiModel powerBiModel = new PowerBiModel();
		powerBiModel.setReportList(reportList);
		
		
		Gson gson = new Gson();
		String reportJson = gson.toJson(powerBiModel);
		System.out.println(reportJson);
		
		com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
//		reportView.addObject("embedToken", objectMapper.writeValueAsString(embedToken));
//		reportView.addObject("reportId",objectMapper.writeValueAsString(powerBiReportModel.getReportId()));
//		reportView.addObject("groupId",objectMapper.writeValueAsString(powerBiReportModel.getGroupId()));
//		reportView.addObject("embedUrl",objectMapper.writeValueAsString(powerBiReportModel.getEmbedUrl()));
		//reportView.addObject("reportJson", objectMapper.writeValueAsString(reportJson));
		reportView.addObject("embedToken1", objectMapper.writeValueAsString(embedToken[0]));  //1887fbcb-2caa-4f40-b9b1-6ddc4e466186
		
		reportView.addObject("embedToken2", objectMapper.writeValueAsString(embedToken[1]));  //a983c854-32b6-43cc-8fa8-c879a5f90a31
		reportView.addObject("embedToken3", objectMapper.writeValueAsString(embedToken[2]));  //35fdaeec-503e-40c9-890b-b33fe449de56
		reportView.addObject("embedToken4", objectMapper.writeValueAsString(embedToken[3]));
		reportView.addObject("embedToken5", objectMapper.writeValueAsString(embedToken[4]));  //35fdaeec-503e-40c9-890b-b33fe449de56
		reportView.addObject("embedToken6", objectMapper.writeValueAsString(embedToken[5]));
		return reportView;
	}
	
	@RequestMapping("/viewpagewisereports2")
	public ModelAndView viewPageWiseReports2() throws JsonProcessingException {
		
		List<PowerBiReportModel> reportList = new ArrayList<>();
		ModelAndView reportView = new ModelAndView();
		
		reportView.setViewName("powerbi3");
	    reportList.add(new PowerBiReportModel("80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("f353054b-1e85-4043-9e40-5eb91dc06d9b","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("ace7cbb9-b547-49ab-bb88-8cc7b968bbe7","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=ace7cbb9-b547-49ab-bb88-8cc7b968bbe7&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("0f5071ec-0f45-4583-9b00-4be9698ee7ae","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=0f5071ec-0f45-4583-9b00-4be9698ee7ae&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("9d7d348a-ddaa-49d1-b5dd-445e9f3816fa","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=9d7d348a-ddaa-49d1-b5dd-445e9f3816fa&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));

		
		String embedToken[] = new String[reportList.size()];
		int i=0;
		for(PowerBiReportModel powerBiReportModel : reportList){
			String accessToken = powerBiService.getAccessToken();
			embedToken[i] = powerBiService.getEmbedToken(powerBiReportModel, accessToken);
			//powerBiReportModel.setEmbedToken(embedToken);
			i++;
		}
		
		PowerBiModel powerBiModel = new PowerBiModel();
		powerBiModel.setReportList(reportList);
		
		
		Gson gson = new Gson();
		String reportJson = gson.toJson(powerBiModel);
		System.out.println(reportJson);
		
		com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

		
		
		reportView.addObject("embedToken2", objectMapper.writeValueAsString(embedToken[0]));  //a983c854-32b6-43cc-8fa8-c879a5f90a31
		reportView.addObject("embedToken3", objectMapper.writeValueAsString(embedToken[1]));
		reportView.addObject("embedToken4", objectMapper.writeValueAsString(embedToken[2]));//35fdaeec-503e-40c9-890b-b33fe449de56		
		reportView.addObject("embedToken5", objectMapper.writeValueAsString(embedToken[3]));  //35fdaeec-503e-40c9-890b-b33fe449de56
		reportView.addObject("embedToken6", objectMapper.writeValueAsString(embedToken[4]));
		return reportView;
	}
	
	@RequestMapping("/viewautomatedreports1")
	public ModelAndView viewAutomatedReports() throws JsonProcessingException {
        List<PowerBiReportModel> reportList = powerbiUtils.getReportsFromFile("reports1");;
		
		ModelAndView reportView = new ModelAndView();
		
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
	
	@RequestMapping("/viewautomatedreports2")
	public ModelAndView viewAutomatedReports2() throws JsonProcessingException {
	
		List<PowerBiReportModel> reportList = powerbiUtils.getReportsFromFile("reports2");;
		
		ModelAndView reportView = new ModelAndView();
		
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
	
	
	@RequestMapping("/refreshcontext")
	public void refreshContext() {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		((ConfigurableApplicationContext) context).refresh();
		((ConfigurableApplicationContext) context).close();
	}

}
