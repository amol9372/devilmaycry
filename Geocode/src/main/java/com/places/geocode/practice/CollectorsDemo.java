package com.places.geocode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CollectorsDemo {
	
	public static void main(String[] args) {
        
		// Collector1 - create Map<Character, String> from a list of strings with strings starting from char
		
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
		
		// Finisher
		BiConsumer<Map<Character, List<String>>, Map<Character, List<String>>> combiner = (result1, result2) -> result1.putAll(result2);
		
		// Collector Call
		getRandomList().stream().collect(mapSupplier, accumulator, combiner).entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue() ));
		
		// Without Custom Collector
		getRandomList().stream().collect(Collectors.groupingBy(s -> s.charAt(0))).entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue() ));
		
		
		
	}
	
	private static List<String> getRandomList(){
		return Arrays.asList("Amol", "Aman", "Vikas", "Vinod", "Rahul", "Shivam");
	}
	
	
}
