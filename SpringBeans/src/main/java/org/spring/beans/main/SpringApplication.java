package org.spring.beans.main;

import java.util.Stack;

public class SpringApplication {
	public static void main(String[] args) {
	   String x = reverseStringUsingRecursion("Amol");
	   System.out.println(x);
	}

	static String reverseStringUsingRecursion(String s) {
		if (s.isEmpty()) {
			return s;
		} else {
			return s.charAt(0) + reverseStringUsingRecursion(s.substring(0 + 1));
		}
	}
	
	static void sortStackUsingTmpStack() {
		Stack<Integer> inputStack = new Stack<>();
		Stack<Integer> tmpStack = new Stack<>();

		while (!inputStack.isEmpty()) {
			int top = inputStack.pop();

			while (!tmpStack.isEmpty() && tmpStack.peek() > top) {
				inputStack.push(tmpStack.pop());
			}

			tmpStack.push(top);
		}

	}

}
