package Chap6_정렬;

import java.util.Random;

public class 단순삽입정렬 {
	//단순 삽입 정렬 : 선택한 요소를 앞쪽의 알맞는 위치에 삽입하는 작업을 반복하는 알고리즘(버블 정렬과 비슷)
	
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
	
	static void insertionSort(int []d) {
		// 오름차순으로 단순 선택 정렬
		int n = d.length;
		
		for(int i = 1; i < n; i++) {
			int j;
			int temp = d[i];
			for(j = i; j > 0 && d[j-1] > temp; j--) {
				d[j] = d[j-1];
			}
			d[j] = temp;
		}
	}
	public static void main(String[] args) {
		int[] data = new int[10];
		
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println();
		System.out.println("\n최대값 : " + mvalue);
		insertionSort(data);
		System.out.println("정렬 후 결과");
		showData(data);

	}

}
