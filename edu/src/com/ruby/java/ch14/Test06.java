package com.ruby.java.ch14;

interface MyFunc<T> {
	T modify(T t);
}

public class Test06 {
	public static void main(String[] args) {
		MyFunc<String> mf1 = (str) -> str.toUpperCase() +" : "  +str.length();
		MyFunc<Integer> mf2 = (n) -> n*2;
		
		
	}
}
