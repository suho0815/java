package Chap6_정렬;

import java.util.Random;

public class 단순선택정렬 {
	//단순 선택 정렬 : 가장 작은 요소를 찾아 맨 앞으로 이동하고, 다음으로 작은 요소를 찾아 두번째로 이동하는 등의 작업을 반복하는 알고리즘
	
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
	
	static void selectionSort(int []d) {
		// 오름차순으로 단순 선택 정렬
		int n = d.length;
		
		for(int i = 0; i < n-1; i++) {
			int min = i;
			for(int j = i + 1; j < n; j++) {
				if (d[min] > d[j]) { 
					min = j;
				}
			}
			swap(d, i, min);
		}
	}
	public static void main(String[] args) {
		int[] data = new int[10];
		
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println();
		System.out.println("\n최대값 : " + mvalue);
		selectionSort(data);
		System.out.println("정렬 후 결과");
		showData(data);
	}

}
