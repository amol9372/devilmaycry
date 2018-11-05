package com.practice.Java8;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Operation<T,V>{
	
	V mathOperation(T t1, T t2);
	
}

@FunctionalInterface
interface FuncInt<S>{
	String lambdaExp(S s);
}

class Sum {
	Integer doSum(String s1, String s2) {
		return Integer.parseInt(s1) + Integer.parseInt(s1);
	}
}

public class GenericCalCulator
{
     public static void main(String[] args) {
		Operation<Integer,Integer> sum = (a, b) -> { return (a+b); };
		Operation<Integer,Integer> subtraction = (a, b) -> { return (a-b); };

		System.out.println(sum.mathOperation(3, 70));
		
		List<String> streamList = new ArrayList<>();
		
		long x = streamList.stream().filter(String::isEmpty).count();
		
		
		
	 }
}
