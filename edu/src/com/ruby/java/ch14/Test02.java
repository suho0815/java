package com.ruby.java.ch14;

@FunctionalInterface
interface Multiply{
	double getValue();
//	double print();
}

@FunctionalInterface
interface verify{
	boolean check(int n);
}

interface verify2{
	boolean check(int n, int d);
}

interface NumberFunc{
	int func(int n);
}

public class Test02 {
	public static void main(String[] args) {
		Multiply m;
		m =() -> 3.14*2;
		System.out.println(m.getValue());
		
		verify isEven = (n) -> (n % 2) ==0;
		System.out.println(isEven.check(10));
		
		verify2 v = (n, d) -> (n % d) ==0;
		System.out.println(v.check(24, 3));
		
		NumberFunc sum = (n) -> {
			int result = 0;
			for(int i = 0; i <=n;i++) {
				result += i;
			}
			return result;
		};
		System.out.println("1부터 10까지의 합 : " + sum.func(10));
		
	}
}
