package com.lucene.search.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucene.search.Model.PersonModel;
import com.lucene.search.Service.SearchService;

@RestController
@RequestMapping("/restApi")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/getSampleList")
	public String testPage() throws JSONException {
		JSONArray jsonArray = new JSONArray();
		String[] countries = new String[] { "india", "pakistan", "nepal", "bhuta" };
		for (String country : countries) {
			JSONObject json = new JSONObject();
			json.put("name", country);
			jsonArray.put(json);
		}
		return jsonArray.toString();
	}

	@RequestMapping(value = "/getPersonDetails/{searchPhrase}" , method = RequestMethod.GET)
	public PersonModel searchNames(@PathVariable("searchPhrase") String searchPhrase){
		
		return new PersonModel("Amol Singh",1990,3000,Arrays.asList("Actor","Producer","Direct"));	
	}
	
	@RequestMapping(value = "/getSearchSuggestions/{searchPhrase}" , method = RequestMethod.GET)
	public List<String> getSearchSugesstions(@PathVariable("searchPhrase") String searchPhrase) throws ParseException, IOException{
		
		return searchService.getSearchSuggestions(searchPhrase);
	}
	
	
	@RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
	public void displayId(@PathVariable("id") String id) {
		System.out.println("Inside messages GET API , Id : " + id);
	}

	@RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
	public void deleteId(@PathVariable("id") String id) {
		System.out.println("Inside messages DELETE API , Id : " + id);
	}

	@RequestMapping(value = "/messages/{id}", method = RequestMethod.PUT)
	public void updateId(@PathVariable("id") String id) {
		System.out.println("Inside messages PUT API , Id : " + id);
	}

	@RequestMapping(value = "/messages/{id}", method = RequestMethod.POST)
	public void postId(@PathVariable("id") String id) {
		System.out.println("Inside messages POST API , Id : " + id);
	}

}
