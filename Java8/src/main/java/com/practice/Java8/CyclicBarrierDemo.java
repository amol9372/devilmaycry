package com.practice.Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CyclicBarrierDemo {
	public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
			Runnable firstCallable = () -> {
				
				System.out.println("Amol");
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			
			Runnable secondCallable = () -> {
				System.out.println("Amol");
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			
			Runnable thirdCallable = () -> {
				System.out.println("Amol");
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put("Amol", "good");
        myMap.put("Amol1", "very good");
        myMap.put("Amol2", "not very good");
        myMap.put("Amol3", "good bad good");
        
        List<Entry<String, String>> entryList = new ArrayList<>(myMap.entrySet());
        
//        Collections.sort(entryList, ( Map.Entry<String, String> entry1, Map.Entry<String, String> entry2) -> entry1);
		Collections.sort(entryList, (Map.Entry<String, String> o1, Map.Entry<String, String> o2) -> o1.getValue().compareTo(o2.getValue()));
        
		 Map<String, Integer> budget = new HashMap<>();
		    budget.put("clothes", 120);
		    budget.put("grocery", 150);
		    budget.put("transportation", 100);
		    budget.put("utility", 130);
		    budget.put("rent", 1150);
		    budget.put("miscellneous", 90);
		 
		    System.out.println("map before sorting: " + budget);
		 
		    // let's sort this map by values first
		    Map<String, Integer> sorted = budget
		        .entrySet()
		        .stream()
		        .sorted(Entry.comparingByValue())
		        .collect(
		            Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
		                LinkedHashMap::new));
		System.out.println(sorted);
		
	}

	
}

class Task {
	
}