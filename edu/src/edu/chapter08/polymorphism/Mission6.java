package edu.chapter08.polymorphism;

import java.util.Scanner;

public class Mission6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 임의의 수를 입력 받아 이진수로 변환하여 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		String output = "";
//		output = Integer.toBinaryString(input);
//		System.out.println(String.format("-> %s", output));
		
		while((input / 2) >= 1) {
			
			if ((input % 2) == 1) {
				output += "1";
			}else {
				output += "0"; 
			}
			input /=2;
		}
		
		if(input == 1) {
			output += "1";
		}else if(input == 0){
			output += "0";
		}
		
		char[] output1 = output.toCharArray();
		System.out.print("-> ");
		for(int i = output1.length - 1; i >= 0; i--) {
			System.out.print(output1[i]);
		}
		
		
		
		sc.close();
	}

}
