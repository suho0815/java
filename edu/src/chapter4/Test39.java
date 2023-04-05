package chapter4;

public class Test39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2차원 배열 오른쪽 대각선 순회 행과 열의 값이 같다.
		
		int[][] arr = { {1, 2, 3, 4, 5},
						{6, 7, 8, 9, 10},
						{11, 12, 13, 14, 15},
						{16, 17, 18, 19, 20},
						{21, 22, 23, 24, 25}};
		
		int sum = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				if (i == j)
//					sum = sum + arr[i][j];
//			}
//		}
		
		for(int i = 0; i < arr.length; i++) {
				sum = sum + arr[i][i];
		}
		System.out.println("합계 : " + sum);
		
	}

}
