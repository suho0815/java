package Chap2_기본자료구조;

import java.util.Random;

public class test01 {

	static void getData(int [][]d) {
		//난수 생성하여 2차원배열에 난수 입력
		Random rand = new Random();
		
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d[i].length; j++) {
				d[i][j] = rand.nextInt(10);
			}
		}
		
	}
	static void showData(int [][]d) {
		//2차원배열 출력
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	static int[][] addMatrix(int [][]a, int [][]a1 , int [][]a2) {
		//2차원 배열의 합
		for(int i = 0; i < a2.length; i++) {
			for(int j = 0; j < a2[i].length; j++) {
				a2[i][j] = a[i][j] + a1[i][j];
			}
		}
		
		return a2;
	}
	
	static int[][] multipleMatrix(int [][]a, int [][]b, int [][]c) {
		//2차원 배열의 곱
		int temp = 0;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				for(int k =0; k < a[0].length; k++) {
					
					c[i][j] += a[i][k] * b[k][j];
				}
				 
			}
		}
		
		return c;
	}
	
	static int[][] transposeMatrix(int [][]a, int[][]d){
		//a의 전치행렬
		for(int i = 0; i < d.length; i++) {
			for(int j =0; j < d[0].length; j++) {
				d[i][j] = a[j][i];
			}
		}
		
		return d;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]a = new int[2][3];
		int [][]a1 = new int[2][3];
		int [][]a2 = new int[2][3];
		int [][]b = new int[3][6];
		int [][]c = new int[2][6];
		int [][]d = new int[3][2];
		
		System.out.println("행렬 A ");
		getData(a);
		showData(a);
		
		System.out.println("\n행렬 A1 ");
		getData(a1);
		showData(a1);
		
		System.out.println("\n행렬 B ");
		getData(b);
		showData(b);
		
		System.out.println("\n행렬 A2 = 행렬 A + 행렬 A1 ");
		a2 = addMatrix(a, a1, a2);
		showData(a2);
		
		System.out.println("\n행렬 C = 행렬 A * 행렬 B ");
		c = multipleMatrix(a,b,c);
		showData(c);
		
		System.out.println("\n행렬 D = 행렬 A의 전치행렬");
		d = transposeMatrix(a, d);
		showData(d);
	}

}
