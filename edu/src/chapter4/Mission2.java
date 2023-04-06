package chapter4;

public class Mission2 {

	public void matrix() {
		int[][] arrA = { {1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}}; // 3*4 행렬
				
		int[][] arrB = { {1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{10, 11, 12}}; // 4*3 행렬

		int[][] arrC = new int[3][3]; // 행렬 곱의 연산 결과 값
		
		
		for(int i = 0; i < arrA.length; i++) {
			for(int j = 0; j < arrB[0].length; j++) { 
				for(int k = 0; k <arrB.length; k++) { // 행렬의 곱 계산을 위한 for문 곱셈을 4번 하고 다 더함	
					arrC[i][j] += arrA[i][k] * arrB[k][j];		
				}		
			}
		}
		
		for(int i = 0; i < arrC.length; i++) {
			for(int j = 0; j < arrC[0].length; j++) {
				System.out.print(arrC[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Mission2 m = new Mission2();
		m.matrix();

	}

}
