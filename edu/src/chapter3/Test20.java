package chapter3;

import java.util.Scanner;

public class Test20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("성적을 입력하세요:");
//			String score1 = sc.nextLine();
			int score = sc.nextInt();
			char grade;
			
//			if(score1 == "exit") {
//				break;
//			}
//			int score = Integer.parseInt(score1);
			
			if (score > 100 || score < 0) {
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
				break;
//			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
//			score = sc.nextInt();
			}

//		if(score > 100 || score < 0) {
//			System.out.println("잘못 입력하셨습니다.");
//			return;
//		}

			if (score >= 90) {
				grade = 'A';
			} else if (score >= 80) {
				grade = 'B';
			} else if (score >= 70) {
				grade = 'C';
			} else if (score >= 60) {
				grade = 'D';
			} else {
				grade = 'F';
			}
			System.out.println("당신의 성적은 " + grade + "입니다.");
		}
		
		sc.close();
	}

}
