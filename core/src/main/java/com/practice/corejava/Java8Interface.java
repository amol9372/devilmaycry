package com.practice.corejava;

public class Java8Interface {
	public static void main(String[] args) {
        B b = new B();
        b.fun();
        A.getFun();
	}
}


interface A {
	
	default void fun() {
		System.out.println("Lets do some default fun");
	}
	
	static String getFun() {
		return "lets have some static fun";
	}
	
}

class B implements A {
	
	public void fun() {
		System.out.println("Lets do some extended fun");
	}
}