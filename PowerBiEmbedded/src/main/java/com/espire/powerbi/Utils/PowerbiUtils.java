package com.espire.powerbi.Utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.espire.powerbi.Model.PowerBiReportModel;

@Component
public class PowerbiUtils {

	@Autowired
	private Environment env;
	
	public static String getPowerBiAccessToken() {
		StringBuilder getAccessTokenParams = new StringBuilder();
		getAccessTokenParams.append("grant_type=password&scope=openid&resource=https%3A%2F%2Fanalysis.windows.net%2Fpowerbi%2Fapi&username=analytics%40espire.com%20&password=1nd1a%404321&client_id=d33a5f72-1584-49ab-86ba-f34e7fecbb77&client_secret=Qw8U8vHjGyChOOj1m460hDzJ43Q%2B9moMJRGKbJzYZyU%3D&undefined=").append("").append("").append("").append("").append("").append("").append("");
		StringBuilder responseString = null;
		try {
			URL url = new URL("https://login.microsoftonline.com/common/oauth2/token");
			byte[] postData = getAccessTokenParams.toString().getBytes(StandardCharsets.UTF_8);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setUseCaches(false);
			DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
			writer.write(postData);
			writer.flush();

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			responseString = new StringBuilder();
			String line = null;
			while ((line = in.readLine()) != null) {
				responseString.append(line);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject(responseString.toString());
		return jsonObject.get("access_token").toString();
	}
	
	public static String getEmbedToken(PowerBiReportModel powerBiReportModel, String accessToken) {
		StringBuilder getAccessTokenParams = new StringBuilder();
		getAccessTokenParams.append("{\r\n  \"accessLevel\": \"View\",\r\n  \"allowSaveAs\": \"false\"\r\n}").append("")
				.append("").append("").append("").append("").append("").append("");
		StringBuilder responseString = null;
		try {
			URL url = new URL(           // use builder here
					"https://api.powerbi.com/v1.0/myorg/groups/".concat(powerBiReportModel.getGroupId()).concat("/reports/").concat(powerBiReportModel.getReportId()).concat("/GenerateToken"));
			byte[] postData = getAccessTokenParams.toString().getBytes(StandardCharsets.UTF_8);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setRequestProperty("Authorization", "Bearer"+" "+ accessToken);
			conn.setUseCaches(false);
			DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
			writer.write(postData);
			writer.flush();

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			responseString = new StringBuilder();
			String line = null;
			while ((line = in.readLine()) != null) {
				responseString.append(line);
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject(responseString.toString());
		return jsonObject.getString("token");
	}
	
	public List<PowerBiReportModel> getReportsFromFile(String url){
		List<PowerBiReportModel> reportList = new ArrayList<>();
		String[] reportsArray = env.getProperty(url).split(",");
		
		for(String reportId : reportsArray) {
			String embedUrl = "https://app.powerbi.com/reportEmbed?reportId=".concat(reportId).concat("&groupId=").concat(env.getProperty("groupId"));
			reportList.add(new PowerBiReportModel(reportId,env.getProperty("groupId"),embedUrl,""));
		}
		
		return reportList;
		
	}
	
}
