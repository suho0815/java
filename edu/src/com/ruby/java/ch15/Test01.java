package com.ruby.java.ch15;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Test01 {

	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(50);
		myList.add(10);
		myList.add(80);
		myList.add(70);
		myList.add(90);
		myList.add(60);
		myList.add(20);
		
		Stream<Integer>myStream = myList.stream();
		myStream.forEach((n)-> System.out.println(n + " "));
		System.out.println();

	}

}
