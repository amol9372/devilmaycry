package com.practice.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class MethodReference {
	public static void main(String[] args) {
		
	    BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;
	    String ans = biFunction.andThen(sum -> "Sum is : "+sum).apply(34, 45);
	    
	    BiFunction<String, List<String>, List<String>> biFunctionNameFunction = 
	    		(name, nameList) -> nameList.stream()
	    		.filter(n -> n.equals(name))
	    		.collect(Collectors.toList());
	    
	    BiFunction<Integer, Integer, Integer> biFunctionMultiply = MethodReference::multiply;		
	    
//	    BiFunction<List<String>, String, Map<String, String>> biFunctionMap = 
//	    		(nameList, name) -> nameList.stream()
//	    		.map(item -> (item, name))
//	    		.collect(Collectors.toMap(keyMapper, valueMapper));
	}

	static int multiply(int x, int y) {
		return x * y;
	}
	
	// BiFunction with Generics
	/*
	 * <T> String addUsingBiFunction(T a, T b){ BiFunction<T, T, T> biFunction = (x,
	 * y) -> x + y; String ans = biFunction.andThen(sum -> "Sum is : "+sum).apply(a,
	 * b); return ans; }
	 */

}
