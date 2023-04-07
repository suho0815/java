package com.ruby.java.ch06;

public class Student4 {
	private int sid;
	private String name;
	private String dept;
	
	public Student4() {
	}
	public Student4(int sid, String name, String dept) {
		this.sid = sid; this.name = name; this.dept = dept;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public static void main(String[] args) {
		System.out.println("6장 시작");
		int n = 10;
		Student4 s = null;
		s = new Student4(2023, "홍길동", "컴퓨터");
		System.out.println(s.sid);
		s.sid = 99;
		System.out.println(s.sid);
		System.out.println("student 객체 = " + s);
	}
}
