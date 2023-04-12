package edu.chapter07.abstraction;

import java.util.Scanner;

public class Mission5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//152365
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("상품 가격을 입력하세요 : ");
		int input = sc.nextInt();
		int won50000 = 0, won10000 = 0, won5000 = 0, won1000 = 0;
		
		while((input / 1000) > 0) {
			if((input / 50000) > 0) {
				won50000 = (input / 50000);
				input -= (won50000 * 50000);
			} else if ((input / 10000) > 0){
				won10000 = (input / 10000);
				input -= (won10000 * 10000);
			} else if ((input / 5000) > 0) {
				won5000 = (input/5000);
				input -= (won5000 * 5000);
			} else if ((input / 1000) > 0) { 
				won1000 = (input / 1000);
				input -= (won1000 * 1000);
			}
		}
		
		System.out.println("* 5만원 * " + won50000 + "장");
		System.out.println("* 1만원 * " + won10000 + "장");
		System.out.println("* 5천원 * " + won5000 + "장");
		System.out.println("* 1천원 * " + won1000 + "장");
		
		
	}

}
