package com.practice.LuceneSearch.practice;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucene.search.Model.PersonModel;

public class DependencyInjection {
	public static void main(String[] args) {
	    	
	}

}


class Employee{
	//private PersonModel personModel;
	@Autowired
	public void displayPerson(PersonModel personModel) {
		System.out.println(personModel.toString());
	}
	
}