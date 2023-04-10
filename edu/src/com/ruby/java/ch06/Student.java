//package com.ruby.java.ch06;
//
////하나의 java file에 Student 객체를 정의하고 구현하는 실습
///*
// * 생성자 함수 구현 - this(); 호출 사용
// * static 데이터 멤버 사용
// * static 멤버 함수 구현
// * toString() 함수 구현과 사용
// * 객체 배열 사용
// */
//public class Student {
//	//필드 선언
//	private static int countStudents;// 객체수
//	private int sid;// 학번
//	private String sname; // 학생 이름
//	private String city; // 주소 도시
//
//	//생성자 함수 구현
//	public Student() {
//		 this(0);
//	 }
//
//	 public Student(int sid) {
//		 this(sid, null);
//	 }
//	 
//	 public Student(int sid, String sname) {
//		 this(sid, sname, null);
//	 }
//	 
//	 public Student(int sid, String sname, String city) {
//		 this.sid = sid;
//		 this.sname = sname;
//		 this.city = city;
//		 countStudents++;
//	 }
//	
//	//함수 구현
//	public void showStudent() {
//		System.out.print("객체: " + toString());
//		System.out.println();
//	}
//	
//	public String toString() {
//		return sid + " : " + sname + " : " + city;
//	}
//
//	public static void showNumberObjects() {// 생성된 객체수를 출력한다.
//		System.out.println("생성된 객체수 : " + countStudents);
//	}
//
//	// 생성자 구현한다.
//	public static void main(String[] args) {
//	 
//	 Student arry[] = new Student[5];
//	 showNumberObjects();
//	 arry[0] = new Student();
//	 arry[1] = new Student(202301);
//	 arry[2] = new Student(202302, "Hong");
//	 arry[3] = new Student(202303, "Lee", "Busan");
//	 arry[4] = new Student(202304, "Na", "jeju");
//	 showNumberObjects();
//	 
//	 for (int i = 0; i < arry.length; i++) {
//		 arry[i].showStudent();//생성된 객체 모두를 출력한다.
//	 }
//	 
// }
//
//}
