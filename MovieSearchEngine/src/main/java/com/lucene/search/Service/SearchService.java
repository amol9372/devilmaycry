package com.lucene.search.Service;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucene.search.Model.PersonModel;
import com.lucene.search.Utils.SearchResults;

@Service
public class SearchService {

	@Autowired
	private SearchResults searchResults;
	
	public PersonModel getPersonDetails(String searchPhrase) {
		return null;
	}

	public List<String> getSearchSuggestions(String searchPhrase) throws ParseException, IOException {
        List<String> personSuggestions = searchResults.getPersonSuggestions(searchPhrase);
        return personSuggestions;
	}

}
