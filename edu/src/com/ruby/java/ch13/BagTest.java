package com.ruby.java.ch13;

class Bagg{
	Object thing;
	public Bagg(Object thing) {
		this.thing = thing;
	}
	
}
//class Note{
//	String name;
//}


public class BagTest {
	public static void main(String[] args) {
		Bagg b = new Bagg(new Book());
		Bagg p = new Bagg(new Pencil());
		//Book book = b.getThing();
		b = p; //오류 발생 > 매우 당연하고 정상적
	}
}
