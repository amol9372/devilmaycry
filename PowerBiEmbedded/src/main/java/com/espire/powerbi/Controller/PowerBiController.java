package com.espire.powerbi.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.espire.powerbi.Model.PowerBiModel;
import com.espire.powerbi.Model.PowerBiReportModel;
import com.espire.powerbi.Service.PowerBiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
@Controller
@RequestMapping("/powerbi")
public class PowerBiController {
	
	@Autowired
	private PowerBiService powerBiService;
	
//	@RequestMapping("/viewreport")
//	public ModelAndView viewReport() throws JsonProcessingException {
//		String accessToken = powerBiService.getAccessToken();
//		String embedToken = powerBiService.getEmbedToken(accessToken);
//		ModelAndView reportView = new ModelAndView();
//		//reportView.addObject("embedToken", embedToken);
//		reportView.setViewName("powerbi2");
//		PowerBiReportModel powerBiReportModel = new PowerBiReportModel();
////		powerBiReportModel.setEmbedUrl("https://app.powerbi.com/reportEmbed?reportId=77fe6cb3-7882-4a8c-9a58-05024a997210&groupId=cccf4917-3887-40e5-a7e3-710ad2864156");
////		powerBiReportModel.setGroupId("cccf4917-3887-40e5-a7e3-710ad2864156");
////		powerBiReportModel.setReportId("77fe6cb3-7882-4a8c-9a58-05024a997210");
//		
//		com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
//		reportView.addObject("embedToken", objectMapper.writeValueAsString(embedToken));
//		reportView.addObject("reportId",objectMapper.writeValueAsString(powerBiReportModel.getReportId()));
//		reportView.addObject("groupId",objectMapper.writeValueAsString(powerBiReportModel.getGroupId()));
//		reportView.addObject("embedUrl",objectMapper.writeValueAsString(powerBiReportModel.getEmbedUrl()));
//				
//		return reportView;
//	}
	
	@RequestMapping("/viewallreports")
	public ModelAndView viewAllReports() throws JsonProcessingException {
		//PowerBiReportModel powerBiReportModel = new PowerBiReportModel();
		List<PowerBiReportModel> reportList = new ArrayList<>();
		
		//String accessToken = powerBiService.getAccessToken();
		
		ModelAndView reportView = new ModelAndView();
		//reportView.addObject("embedToken", embedToken);
		reportView.setViewName("powerbi");
		
//		reportList.add(new PowerBiReportModel("d044ca01-26a9-40e1-94fd-1d5384b4b696","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=d044ca01-26a9-40e1-94fd-1d5384b4b696&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
//		reportList.add(new PowerBiReportModel("2c4f5bbd-8242-426d-bdec-7e2a51c26841","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=2c4f5bbd-8242-426d-bdec-7e2a51c26841&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
//		reportList.add(new PowerBiReportModel("b66479ee-f7c5-4d97-8529-ddca2c5a32f6","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=b66479ee-f7c5-4d97-8529-ddca2c5a32f6&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("12b1b8d1-1703-4c8f-a2dc-118c12010652","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=12b1b8d1-1703-4c8f-a2dc-118c12010652&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("3a73c36a-603a-404c-bb62-07068010b2b4","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=3a73c36a-603a-404c-bb62-07068010b2b4&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		
		for(PowerBiReportModel powerBiReportModel : reportList){
			String accessToken = powerBiService.getAccessToken();
			String embedToken = powerBiService.getEmbedToken(powerBiReportModel, accessToken);
			powerBiReportModel.setEmbedToken(embedToken);
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
		reportView.addObject("reportJson", objectMapper.writeValueAsString(reportJson));
				
		return reportView;
	}
	
	@RequestMapping("/viewpagewisereports")
	public ModelAndView viewPageWiseReports() throws JsonProcessingException {
		//PowerBiReportModel powerBiReportModel = new PowerBiReportModel();
		List<PowerBiReportModel> reportList = new ArrayList<>();
		
		//String accessToken = powerBiService.getAccessToken();
		
		ModelAndView reportView = new ModelAndView();
		//reportView.addObject("embedToken", embedToken);
		reportView.setViewName("powerbi2");
		
		reportList.add(new PowerBiReportModel("12b1b8d1-1703-4c8f-a2dc-118c12010652","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=12b1b8d1-1703-4c8f-a2dc-118c12010652&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		reportList.add(new PowerBiReportModel("3a73c36a-603a-404c-bb62-07068010b2b4","cb6d2214-38ec-405c-a7fc-92d3c32602f9","https://app.powerbi.com/reportEmbed?reportId=3a73c36a-603a-404c-bb62-07068010b2b4&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9",""));
		
		String embedToken[] = new String[2];
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
		reportView.addObject("embedToken2", objectMapper.writeValueAsString(embedToken[0]));
		reportView.addObject("embedToken1", objectMapper.writeValueAsString(embedToken[1]));		
		return reportView;
	}

}
