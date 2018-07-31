package com.lucene.search.Controller;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restApi")
public class TestController2
{
	@RequestMapping("/getSampleList")
	public String testPage() throws JSONException{
		JSONArray jsonArray = new JSONArray();
	    String[] countries = new String[]{"india","pakistan","nepal","bhutan"};
	    for(String country:countries){
	    	JSONObject json = new JSONObject();
	    	json.put("name", country);
	    	jsonArray.put(json);
	    }
	    return jsonArray.toString();
	}
	
}
