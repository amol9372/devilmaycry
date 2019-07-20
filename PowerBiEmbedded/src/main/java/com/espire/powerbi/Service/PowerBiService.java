package com.espire.powerbi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.espire.powerbi.Model.PowerBiReportModel;
import com.espire.powerbi.Utils.PowerbiUtils;

@Service
public class PowerBiService {
	
	@Autowired
	private Environment env;
	
	public String getAccessToken() {
		return PowerbiUtils.getPowerBiAccessToken();
	}
	
	public String getEmbedToken(PowerBiReportModel powerBiReportModel, String accessToken){
		return PowerbiUtils.getEmbedToken(powerBiReportModel, accessToken);
	}
	
//	public List<PowerBiReportModel> getReportListFromGroupId(String groupId, String accessToken){
//		String reportList =  PowerbiUtils.getReportListFromGroupId(groupId, accessToken);
//		
//	}

}
