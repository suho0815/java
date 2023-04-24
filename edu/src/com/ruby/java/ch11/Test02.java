package com.ruby.java.ch11;

import java.io.FileInputStream;

public class Test02 {

	public static void main(String[] args) {
		//FileInputStream fi;
		try(FileInputStream fi = new FileInputStream("a.txt");) 
		{
			//fi = new FileInputStream("a.txt");
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");
			String s = null;
			s.length();
		}catch(Exception e){
			
			System.out.println("error");
		}finally { // 사용목적 : 자원해제
			//fi.close();
			System.out.println("OK");
		}
		
		System.out.println("4");
		
		
	}

}
