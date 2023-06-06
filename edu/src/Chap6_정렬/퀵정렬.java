package Chap6_정렬;

import java.util.Random;

public class 퀵정렬 {
	// 퀵 정렬 : 가장 빠른 정렬 알고리즘 그룹의 기준(피벗)을 설정하여 두그룹으로 나눈 뒤 정렬을 반복
	
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
	
	static void quickSort(int []d, int left, int right) {
		// 퀵 정렬
		int pl = left; // 왼쪽 커서
		int pr = right; // 오른쪽 커서
		int x = d[(pl + pr) /2]; // 피벗(가운데)
		
		do {
			while(d[pl] < x) pl++;
			while(d[pr] > x) pr--;
			if(pl <= pr) // 피벗 이하의 요소(왼쪽), 피벗 이상의 요소(오른쪽)그룹의 벗어나는 값이 있으면 스왑
				swap(d, pl++, pr--);
		}while(pl <= pr);
		
		if(left < pr) quickSort(d, left, pr);
		if(pl < right) quickSort(d, pl, right);
		
	}
	public static void main(String[] args) {
		int[] data = new int[10];
		
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println();
		System.out.println("\n최대값 : " + mvalue);
		quickSort(data, 0 ,data.length-1);
		System.out.println("정렬 후 결과");
		showData(data);
		

	}

}
