package com.lucene.search.Utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class PowerbiUtils {

	@Autowired
	private Environment env;
	
	public static String getPowerBiAccessToken() {
		StringBuilder getAccessTokenParams = new StringBuilder();
		getAccessTokenParams.append("grant_type=password&scope=openid&resource=https%3A%2F%2Fanalysis.windows.net%2Fpowerbi%2Fapi&username=amol.singh%40espire.com&password=Daredevil%4012&client_id=b8d851b1-45da-436c-8c90-ef3697fb6133&client_secret=dYnZtZOZbEKwNuMR3yErmx1PF9Vc1vREowQuTeX1Yig%3D&undefined=").append("").append("").append("").append("").append("").append("").append("");
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
	
	public static String getEmbedToken(String accessToken) {
		StringBuilder getAccessTokenParams = new StringBuilder();
		getAccessTokenParams.append("{\r\n  \"accessLevel\": \"View\",\r\n  \"allowSaveAs\": \"false\"\r\n}").append("")
				.append("").append("").append("").append("").append("").append("");
		StringBuilder responseString = null;
		try {
			URL url = new URL(
					"https://api.powerbi.com/v1.0/myorg/groups/1bef2b97-3211-4a73-8aad-580e412c4e78/reports/feb96c19-cad7-478a-934d-2e647f98a4ff/GenerateToken");
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
	
}
