package com.practice.corejava;

public class ExceptionsDemo {
	
	private static void throwException() throws Exception {
		throw new Exception("exception thrown");
	}
	
    public static void main(String[] args) {
		try {
			throwException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("qwdbkawbdk");
	}
}
