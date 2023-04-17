package com.ruby.java.ch09;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		MyObject obj4 = new MyObject(123);
		MyObject obj5 = new MyObject(123);
		
		if (obj4.equals(obj5)) {
			System.out.println("동일 객체이다.");
		}else {
			System.out.println("다른 객체이다.");
		}
		
		if(obj4 == obj5) {
			System.out.println("동일 객체이다.");
		}else {
			System.out.println("다른 객체이다.");
		}
		
		System.out.println(obj1.equals(obj3)); // 해시코드값을 기준으로 같은 객체인지 판단
		System.out.println("MyObject = " + obj4); // toString과 같다
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		System.out.println(obj1.toString());
		
		Class c =obj1.getClass();
		System.out.println(c.getName());
	}

}
