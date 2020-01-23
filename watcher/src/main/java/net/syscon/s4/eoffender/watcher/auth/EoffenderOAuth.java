package net.syscon.s4.eoffender.watcher.auth;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EoffenderOAuth {
	
//	public static void main(String[] args) {
//		System.out.println(getIDToken());
//	}
	
	public static String getAuthToken() {
		
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/Elite2Web/oauth/token";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("ZWxpdGUyLXRydXN0ZWQtY2xpZW50OlNleWxzaWN0b2Vu");
		
		JSONObject requestJson = new JSONObject();
		requestJson.put("grant_type", "password");
		requestJson.put("username", "Pb5M0VUgeCzuI4u6gQ2W4A==");
		requestJson.put("password", "VmS6c3AsxrfXglBQq2GIzA==");
		
		HttpEntity<String> entity = new HttpEntity<String>(requestJson.toString(), headers);
		ResponseEntity<String> response = restTemplate.exchange(fooResourceUrl, HttpMethod.POST, entity, String.class);
		
		JSONObject jsonObject = new JSONObject(response.getBody());
		
		return jsonObject.get("access_token").toString();
	}
	
	public static String getIDToken() {
		
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder fooResourceUrl = new StringBuilder();
		fooResourceUrl.append("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?")
		              .append("key=")
				      .append("AIzaSyBZj-bKk33vwqWJptKqITNnogu8_vLdKIs");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		JSONObject requestJson = new JSONObject();
		requestJson.put("email", "demo-user-34934585@unitinnovations.com");
		requestJson.put("password", "b0hQ5lKduPi");
		requestJson.put("returnSecureToken", true);
		
		HttpEntity<String> entity = new HttpEntity<String>(requestJson.toString(), headers);
		ResponseEntity<String> response = restTemplate.exchange(fooResourceUrl.toString(), HttpMethod.POST, entity, String.class);
		
		JSONObject jsonObject = new JSONObject(response.getBody());
		
		return jsonObject.get("idToken").toString();
	}

}