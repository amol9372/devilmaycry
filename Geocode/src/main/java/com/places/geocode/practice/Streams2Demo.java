package com.places.geocode.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams2Demo {
	public static void main(String[] args) {
        
//		Map<String, Integer> characterCountMap = Stream.of("amol", "rahul", "vinay", "vikas", "amol")
//				.collect(Collectors.toMap(p -> p, String::length));
		
		Map<String, Integer> characterCountMapFromList = getRandomList().stream()
				.collect(Collectors.toMap(p -> p, String::length));		

		System.out.println(characterCountMapFromList);
		
	}
	
	public static List<String> getRandomList(){
       List<String> randomList = Arrays.asList("amol", "rahul", "vinay", "vikas");
       return randomList;
	}
	
}
