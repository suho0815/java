package chapter4;

public class Mission2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrA = { {1, 2, 3, 4},
						{5, 6, 7, 8},
						{9, 10, 11, 12}}; // 3*4 행렬
						
		int[][] arrB = { {1, 2, 3},
						{4, 5, 6},
						{7, 8, 9},
						{10, 11, 12}}; // 4*3 행렬
		
		int[][] arrC = new int[3][3]; // 행렬 곱의 연산 결과 값
		
		
		for(int i = 0; i < arrA[0].length; i++) {
			int temp = 0;
			for(int j = 0; j <arrB.length; j++) {
				temp = temp + (arrA[i][j] * arrB[j][i]);
				
//				System.out.println(temp);
				if(j == 3) {
					arrC[i][j] = temp;
					System.out.println(arrC[i][j]);
				}
					
			}
			 
		}
		
//		for(int i = 0; i < arrA.length; i++) {
//			for(int j = 0; j <arrB[0].length; j++) {
//				System.out.println(arrC[i][j]);
//			}
//		}
		
	}

}
