package com.practice.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamsDemo {
	public static void main(String[] args) {
		Stream<String> numbers = Stream.of("1", "2", "56");
		List<Integer> actualNumbers = numbers.map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(actualNumbers);

		int sum = Stream.of(1, 2, 3, 4, 5).reduce(0, (Integer a, Integer b) -> a + b);
		System.out.println(sum);

		Map<Integer, Long> frequencyMap = Stream.of(1, 3, 4, 6, 6, 6, 7, 3, 2, 9, 4)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(frequencyMap);

		String s1 = "rahulkumar";
		Stream<Character> charStream = s1.chars().mapToObj(c -> (char) c);

		Map<Character, Long> characterFrequencyMap = charStream
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(characterFrequencyMap);

		Stream.of(1, 3, 4, 87, 5, 78, 56).sorted((i, j) -> j - i).forEach(System.out::println);
		Map<String, Integer> nameMap = new HashMap<>();
		nameMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		Map<String, Integer> countMap = getList().stream().collect(Collectors.toMap(str -> str, str -> str.length()));
		System.out.println(countMap);

		Map<String, List<Integer>> fileNameTimeStampMap = getList().stream().map(s -> s.split("_")).collect(
				Collectors.groupingBy(s -> s[0], Collectors.mapping(s -> Integer.parseInt(s[1]), Collectors.toList())));

		System.out.println(fileNameTimeStampMap);

		LinkedHashMap<String, Integer> fileWiseMaxTimeStamp = fileNameTimeStampMap.keySet().stream().collect(Collectors
				.toMap(e -> e.toString(), e -> fileNameTimeStampMap.get(e).stream().max((i, j) -> i - j).get(), (e1, e2) -> e1 , LinkedHashMap::new)); 
		System.out.println(fileWiseMaxTimeStamp);
		
		Map<String, String> sampleMap = new HashMap<>();

	}

	static List<String> getList() {
		List<String> randomList = Arrays.asList("TEST_2019", "FN_2012", "TEST_2011", "FN_2010", "TEST_2015", "ABC_2014",
				"TEST_2017", "ABC_2020");
		return randomList;
	}

}

abstract class A1 {
	A1() {
		System.out.println("Abstract class contructor");
	}

	abstract void func1();
}

class B1 extends A1 {

	@Override
	void func1() {
	}

}