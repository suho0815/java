package com.ruby.java.ch13;

class Bag1<T, N>{
	T thing;
	N name;
	public Bag1(T thing, N name){
		this.thing  = thing;
		this.name = name;
	}
	public void showType() {
		System.out.println("타입은 " + this.getClass());
	}
	
}

public class Test02 {
	public static void main(String[] args) {
		Bag1<Book, String> bag = new Bag1<Book, String>(new Book(), new String());
		bag.showType();
	}
}
