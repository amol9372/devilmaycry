package com.lucene.search.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lucene.search.Model.GoogleSignInProperties;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
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
        
		Request request = new Request.Builder()
		  .url(oauth2GetCodeUrl.toString()).get()
		  .addHeader("content-type", "application/x-www-form-urlencoded")
		  .addHeader("cache-control", "no-cache")
		  .build();
       
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public String getAccessToken(String code){
		OkHttpClient client = new OkHttpClient();
        String getAccessCodeUrl = env.getProperty("oauth2_token_url");
        RequestBody formBody = new MultipartBuilder()
                .type(MultipartBuilder.FORM)
                .addFormDataPart("code", code)
                .addFormDataPart("redirect_uri", getGoogleSignInProperties.getRedirect_uri())
                .addFormDataPart("client_id", getGoogleSignInProperties.getClient_id())
                .addFormDataPart("client_secret", getGoogleSignInProperties.getClient_secret())
                .addFormDataPart("grant_type", getGoogleSignInProperties.getGrant_type())
                .build();
		Request request = new Request.Builder()
		  .url(getAccessCodeUrl).post(formBody)
		  .addHeader("content-type", "application/x-www-form-urlencoded")
		  .addHeader("cache-control", "no-cache")
		  .build();
       
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response.toString());
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return null;
	}
}
