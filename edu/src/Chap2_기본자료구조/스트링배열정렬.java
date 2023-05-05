package Chap2_기본자료구조;

import java.util.Iterator;
import java.util.Random;

public class 스트링배열정렬 {
	
	static void showData(String []d) {
		//배열 출력
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		System.out.println();
	}
	
	static void sortData(String []d) {
		// 오름차순으로 정렬 compareTo()메소드를 활용하여 해결
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if(d[i].compareTo(d[j]) < 0) {
					String temp = d[i];
					d[i] = d[j];
					d[j] = temp;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		String[] data = {"grape", "apple", "melon"};
		
		showData(data);
		sortData(data);
		showData(data);
		
	}

}
