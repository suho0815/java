package Chap6_정렬;

import java.util.Random;

public class 셸정렬 {
	//셸 정렬 : 단순 삽입 정렬의 장점은 살리고 단점은 보완한 알고리즘
	// 배열크기/2 의 간격으로 떨어져있는 요소들을 그룹으로 묶어 정렬하고, 계속 /2로 간격을 좁혀가며 정렬을 반복하여 이동 횟수를 줄이는 방법  
	
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
	
	static void ShellSort(int []d) {
		// 오름차순으로 단순 선택 정렬
		int n = d.length;
		
		for (int h = n / 2; h > 0; h /= 2)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = d[i];
                for (j = i - h; j >= 0 && d[j] > tmp; j -= h)
                    d[j + h] = d[j];
                d[j + h] = tmp;
            }
	}
	public static void main(String[] args) {
		int[] data = new int[10];
		
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println();
		System.out.println("\n최대값 : " + mvalue);
		ShellSort(data);
		System.out.println("정렬 후 결과");
		showData(data);

	}

}
