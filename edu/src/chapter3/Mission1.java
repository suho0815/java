package chapter3;

import java.util.Scanner;

public class Mission1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 국영수 세 과목의 점수를 입력 받은 뒤 평균을 구해서 70점 이상일 때 통과
		// 한 과목이라도 60점 미만이면 과락
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			
			System.out.println("국어 점수를 입력하세요: ");
			float score1 = sc.nextFloat();

			if (score1 > 100 || score1 < 0) {
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
			System.out.println("영어 점수를 입력하세요: ");
			float score2 = sc.nextFloat();

			if (score2 > 100 || score2 < 0) {
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
			System.out.println("수학 점수를 입력하세요: ");
			float score3 = sc.nextFloat();

			if (score3 > 100 || score3 < 0) {
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
//			int exit = -1;
//			if( (int) score1 == exit) {
//				System.out.println("");
//			}
			
			
			float sum = score1 + score2 + score3;
			float avg = sum / 3;
			
			System.out.print("총계 : " + String.format("%.2f", sum) + ", ");
			System.out.print("평균 : " + String.format("%.2f", avg) + ", "); // 소수점 둘째자리까지 출력

			if (score1 < 60 || score2 < 60 || score3 < 60) {
				System.out.println("과락");
			} else if (avg >= 70) {
				System.out.println("통과");
			} else {
				System.out.println("과락");
			}
			
			sc.close();
			
		}
		
		
	}

}
