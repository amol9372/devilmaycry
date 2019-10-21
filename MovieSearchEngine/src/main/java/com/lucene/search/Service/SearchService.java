package com.lucene.search.Service;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.lucene.search.Model.PersonModel;
import com.lucene.search.Utils.SearchResults;

@Service
public class SearchService {

	@Autowired
	private SearchResults searchResults;
	
	public PersonModel getPersonDetails(String searchPhrase) {
		return null;
	}

	public JSONArray getSearchSuggestions(String searchPhrase) throws ParseException, IOException, JSONException {
        List<String> personSuggestions = searchResults.getPersonSuggestions(searchPhrase);
        
        JSONArray jsonArray = new JSONArray();
        for(String person : personSuggestions){
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put("name", person);
        	jsonArray.put(jsonObject);
        
        }
        
        return jsonArray;
	}

}
