package Chap3_이진탐색;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;
public class 정수배열이진탐색_Test {

	private static void inputData(int[] data) {
		Random rand = new Random();
		
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(40);
		}
	}
	
	private static void showData(int[] data) {
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	private static void sortData(int[] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data.length; j++) {
				int temp = 0;
				if(data[i] < data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	private static int binarySearch(int[] data, int key) {
		int pl = 0;
		int pr = data.length - 1;
		int pc = (pr + pl)/2;
		
		while(pl <= pr) {
			if(data[pc] == key) {
				return pc;
			}else if(data[pc] < key){
				pl = pc + 1;
				pc = (pr + pl)/2;
			}else {
				pr = pc - 1;
				pc = (pr + pl)/2;
			}
		}
		
		return -1; //검색 실패
	}

	private static int linearSearch(int[] data, int key) {
		int p = 0;
		
		while(p < data.length) {
			if(data[p] == key) {
				return p;
			}
			p++;
		}
		
		return -1; //검색 실패
	}

	
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		for (int num: data) {
			System.out.print(num+" ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		
		key = 11;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
		
	}

	

	
	
}
