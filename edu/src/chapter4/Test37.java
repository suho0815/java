package chapter4;

import java.util.Scanner;

public class Test37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] score = {90, 85, 78, 100, 98};
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[5];
		for (int i = 0; i < score.length; i++) {
			System.out.println((i+1) + "번째 값 : ");
			score[i] = sc.nextInt();
		}
		
		int sum = 0; // 총점
		double avg = 0.0; // 평균
		int max = 0; // 최댓값
		int min = 999; // 최솟값
		
		for(int i = 0; i <score.length; i++) {
			sum += score[i];
			if(max < score[i]) {
				max = score[i];
			}
			if(min > score[i]) {
				min = score[i];
			}
		}
		//%.2f 는 소수점 둘째자리까지 float형태로 출력하라는 의미
		avg = (double)sum / score.length;
		System.out.println("총 점 : " + sum);
		System.out.println("평 균 : " + String.format("%.2f", avg)); 
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
		
		sc.close();
		
	}

}
