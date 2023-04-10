package com.ruby.java.ch06;

public class Member {
	private String name;
	private int age;
	
	public Member() { // 생성자 함수
		//this.name = "guest";
		//age = 0;
		this(null);
	}
	
	public Member(String name) {
		//this.name = name; //this(수신객체,receiver object) : new에 의해 생성되는 객체
		//age = 0;
		this(name, 0); //this(); 함수 :다른 생성자 호출 (코드가 중복되어 리팩토링)
//		this.age = 1;
	}
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		
	}
	public void show() {
		System.out.println("name = " + name + ", age = " + age);
	}
	public String toString() {
		return "name = " + name + ", age = " + age;
	}
	
	public static void main(String[] args) {
		System.out.println("main() 메서드 실행");
		Member m1 = new Member();
		Member m2 = new Member("Amy");
		Member m3 = new Member("Bobby", 11);
		m1.show();
		m2.show();
		m3.show();
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		
	}
	
}
