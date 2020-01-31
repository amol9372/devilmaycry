package com.practice.corejava;

public class ExceptionHandling {
	public static void main(String[] args) throws Exception /* throws Exception */{
		try {
			throw new Exception("main method exception");
		} catch (Exception e) {
		}
        fun();
	}

	public static boolean fun() throws Exception {

		try {
			throw new Exception("exception at try block");
		} catch (Exception e) {
            //throw new Exception("exception at catch");
		} finally {
            throw new Exception("exception at finally");
		}
	}
}
