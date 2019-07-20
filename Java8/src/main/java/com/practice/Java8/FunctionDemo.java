package com.practice.Java8;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionDemo {
	public static void main(String[] args) {
		Function<String, Integer> stringToInteger = (s) -> Integer.valueOf(s);
		System.out.println("Conversion of 34 to integer is : " + stringToInteger.apply("34"));

		Supplier<String> displayName = () -> {
			return "Amol";
		};
		
		System.out.println(displayName.get());
		BiFunction<Integer,Integer,Integer> addNumbers = (i,j) -> { return i + j; };
		
		System.out.println("Sum of 1 and 2 is : "+addNumbers.apply(1,2));
	}
}
