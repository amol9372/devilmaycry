package com.practice.Java8;

interface Operation<T,V>{
	V mathOperation(T t1, T t2);
}

public class GenericCalCulator
{
     public static void main(String[] args) {
		Operation<Integer,Integer> sum = (a, b) -> { return (a+b); };
		Operation<Integer,Integer> subtraction = (a, b) -> { return (a-b); };

		System.out.println(sum.mathOperation(3, 70));
		
	 }
}
