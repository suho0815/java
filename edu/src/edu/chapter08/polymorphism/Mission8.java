package edu.chapter08.polymorphism;

import java.util.Scanner;

public class Mission8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//팩토리얼 메소드 작성
		//ex) 입력 : 4 => 4! = 4 * 3 * 2 * 1 = 24
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		if(input <= 0 ) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		for(int i = input; i <= 0 ; i--) {
			
		}
		
	}

}
