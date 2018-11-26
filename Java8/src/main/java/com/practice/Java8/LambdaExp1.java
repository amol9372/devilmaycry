package com.practice.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExp1 implements A{
    
	private static List<Integer> randomList = new ArrayList<>();
	
	static {
		Random randomInt = new Random();
		for(int i=0;i<10;i++) {
			randomList.add(randomInt.nextInt(10));
		}
	}
	
	
	public static void main(String[] args) {
		//A a = (n) -> System.out.println("This is sample lambda expression "+n);
		//a.print("Amol");
		//new LambdaExp1().displayName(a);
		//new LambdaExp1().method1();
		
    	// Used to declare a functionality without having need to create a new functional interface
		Consumer<String> display = (s) -> System.out.println("my name is : "+s);
		display.accept("Amol");
		
		// Used to test a condition and use OR and AND
		Predicate<List<Integer>> checkSizeOf10 = (l) -> l.size() > 10 ;
		Predicate<List<Integer>> containsInteger6 = (l) -> l.contains(6);
		boolean b = checkSizeOf10.or(containsInteger6).test(randomList);
		
		Optional<LambdaExp1> lambdaExp1 = Optional.ofNullable(null);
		lambdaExp1.orElse(new LambdaExp1());
		lambdaExp1.isPresent();
		
		System.out.println(b);
		
	}
    
    
    
    public void displayName(A a) {
    	a.print("Rakesh");
    	a.method1();
    }
	
	public void print(String name) { }
	
	public void method1() {
		System.out.println("overriden method");
	}
	
	public static void staticMethod1() {}
	
}


interface A{
	
	void print(String name);
	
	default void method1() { 
		System.out.println("default method");
	}
	
	static void staticMethod1() {
		
	}
	
}

// Predicate, Consumer, Function 