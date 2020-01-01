package com.places.geocode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
		Employee e1 = new Employee("Amol", 1, 1234000);
		Employee e2 = new Employee("Rohit", 2, 45000);
		Employee e3 = new Employee("Vikas", 3, 174800);
		Employee e4 = new Employee("Rahul", 4, 567000);
		Employee e5 = new Employee("Pankaj", 5, 589000);
		Employee e6 = new Employee("Shrikant", 6, 938900);
		Employee e7 = new Employee("Bunty", 7, 678000);
		
		List<Employee> empList = Arrays.asList(e1, e2, e3, e4, e5, e6, e7);
		
		int maxSalary = empList.stream().sorted((emp1, emp2) -> emp2.getSalary() - emp1.getSalary()).findFirst().get().getSalary();
		System.out.println(maxSalary);
	}

	private static List<String> getRandomList() {
		return Arrays.asList("Amol", "Aman", "Vikas", "Vinod", "Rahul", "Shivam");
	}

}
