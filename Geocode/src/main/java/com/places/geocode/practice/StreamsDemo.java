package com.places.geocode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamsDemo {
	public static void main(String[] args) {
		Stream<String> numbers = Stream.of("1", "2", "56");
		List<Integer> actualNumbers = numbers.map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(actualNumbers);

		int x = Stream.of(1, 2, 3, 4, 5).reduce(0, (Integer a, Integer b) -> a + b);
		System.out.println(x);

		Map<Integer, Long> frequencyMap = Stream.of(1, 3, 4, 6, 6, 6, 7, 3, 2, 9, 4)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(frequencyMap);

		String s = "rahulkumar";
		Stream<Character> charStream = s.chars().mapToObj(c -> (char) c);

		Map<Character, Long> characterFrequencyMap = charStream
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(characterFrequencyMap);

		Stream.of(1, 3, 4, 87, 5, 78, 56).sorted((i, j) -> j - i).forEach(System.out::println);
		Map<String, Integer> nameMap = new HashMap<>();
		nameMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		List<String> practiceList = getList();
		
		//practiceList.stream().collect(Collectors.toMap(  ));
		
	}
	
	static String getKey(String s) {
		return s;
	}
	
	static List<String> getList() {
		String[] stringArray = new String[] {"TEST_2019", "FN_2012", "TEST_2011", "FN_2010", "TEST_2015", "ABC_2014", "TEST_2017", "ABC_2020"};
		List<String> randomList = Arrays.asList(stringArray);
		
		return randomList;
	}
	

}

abstract class A1 {
	A1 (){
	  System.out.println("Abstract class contructor");	
	}
	
	abstract void func1();
}

class B1 extends A1 {

	@Override
	void func1() { }
	 
}