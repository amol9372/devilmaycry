package com.practice.Model;

import java.util.Optional;

public class Employee {

	private String name;
	private int id;
	private Enum degreeStatus;
	private Optional<Department> optionalDepartment;
	private Department department;

	public Employee(String name, int id, Department department){
		this.name = name;
		this.id = id;
		this.department = new Department(department.getId(), department.getName());
	}
	
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=");
		builder.append(name);
		builder.append(", id=");
		builder.append(id);
		builder.append(", degreeStatus=");
		builder.append(degreeStatus);
		builder.append(", optionalDepartment=");
		builder.append(optionalDepartment);
		builder.append(", department=");
		builder.append(department);
		builder.append("]");
		return builder.toString();
	}

	

}

enum Degree {
	GIVEN, NOTGIVEN;
}