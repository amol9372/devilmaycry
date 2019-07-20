package com.practice.Java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.practice.Model.Department;
import com.practice.Model.Employee;

public class AInnerClass {
	public static void main(String[] args) {

//		Employee e = new Employee("amol", 12, new Department(23, "educsation"));
//		new AInnerClass().changeEmployee(e);
//		System.out.println(e.getId());
		// Task1 t = new TesterClass();
		// System.out.println(t.anyDefaultMethod());
		//
		// Task1 task1 = () -> System.out.println("anytask method called with
		// lambda expression");
		// task1.anyTask();
		//
		// Comparator<Employee> empComparator = (o1,o2) -> { return o1.getId() -
		// o2.getId(); };
		
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Amol", 1, new Department(2, "CS")));
		empList.add(new Employee("Rahul", 2, new Department(6, "ECE")));
		
		Iterator<Employee> itr = empList.iterator();
		
		while(itr.hasNext()){
			Employee e = itr.next();
			e.setId(34);
		}
		
		System.out.println(empList);
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