package com.ruby.java.ch08.innerClass;

interface Messenger{
	String getMessage();
	void setMessage(String msg);
}
/*
class GMessenger implements Messenger{
	public String getMessage() {
		return "good";
	}
	public void setMessage(String msg) {
		System.out.println("my data = " + msg);
	}
	public void changeMode() {
		System.out.println("changed");
	}
}
*/
public class 익명클래스 {
	public static void main(String[] args) {
		//GMessenger gm = new GMessenger();
		Messenger gm = new Messenger() {
			public String getMessage() {
				return "good";
			}
			public void setMessage(String msg) {
				System.out.println("my data = " + msg);
			}
			public void changeMode() {
				System.out.println("changed");
			}
		};
		gm.getMessage();
		gm.setMessage("hong");
	}
}
