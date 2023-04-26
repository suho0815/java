package Chap2_기본자료구조;

import java.util.Random;

public class 메소드배열전달 {
	static void getData(int []d) {
		//난수 생성하여 배열에 입력
		Random rand = new Random();
		
		for(int i = 0; i < d.length; i++) {
			d[i] = rand.nextInt(10);
		}
	}
	static void showData(int []d) {
		//배열 출력
		for(int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		
	}
	static int findMax(int []d) {
		//최대값 찾기
		int temp = 0;
		for(int i = 0; i < d.length; i++) {
			if(temp < d[i]) {
				temp = d[i];
			}
		}
		return temp;
	}
	
	static void swap(int[]d, int i , int j) {
		// 배열의 자리 바꾸기
		int temp = d[i];
		d[i] = d[j];
		d[j] = temp;
	}
	
	static void sortData(int []d) {
		// 오름차순으로 정렬
		
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d.length; j++) {
				if (d[i] < d[j]) {
					swap(d, i, j);
				}	
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] data = new int[10];
		
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println();
		System.out.println("\n최대값 : " + mvalue);
		sortData(data);
		System.out.println("정렬 후 결과");
		showData(data);
	}
}
