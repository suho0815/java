package com.ruby.java.ch06;

public class ArmorTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Armor suit = new Armor();
		System.out.println(suit.getName());
		//suit = null;
		suit.setName("mark6");
		suit.setHeight(180);
		System.out.println(suit.getName() + " : " + suit.getHeight());
	}

}
