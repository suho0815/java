package edu.chapter08.polymorphism;

import java.util.Scanner;

public class Mission6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 임의의 수를 입력 받아 이진수로 변환하여 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		String output;
		output = Integer.toBinaryString(input);
		System.out.println(String.format("-> %s", output));
		
		sc.close();
	}

}
