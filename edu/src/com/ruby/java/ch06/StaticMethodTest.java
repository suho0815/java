package com.ruby.java.ch06;

public class StaticMethodTest {
	public static void main(String[] args) {
		StaticMethodTest s = new StaticMethodTest();
		StaticMethodTest.print1();
		s.print1();
		print1();
		
	}

	public static void print1() {
		System.out.println("hello");
	}

	public void print2() {
		int num;
		System.out.println("java");
	}
}
