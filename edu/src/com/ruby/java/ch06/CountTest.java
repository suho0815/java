package com.ruby.java.ch06;

class Count {
	public static int totalCount;
	int count;
	private int num;
	
	public void setNum(int n) {
		num = n;
	}
	public int getNum() {
		return num;
	}
}

public class CountTest {
	int m = 10;
	public static void show() {
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show();
		int num = 0;
		Count.totalCount = 10;
		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();

		c3.totalCount = 110;
		
		c1.count++;
		Count.totalCount++;
		c2.count++;
		Count.totalCount++;
		c3.count++;
		Count.totalCount++;

		System.out.println(Count.totalCount + " : " + c1.count);
		System.out.println(Count.totalCount + " : " + c2.count);
		System.out.println(Count.totalCount + " : " + c3.count);
	}

}
