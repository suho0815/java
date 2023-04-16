package edu.chapter08.polymorphism;

import java.util.Scanner;

public class Mission8 {

	public static int factorial(int inp) {
		
		if(inp <= 1) {
			System.out.print("1 ");
			return inp;
		} else {
			System.out.print( inp + " * ");
			return inp * factorial(inp-1);
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//팩토리얼 메소드 작성
		//ex) 입력 : 4 => 4! = 4 * 3 * 2 * 1 = 24
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int input = sc.nextInt();
		int a = 0;
		
		if(input <= 0 ) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		System.out.print(input + "! = ");
		a = factorial(input);
		System.out.println("= " + a);
		
//		for(int i = input; i <= 0 ; i--) {
//			
//		}
		
		
		
	}

}
