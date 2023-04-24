package com.ruby.java.ch13;

class Book{
	String name;
}

//class Bag{
//	Book book;
//	Pencil pencil;
//}

class Bag<T>{
	T item;
	public Bag(T thing) {
		item = thing;
	}
public T getThing() {
		
		return item;
	}
}

class Pencil{
	String name;
}

public class Test01 {
	public static void main(String[] args) {
		//Bag b = new Bag<>();
		Bag<Book> b = new Bag<Book>(new Book());
		Bag<Pencil> p = new Bag<Pencil>(new Pencil());
		
	}
}
