package com.lucene.search.Model;

import java.util.ArrayList;
import java.util.List;

public class PersonModel {
	
	private String primaryName;
	private int birthTear;
	private int DeathYear;
	private List<String> primaryProfession;
	
	public PersonModel(String name, int birth, int death, List<String> profession){
		this.primaryName = name;
		this.birthTear = birth;
		this.DeathYear = death;
		this.primaryProfession = new ArrayList<>(profession); 
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