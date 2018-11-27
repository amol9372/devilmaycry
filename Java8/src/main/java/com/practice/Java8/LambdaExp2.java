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
		System.out.println("List is "+validList);
		
		//Department dept1 = new Employee().getDepartment().get();
		
		Optional<Department> dept = new Employee().getOptionalDepartment();
		
		Optional<Department> dept1 = Optional.ofNullable(new Employee().getDepartment());
		
		Department department = dept1.orElse(new Department());
		
		dept1.ifPresent((d) -> {
			System.out.println(d.getName());
		});
		
		
 	}
		
	
}
