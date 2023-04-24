package com.ruby.java.ch13;

import java.util.Arrays;
import java.util.List;

public class WildCardTest {

	public static void main(String[] args) {
		Integer[] inum = {1,2,3,4};
		Double[] dnum = {1.0, 2.0, 3.0};
		String[] snum = {"1", "2", "3"};
		List<Integer> iList = Arrays.asList(inum);
		List<Double> dList = Arrays.asList(dnum);
		List<String> sList = Arrays.asList(snum);
		double isum = sum(iList);
//		double ssum = sum(sList);

	}

	public static double sum(List<? extends Number> list) {
		// TODO Auto-generated method stub
		double total = 0;
		for (Number v: list) {
			total += v.doubleValue();
		}
		return total;
	}

}
