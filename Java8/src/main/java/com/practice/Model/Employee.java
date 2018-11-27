package com.practice.Model;

import java.util.Optional;

public class Employee {

	private String name;
	private int id;
	private Enum degreeStatus;
	private Optional<Department> optionalDepartment;
	private Department department;

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}
	
	public Optional<Department> getOptionalDepartment() {
		return optionalDepartment;
	}

	public void setOptionalDepartment(Optional<Department> department) {
		this.optionalDepartment = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Enum getDegreeStatus() {
		return degreeStatus;
	}

	public void setDegreeStatus(Enum degreeStatus) {
		this.degreeStatus = degreeStatus;
	}

	

}

enum Degree {
	GIVEN, NOTGIVEN;
}