package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Iterator;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열과 다르게 데이터 추가와 길이설정이 필요 없는 등 개발자 입장에서 편함 대신 속도 느림
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울"); list.add("부산"); list.add("창원");
		list.add("서울"); list.add("울산"); list.add("밀양");
		for(int i= 0; i< list.size(); i++) {
			System.out.print(" " + list.get(i));
		}
		System.out.println();
		System.out.println("=================================");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.print(" " + iter.next());
		}
		System.out.println();
		System.out.println("=================================");
		String [] sl = new String[10];
		sl[0] ="서울"; sl[1] ="부산";
		for(String sx : sl) {
			System.out.print(" " + sx);
		}
		
	}

}
