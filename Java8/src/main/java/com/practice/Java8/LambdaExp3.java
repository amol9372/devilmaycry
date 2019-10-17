package com.practice.Java8;

import java.util.HashMap;
import java.util.Map;

public class LambdaExp3 {
	public static void main(String[] args) {
        // Regular lambda expression
		MathOperation<Integer> operation1 = (x,y) -> x + y;
        System.out.println(operation1.operation(3, 67));
        
        MathOperation<Double> operation2 = (x, y) -> x * y;
        System.out.println(operation2.operation(3.56, 5.67));
        
        // Passing Lambda functions in another functions
        LambdaExp3 lambdaExp3 = new LambdaExp3();
        System.out.println(lambdaExp3.multiOperation(5.9, 7.4, operation2));
        
        Map<String, Integer> nameMap = new HashMap<>();
        
        
	}
	
	<T> T multiOperation(T x, T y, MathOperation<T> operation){
		return operation.operation(x, y);
	}
	
	<M> void genericMethod(M m1, M m2){
		
	}
	
}

interface MathOperation<T> {
	 T operation(T t1, T t2);
	 
	 static void getInfo(){ }
	 
	 static void getInfo2(){ }
	 
	 default void deFunc1(){ }
	 
     default void deFunc2(){ }
}