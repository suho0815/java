package Chap6_정렬;

import java.util.Random;

public class 버블정렬 {
	//정렬 방법 종류, (버블, 단순선택, 단순삽입, 셸, 퀵, 힙, 병합)
	
	// 버블 정렬 : 서로 인접한 두 원소를 비교하여 정렬하는 알고리즘
	// 요솟수가 n개인 배열에서 n-1번 비교(첫번째 패스) ,, n-2번 비교(두번째 패스),,,,  
	
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
	
	static void bubbleSort(int []d) {
		// 오름차순으로 버블정렬
		int n = d.length;
		
		for(int i = 0; i < n-1; i++) {
			for(int j = n-1; j > i; j--) {
				if (d[j-1] > d[j]) { 
					swap(d, j-1, j);
				}
				
			}
		}
	}
	
	static void bubbleSort2(int []d) {
		// 오름차순으로 버블정렬 알고리즘 개선 ver.2
		int n = d.length;
		
		for(int i = 0; i < n-1; i++) {
			int exchg = 0; // 패스에서 교환하는 횟수 저장
			
			for(int j = n-1; j > i; j--) { // 패스
				if (d[j-1] > d[j]) { 
					swap(d, j-1, j);
					exchg++;
				}
			}
			
			if(exchg == 0 ) break; // 교환이 없으면 멈추기(이미 정렬이 다 되어있어 불필요한 연산x)
		}
	}
	
	static void bubbleSort3(int []d) {
		// 오름차순으로 버블정렬 알고리즘 개선 ver.3
		int n = d.length;
		
		int k = 0;                               // a[k]보다 앞쪽은 정렬을 마침
        while (k < n - 1) {
            int last = n - 1;                    // 마지막으로 교환한 위치
            for (int j = n - 1; j > k; j--)
                if (d[j - 1] > d[j]) {
                    swap(d, j - 1, j);
                    last = j;
                }
            k = last;
        }
	}
	
	public static void main(String[] args) {
		int[] data = new int[10];
		
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println();
		System.out.println("\n최대값 : " + mvalue);
		bubbleSort3(data);
		System.out.println("정렬 후 결과");
		showData(data);

	}

}
