package com.practice.corejava;

public class InheritanceDemo {
	public static void main(String[] args) {
       B2 a = new B2();
       a.abc(Integer.valueOf(34));
	}
}

class A2 {
	void abc(int x) {
		System.out.println("A");
	}
}

class B2 extends A2 {
	void abc(Integer x) {
		System.out.println("B");
	}
}