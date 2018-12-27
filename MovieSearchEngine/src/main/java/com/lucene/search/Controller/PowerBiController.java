package com.lucene.search.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lucene.search.Model.PowerBiReportModel;
import com.lucene.search.Service.PowerBiService;

@Controller
@RequestMapping("/powerbi")
public class PowerBiController {
	
	@Autowired
	private PowerBiService powerBiService;
	
	@Autowired
	private PowerBiReportModel powerBiReportModel;
	
	@RequestMapping("/viewreport")
	public ModelAndView testPage2() throws JsonProcessingException {
		String accessToken = powerBiService.getAccessToken();
		String embedToken = powerBiService.getEmbedToken(accessToken);
		ModelAndView reportView = new ModelAndView();
		//reportView.addObject("embedToken", embedToken);
		reportView.setViewName("powerbi");
		
		powerBiReportModel.setEmbedUrl("https://app.powerbi.com/reportEmbed?reportId=feb96c19-cad7-478a-934d-2e647f98a4ff&groupId=1bef2b97-3211-4a73-8aad-580e412c4e78");
		powerBiReportModel.setGroupId("1bef2b97-3211-4a73-8aad-580e412c4e78");
		powerBiReportModel.setReportId("feb96c19-cad7-478a-934d-2e647f98a4ff");
		
		com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
		reportView.addObject("embedToken", objectMapper.writeValueAsString(embedToken));
		reportView.addObject("reportId",objectMapper.writeValueAsString(powerBiReportModel.getReportId()));
		reportView.addObject("groupId",objectMapper.writeValueAsString(powerBiReportModel.getGroupId()));
		reportView.addObject("embedUrl",objectMapper.writeValueAsString(powerBiReportModel.getEmbedUrl()));
		return reportView;
	}

}
