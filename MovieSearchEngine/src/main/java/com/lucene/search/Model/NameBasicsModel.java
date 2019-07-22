package com.lucene.search.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


public class NameBasicsModel {
	private String primaryName;
	private int birthTear;
	private int DeathYear;
	private List<String> primaryProfession;
	
	public NameBasicsModel(String name, int birth, int death, List<String> profession){
		this.primaryName = name;
		this.birthTear = birth;
		this.DeathYear = death;
		//this.primaryProfession = new ArrayList<>(profession);
		
	}
	
	public String getPrimaryName() {
		return primaryName;
	}
	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}
	public int getBirthTear() {
		return birthTear;
	}
	public void setBirthTear(int birthTear) {
		this.birthTear = birthTear;
	}
	public int getDeathYear() {
		return DeathYear;
	}
	public void setDeathYear(int deathYear) {
		DeathYear = deathYear;
	}
	
	public List<String> getPrimaryProfession() {
		return primaryProfession;
	}

	public void setPrimaryProfession(List<String> primaryProfession) {
		this.primaryProfession = primaryProfession;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonModel [primaryName=");
		builder.append(primaryName);
		builder.append(", birthTear=");
		builder.append(birthTear);
		builder.append(", DeathYear=");
		builder.append(DeathYear);
		builder.append(", primaryProfession=");
		builder.append(primaryProfession);
		builder.append("]");
		return builder.toString();
	}

}
