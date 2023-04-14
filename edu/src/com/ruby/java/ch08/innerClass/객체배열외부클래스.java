package com.ruby.java.ch08.innerClass;

public class 객체배열외부클래스 {
	
	class Student {
		int sid;
		String sname;
		
		Student(int sid, String sname){
			this.sid = sid;
			this.sname = sname;
		}
		/*
		public String toString() { 
			return "sid = " + sid + ", sname = " +sname; 
		}
		*/
		void show() {
			System.out.println(this.toString());
		}
		
		
	}

	public static void main(String[] args) {
		
		int []data = new int[10];
		Student []sdata = new Student[10]; // 배열 10개의 공간에 객체 생성, 할당
		data[0] = 10;
		객체배열외부클래스 my = new 객체배열외부클래스();
		sdata[0] = my.new Student(2023, "hong");
		sdata[1] = my.new Student(2022, "kim");
		sdata[2] = my.new Student(2021, "lee");
		sdata[3] = my.new Student(2020, "park");
		sdata[4] = my.new Student(2019, "choi");
		if(sdata[0] == sdata[1]) {}
		if(sdata[0].equals(sdata[1]) == true) {}
		
		for(int i = 0; i < 5; i++) {
			sdata[i].show();
			System.out.println("toString : " + sdata[i].toString());
		}
		
	}
}
