package com.ruby.java.ch09;

public class Test02 {
	public static void main(String[] args) {
		String s1 =new String("java");
		String s2 = "java";
		
		String s3 = new String("java");
		String s4 = "java";
		
		
		//System.out.println(s1.toString() + " : " + s2.toString());
		System.out.println(s1.hashCode() + " :: " + s2.hashCode());
		System.out.println(System.identityHashCode(s1) + " : " + System.identityHashCode(s2));
		
		if(s1 == s3) { // 변수값이 같은지 비교
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		
		if(s2 == s4) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		
		if(s1.equals(s3)) { // 해시코드값이 같은지 비교
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		
		if(s2.equals(s4)) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		
	}
}
