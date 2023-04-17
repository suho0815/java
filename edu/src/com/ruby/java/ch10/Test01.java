package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Arrays;

class Employee {
	String name;
	int age;
	int height;
	int weight;
	char bloodType;
	String email;
	
	public Employee (String name, int age, int height, int weight, char bloodType, String email) {
		this.name = name; this.age = age; this.height = height; this.weight = weight; this.bloodType =bloodType; this.email= email;
	}
	public String toString() {
		return name + ", " + age + ", "+ height + ", " + weight + ", " + bloodType + ", " + email;
	}
	
}

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울"); list.add("부산"); list.add("창원");
		list.add("서울"); list.add("울산"); list.add("밀양");
		for(int i= 0; i< list.size(); i++) {
			System.out.print(" " + list.get(i));
		}
		System.out.println();
		list.add(0, "인천");
		list.remove(1);
		System.out.println(list.toString());
		System.out.println();
		for(int i= 0; i< list.size(); i++) {
			System.out.print(" " + list.get(i));
		}
		
		Object arr[] = new Object[10];
		ArrayList lst = new ArrayList();
		String s = "java"; Integer i = 123;
		arr[0] = s; arr[1] = i;
//		int len = ((String)arr[0]).length();
		lst.add(s); lst.add(1);
		
		Object obj[] = list.toArray();
		System.out.println("8: " +Arrays.toString(obj));
		
		
//		int [] a = new int[10];
//		Employee [] eset = new Employee[10];
//		eset[0] = new Employee("hong", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[1] = new Employee("kim", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[2] = new Employee("lee", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[3] = new Employee("park", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[4] =eset[3];
//		eset[3] =eset[2];
//		eset[2] = new Employee("chio", 11, 130, 50, 'A', "bhhong@go.kr");
//		for(int i = 0; i < 4; i++) {
//			System.out.println(eset[i].toString());
//		}
		
	}
}
