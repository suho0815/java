package com.ruby.java.ch14;

interface StringFunc{
	String modify(String s);
}

public class Test07 {
	static String test(StringFunc sf, String s) {
		return sf.modify(s);
	}
	public static void main(String[] args) {
		String str = "Korea";
		StringFunc sf1 = (s) -> {
			
			return s;
		};
		
		test(sf1, str);
		
	}
}
