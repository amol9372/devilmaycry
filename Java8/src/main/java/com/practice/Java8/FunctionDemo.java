package com.practice.Java8;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.http.client.ClientProtocolException;

public class FunctionDemo {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		Function<String, Integer> stringToInteger = (s) -> Integer.valueOf(s);
		System.out.println("Conversion of 34 to integer is : " + stringToInteger.apply("34"));

		Supplier<String> displayName = () -> "Amol";
		
		System.out.println(displayName.get());
		
		BiFunction<Integer,Integer,Integer> addNumbers = (i,j) -> { return i + j; };
		System.out.println("Sum of 1 and 2 is : "+addNumbers.apply(1,2));
        
		Supplier<String> nameSupplier = new FunctionDemo()::getName;
		//CompletableFuture<String> completableFuture = new CompletableFuture<>();
		CompletableFuture<Integer> integerFuture = CompletableFuture.supplyAsync(nameSupplier).thenApply(stringToInteger);
		try {
			int i = integerFuture.get();
			System.out.println(i);
			System.out.println(integerFuture.complete(i));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
    	
	}
	
	public String getName(){
		return "23456";
	}
}
