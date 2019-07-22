package com.practice.Java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.practice.Model.Department;
import com.practice.Model.Employee;

public class AInnerClass {
	public static void main(String[] args) {
//		String[] templateNameUri = "uakvbdfk-avqwkdgbkq".split("-", 3);
//      
//      
//        System.out.println(templateNameUri);
		
		List<String> l = new ArrayList<>(); l.add("Amol"); l.add("Ankur");
		System.out.println(l.toString());

		l.stream().filter(l1 -> l1.equals("Amol")).collect(Collectors.toList());
		
		System.out.println(l.toString());
		
	}

	public void changeEmployee(Employee e) {
		e.setId(34);
	}

}

@FunctionalInterface
interface Task1 {

	public void anyTask();

	public static void anyTask2(String x) {

	}
    
	default String anyDefaultMethod(){
		return "default string";
	}
}


class TesterClass implements Task1
{

	@Override
	public void anyTask() {
		
	}
	
	public String anyDefaultMethod(){
		return "kldjnlqkwndlqw";
	}
	
}