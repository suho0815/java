package edu.chapter07;

public class Mission4 {
	private int sumOdd, sumEven, sumTotal;
	
	public Mission4() {
		
		for(int i = 1; i <= 1000; i++) {
			if(i % 2 == 0) {
				sumEven += i;
			}else {
				sumOdd += i;
			}
		}
		sumTotal = sumOdd + sumEven;
		
	}
	
	public int getSumOdd() {
		return sumOdd;
	}

	public int getSumEven() {
		return sumEven;
	}

	public int getSumTotal() {
		return sumTotal;
	}

	public static void main(String[] args) {
		// 1 ~ 1000까지의 숫자 홀수 합
		// 1 ~ 1000까지의 숫자 짝수 합
		// 총계 합 구하기
		
//		int sumOdd = 0, sumEven = 0, sumTotal = 0;
		
//		for(int i = 1; i <= 1000; i++) {
//			if(i % 2 == 0) {
//				sumEven += i;
//			}else {
//				sumOdd +=i;
//			}
//		}
//		sumTotal = sumOdd + sumEven;
		
//		System.out.println("1~1000까지의 홀수 합 : " + sumOdd);
//		System.out.println("1~1000까지의 짝수 합 : " + sumEven);
		Mission4 m = new Mission4();
		System.out.println("1~1000까지의 홀수 합 : " + m.sumOdd);
		System.out.println("1~1000까지의 짝수 합 : " + m.sumEven);
		System.out.println("총계 합 : " + m.sumTotal);
		
	}

}
