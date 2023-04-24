package com.ruby.java.ch14;

interface MyInterface{
	public void print();
}

class Myclass1 implements MyInterface {
	@Override // 어노테이션(annotation) -> 컴파일러에게 정보를 주는 것
	public void print() {
		System.out.println("Myclass1");
	}
}

public class Test01 {
	public static void test(MyInterface mi) {
		mi.print();
	}
	public static MyInterface test2() {
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("리턴객체");
			}
		};
		return mi;
	}
	
	
	public static void main(String[] args) {

//		MyInterface mi = new MyInterface() {
//		@Override
//		public void print() {
//			System.out.println("익명클래스");
//		}
//	};
//	mi.print();
		
		(new MyInterface() {
			public void print() {
				System.out.println("익명클래스");
			}
		}).print();
		
		MyInterface m = ()->System.out.println("hello");
		m.print();
		
	}
}
