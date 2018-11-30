package com.lucene.search.Utils;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lucene.search.Model.PersonModel;
import com.practice.LuceneSearch.practice.LuceneDemo;

@Component
public class SearchResults {
	
	@Autowired
	private LuceneDemo getLuceneDemo;
    
	public PersonModel getPersonDetails(String searchPhrase){
		return null;
	}
	
	public List<String> getPersonSuggestions(String searchPhrase) throws ParseException, IOException{
		return getLuceneDemo.getSearchSuggestions(searchPhrase, "primaryName");
	}
}
