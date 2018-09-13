package com.lucene.search.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lucene.search.Model.GoogleSignInProperties;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Service
public class GoogleSigninService 
{
	@Autowired
    private Environment env;
	
	@Autowired
	private GoogleSignInProperties getGoogleSignInProperties;
	
	public void oauth2Service(){
		OkHttpClient client = new OkHttpClient();
        StringBuilder oauth2GetCodeUrl = new StringBuilder();
        oauth2GetCodeUrl.append(env.getProperty("oauth2_url"));
        oauth2GetCodeUrl.append("scope=").append(getGoogleSignInProperties.getScope());
        oauth2GetCodeUrl.append("&redirect_uri=").append(getGoogleSignInProperties.getRedirect_uri());
        oauth2GetCodeUrl.append("&response_type=").append(getGoogleSignInProperties.getResponse_id());
        oauth2GetCodeUrl.append("&client_id=").append(getGoogleSignInProperties.getClient_id());
        oauth2GetCodeUrl.append("&approval_prompt=").append(getGoogleSignInProperties.getApproval_prompt());
        String url = "https://accounts.google.com/ServiceLogin?passive=1209600&continue="
        		+ "https://accounts.google.com/o/oauth2/auth?scope%3Demail%26redirect_uri%3Dhttp://"
        		+ "localhost:8080/MovieSearch/webapi/googleOAuthCallback%26response_type%3Dcode%26client_id"
        		+ "%3D52424919169-remgpb2h4nhdua57plc1cem4p0qo4if8.apps.googleusercontent.com%26approval_pro"
        		+ "mpt%3Dforce%26from_login%3D1%26as%3DatFtpaSn4kKndbhQEAXn1w&followup=https://accounts.google.com/"
        		+ "o/oauth2/auth?scope%3Demail%26redirect_uri%3Dhttp://localhost:8080/MovieSearch/webapi/googleOAuth"
        		+ "Callback%26response_type%3Dcode%26client_id%3D52424919169-remgpb2h4nhdua57plc1cem4p0qo4if8.apps.g"
        		+ "oogleusercontent.com%26approval_prompt%3Dforce%26from_login%3D1%26as%3DatFtpaSn4kKndbhQEAXn1w&oauth=1&sarp=1&scc=1";
		Request request = new Request.Builder()
		  .url(url).get()
		  .addHeader("content-type", "application/x-www-form-urlencoded")
		  .addHeader("cache-control", "no-cache")
		  .build();
       
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public String getAccessToken(String code) throws IOException{
		
        StringBuilder getAccessTokenParams = new StringBuilder();
   
        getAccessTokenParams.append("code").append(code);
        getAccessTokenParams.append("&redirect_uri=").append(getGoogleSignInProperties.getRedirect_uri());
        getAccessTokenParams.append("&client_id=").append(getGoogleSignInProperties.getClient_id());
        getAccessTokenParams.append("&client_secret=").append(getGoogleSignInProperties.getClient_secret());
        getAccessTokenParams.append("&grant_type=").append(getGoogleSignInProperties.getGrant_type());
        byte[] postData       = getAccessTokenParams.toString().getBytes( StandardCharsets.UTF_8 );    
//		Request request = new Request.Builder()
//		  .url(getAccessCodeUrl).post(formBody)
//		  .addHeader("content-type", "application/x-www-form-urlencoded")
//		  .addHeader("cache-control", "no-cache")
//		  .build();
		URL url = new URL(env.getProperty("oauth2_token_url"));
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();  
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		//conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
		conn.setUseCaches( false );
		DataOutputStream writer = new DataOutputStream( conn.getOutputStream());
		writer.write(postData);
		writer.flush();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			StringBuilder responseString = new StringBuilder();
			while ((in.readLine()) != null) {
				responseString.append(responseString);
			}
			JsonObject json = (JsonObject) new JsonParser().parse(responseString.toString());

		} catch (IOException e) {			
			e.printStackTrace();
		}
		return null;
	}
}
