package com.practice.Java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaExp1 implements A{
    
	private static List<Integer> randomList = new ArrayList<>();
	
	@MyAutowiring
	private LambdaExp2 lambdaExp2;
	
	// meet , emt
	private static boolean isAnagram(String s1, String s2){
		if(s1.length() !=s2.length()){
			return false;
		}
		char[] s2CharArray = s2.toCharArray();
		Map<Character, Integer> charMap = new HashMap<>();
		
		for(int i=0; i<s1.length();i++){
			if(!charMap.containsKey(s1.charAt(i))){
				charMap.put(s1.charAt(i), 1);
			} else {
				charMap.put(s1.charAt(i), charMap.get(s1.charAt(i)) + 1);
			}
		}
		
		for(char c : s2CharArray){
			if(charMap.containsKey(c) && charMap.get(c) > 0){
				charMap.put(c, charMap.get(c)-1);
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	
	public LambdaExp2 getLambdaExp2(){
		return lambdaExp2;
	}
	
	static {
		Random randomInt = new Random();
		for(int i=0;i<10;i++) {
			randomList.add(randomInt.nextInt(10));
		}
	}
	
	
	interface calculator<T>{
		T calculate(T t1, T t2);
	}
	
		
	interface B{	
		int operate(int a,int b);
		
	}
	
	private int operation(int x, int y, B b){
		return b.operate(x, y);
	}
	
	public static void main(String[] args) {
		AMR amr =  new AMR("wdhfwe");
		A a1 = amr::printMR; 
		
//		A a1 = AMR::printMR2; 
//		a.print("Amol Singh");
//		System.out.println(isAnagram("teem", "maet"));
//		
		BiFunction<Integer, Integer, Integer> add = (a,b) -> a + b;
		BiFunction<Integer, Integer, Integer> add1 = (a,b) -> a + b;
        add.apply(3, 5);
		//BiFunction<Integer, Integer, Integer> addBi = add;
		
//		B multiply = (a,b) -> a*b;
//		
//		System.out.println(new LambdaExp1().operation(3, 4, multiply));
//		
//		A a = (n) -> System.out.println("This is sample lambda expression "+n);
//		a.print("Amol");
		//new LambdaExp1().displayName(a);
		//new LambdaExp1().method1();
		
    	// Used to declare a functionality without having need to create a new functional interface
//		Consumer<String> display = (s) -> System.out.println("my name is : "+s);
//		display.accept("Amol");
//		
//		// Used to test a condition and use OR and AND
//		Predicate<List<Integer>> checkSizeOf10 = (l) -> l.size() > 10 ;
//		Predicate<List<Integer>> containsInteger6 = (l) -> l.contains(6);
//		boolean b = checkSizeOf10.or(containsInteger6).test(randomList);
//		
//		Supplier<String> nameSupplier = () -> { return "Amol Singh"; };
//		System.out.println(nameSupplier.get());
//		
//		Optional<LambdaExp1> lambdaExp1 = Optional.ofNullable(null);
//		lambdaExp1.orElse(new LambdaExp1());
//		lambdaExp1.isPresent();	
//		
//		System.out.println(b);
//		randomList.stream().forEach( l -> {System.out.println(l);});
//		
//		List<String> newList = randomList.stream().map(s -> s.toString()).collect(Collectors.toList());
//		Optional<Integer> maxElement = randomList.stream().max((Integer i1, Integer i2) -> { return i1.compareTo(i2); });
//		
//		maxElement.ifPresent((max) -> {System.out.println("max elemant is : "+max);});
//		
//		Function<String, Integer> convertStringToInteger = (s) -> { return Integer.parseInt(s); };
//		System.out.println(convertStringToInteger.apply("236"));
		
		//A add =  (x,y) -> { return x+y; };
		
	}
    
	@MyAnnotation
    public void testMyAnnotation(String s){
		System.out.println("the injected string is : "+s);
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

@FunctionalInterface
interface A{
	
	void print(String name);
	
	//int add(int x, int y);
	
	default void method1() { 
		System.out.println("default method");
	}
	
	static void staticMethod1() {
		
	}
	
}

class AMR {
	
	public AMR(String cv){
		System.out.println("AMR constructor is called");
	}
	
	public void printMR(String name1){
		System.out.println(name1 + " is printed");
	}
	
	public static void printMR2(String name){
		System.out.println(name + " is printed");
	}
}

// Predicate, Consumer, Function 