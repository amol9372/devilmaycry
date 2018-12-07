package com.practice.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.practice.Model.Department;
import com.practice.Model.Employee;

public class LambdaExp2 {

	static List<String> nameList = Arrays.asList("Amol", "Robin", "Rahul", "Rishab");
	
	public static void main(String[] args) throws Exception {
//		Consumer<List<String>> displayList = (l) -> l.forEach(item -> System.out.println(item));
//		displayList.accept(nameList);
		
		Predicate<List<String>> checkListContainsNameOrNot = (l) -> l.contains("Amol");
		Predicate<List<String>> checkListSizeGreaterThan4 = (l) -> l.size() > 4 ;
		
		boolean validList = checkListContainsNameOrNot.and(checkListSizeGreaterThan4).test(nameList);
		//System.out.println("List is "+validList);
	    
		Employee employee = getEmployee();
		Department dept2 = null;
		Optional<Department> department = Optional.ofNullable(employee.getDepartment());
		Department department2 = Optional.ofNullable(dept2).orElse(employee.getDepartment());
		
		department.ifPresent(d -> {System.out.println(d.getName());});
		
		System.out.println(department2.getId());
		
 	}
	
	static Employee getEmployee(){
		return new Employee("Amol", 98446, new Department(1, "CSE"));
	}
		
	public void testAutowiringAnnotation(){
		System.out.println("this annotation is working");
	}
}
