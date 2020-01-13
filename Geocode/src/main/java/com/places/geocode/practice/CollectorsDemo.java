package com.places.geocode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

	public static void main(String[] args) {

		// Collector1 - create Map<Character, String> from a list of strings with
		// strings starting from First character

		// Supplier
		Supplier<Map<Character, List<String>>> mapSupplier = HashMap::new;

		// Accumulator
		BiConsumer<Map<Character, List<String>>, String> accumulator = (map, s) -> {
			if (map.containsKey(s.charAt(0))) {
				map.get(s.charAt(0)).add(s);
			} else {
				List<String> tempList = new ArrayList<>();
				tempList.add(s);
				map.put(s.charAt(0), tempList);
			}
		};

		// Finisher (For parallel stream)
		BiConsumer<Map<Character, List<String>>, Map<Character, List<String>>> combiner = (result1, result2) -> result1
				.putAll(result2);

		// Collector Call
		getRandomList().stream().collect(mapSupplier, accumulator, combiner).entrySet()
				.forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

		// Without Custom Collector
		Map<Character, Set<String>> charFrequencyMap = getRandomList().stream().collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toSet()));/*.entrySet()
				.forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()))*/;
		Employee e1 = new Employee("Amol", 1, 1234000, "RMCC");
		Employee e2 = new Employee("Rohit", 2, 45000, "RMCC");
		Employee e3 = new Employee("Vikas", 3, 174800, "OSS");
		Employee e4 = new Employee("Rahul", 4, 567000, "GSS");
		Employee e5 = new Employee("Pankaj", 5, 589000, "OSS");
		Employee e6 = new Employee("Shrikant", 6, 938900, "GSS");
		Employee e7 = new Employee("Bunty", 7, 678000, "RMCC");
		
		List<Employee> empList = Arrays.asList(e1, e2, e3, e4, e5, e6, e7);
		
		List<String> nameList = empList.stream().map(e -> e.getName()).collect(Collectors.toList());
		List<String> nameList2 = empList.stream().collect(Collectors.mapping(Employee::getName, Collectors.toList()));
		double avgSalary = empList.stream().collect(Collectors.maxBy((emp1, emp2) -> emp1.getSalary() - emp2.getSalary()))
				.get().getSalary();
		List<Employee> sortedEmpl = empList.stream().filter(e -> e.getName().startsWith("R")).collect(Collectors.toList());
		double avgMaxSalOfDept = empList.stream().collect(Collectors.groupingBy(Employee::getDept, 
															Collectors.averagingInt(Employee:: getSalary)))
		.entrySet().stream().max((dept1, dept2) -> (int)(dept2.getValue() - dept1.getValue())).get().getValue().doubleValue();
		System.out.println(sortedEmpl + "Max avg sal" + avgMaxSalOfDept);
		int maxSalary = empList.stream().sorted((emp1, emp2) -> emp2.getSalary() - emp1.getSalary()).findFirst().get().getSalary();
		System.out.println(maxSalary);
		
		Stream.of(1, 2, 3, 5, 6).filter(i -> {
			System.out.println("filtering :: "+i);
			if (i % 2 == 0) 
				return true;
			else
				return false;
		}).findFirst();
		
	}

	private static List<String> getRandomList() {
		return Arrays.asList("Amol", "Aman", "Vikas", "Vinod", "Rahul", "Shivam");
	}

}
