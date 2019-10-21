package com.lucene.search.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucene.search.Service.SearchService;
import com.lucene.search.Utils.CustomMultipartFile;

@RestController
@RequestMapping("/restApi")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	private Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping("/getSampleList")
	public String testPage(HttpServletRequest request) throws JSONException, IOException {
		
		JSONArray jsonArray = new JSONArray();
		String[] countries = new String[] { "india", "pakistan", "nepal", "bhutan" };
		for (String country : countries) {
			JSONObject json = new JSONObject();
			json.put("name", country);
			jsonArray.put(json);
		}
		
		//logger.info("output is  :: ",jsonArray.toString());
		
		return jsonArray.toString();
	}

//	@RequestMapping(value = "/getPersonDetails/{searchPhrase}" , method = RequestMethod.GET)
//	public PersonModel searchNames(@PathVariable("searchPhrase") String searchPhrase){
//		
//		return new PersonModel("Amol Singh",1990,3000,Arrays.asList("Actor","Producer","Direct"));	
//	}
//	
//	@RequestMapping(value = "/getSearchSuggestions/{searchPhrase}" , method = RequestMethod.GET)
//	public String getSearchSugesstions(@PathVariable("searchPhrase") String searchPhrase) throws ParseException, IOException, JSONException{
//		JSONArray jsonArray = searchService.getSearchSuggestions(searchPhrase);
//		return jsonArray.toString();
//	}
//	
//	
//	@RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
//	public void displayId(@PathVariable("id") String id) {
//		System.out.println("Inside messages GET API , Id : " + id);
//	}
//
//	@RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
//	public void deleteId(@PathVariable("id") String id) {
//		System.out.println("Inside messages DELETE API , Id : " + id);
//	}
//
//	@RequestMapping(value = "/messages/{id}", method = RequestMethod.PUT)
//	public void updateId(@PathVariable("id") String id) {
//		System.out.println("Inside messages PUT API , Id : " + id);
//	}
//
//	@RequestMapping(value = "/messages/{id}", method = RequestMethod.POST)
//	public void postId(@PathVariable("id") String id) {
//		System.out.println("Inside messages POST API , Id : " + id);
//	}
	
	
	

}
