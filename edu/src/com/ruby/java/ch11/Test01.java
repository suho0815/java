package com.ruby.java.ch11;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { 
			int []arr = new int[3];
			arr[0] = 30;
			String s ="java";
			s = null;
			System.out.println(s.length());
		}catch(ArrayIndexOutOfBoundsException e1){ //try문에서 해당 예외가 발생하면 바디의 내용을 실행
			System.out.println("에러발생" + e1.toString());
			e1.printStackTrace();
		}catch(NullPointerException e2) {
			System.out.println("null 에러" + e2.toString());
		}
	}

}
