package edu.chapter08.polymorphism;

import java.util.Scanner;

public class Mission9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 경우의 수
		// 2g, 3g, 5g의 추가 각각 10개 있을 때, 10~ 100사이의 임의의 값을 입력 받고
		// 추의 합이 입력 받은 값이 되는 경우를 찾아서 출력하세요.
		// 단, 각각의 추는 1개이상은 사용되어야 합니다.
		// ex) 입력값 : 31
		// 출력 값 (1,3,4)(1,6,3)(2,4,3)(4,1,4),(4,6,1),(5,2,3)(6,3,2),(7,4,1)(9,1,2),(10,2,1) : 11
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력값 : ");
		int input = sc.nextInt();
		int sum = 0, count = 0;
		
		while(input > 100 || input < 10 ) {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			System.out.println("입력값 : ");
			input = sc.nextInt();
		}
		
		System.out.print("출력 값 : ");
		// 각각 추는 1개 이상 사용 해야되므로 추의 개수는 1부터 시작해서 검사하여 결과 출력
		for(int i = 1; i <= 10; i++) { //2g 추 계산 i는 2g 추의 개수
			for(int j = 1; j <= 10; j++) { //3g 추 계산 j는 3g 추의 개수
				for(int k = 1; k <= 10; k++) { //5g 추 계산 k는 5g 추의 개수
					sum = (i*2) + (j*3) + (k*5);
					if(sum == input) {
						System.out.print(String.format("(%d,%d,%d)", i,j,k));
						count++;
					}
				}
			}
		}
		System.out.println(" : " + count);
		
		sc.close();
	}

}
