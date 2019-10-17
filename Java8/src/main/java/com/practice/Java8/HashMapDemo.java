package com.practice.Java8;

import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

import com.practice.Model.Department;
import com.practice.Model.Employee;

public class HashMapDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
//	  ExecutorService executorService = Executors.newFixedThreadPool(1);	
//	  Future<String> future = executorService.submit(() -> "Amol Singh");
//	  System.out.println(future.get());
//	  
//	  CompletableFuture<String> stringfuture = CompletableFuture.supplyAsync(() -> "Amol Singh is Great").thenApplyAsync( s -> s + " boy");
//	  System.out.println(stringfuture.get());
	  
	  Function<Integer, Integer> sum = i -> i + 2;
	  Function<Integer, Integer> square = i -> i * i;
	  
	  System.out.println(sum.apply(4));
	  System.out.println(sum.compose(square).apply(3));
	  
	  CompletableFuture.runAsync(() -> System.out.println("my name is amol singh")).thenRunAsync(() -> System.out.println(" And i am a good boy"));
	  //System.out.println(cf.get());
	  TreeMap<Employee, String> treeMap = new TreeMap<>();
	  //treeMap.put(new Employee("AMol", 10, new Department(10, "")), "great department");
	  x(3);
	}
	
	public Future<String> calculateAsync() throws InterruptedException {
	    CompletableFuture<String> completableFuture 
	      = new CompletableFuture<>();
	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(500);
	        completableFuture.complete("Hello");
	        return null;
	    });
	 
	    
	    return completableFuture;
	}
	
	public static void x(int n) {  
        for (int i = 0; i < n; i++) {  
        	System.out.println("Enter for loop. i = " + i + ", n = " + n);
            System.out.println("Before recursive call");
            x(n - 1);
            System.out.println("After recursive call");
        }  
        System.out.println("Exit x(" + n + ")");
    }  
}
