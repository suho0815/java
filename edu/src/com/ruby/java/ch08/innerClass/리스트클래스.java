package com.ruby.java.ch08.innerClass;

class Node{ // 값을 담을 String과 다음 주소값을 참조할 Node 
	String data;
	Node link;
	Node(String data){
		this.data = data;
		link = null;
	}
	public String toString() {
		return "data = "+data;
	}
}

class LinkedList { 
	Node head; // 연결리스트 최초의 주소값 참조
	
	void show() {
		Node p = head;
		while (p!=null) {
			System.out.println(p.toString());
			p = p.link;
		}
	}
	
	void add(String name) {
		Node temp = new Node(name);	
		if (head == null) {
			head = temp;
		}
		else {
			temp.link = head;
			head = temp;
		}
	}
	
}

public class 리스트클래스 {
	public static void main(String[] args) {
		LinkedList my = new LinkedList();
		my.add("hong");
		my.add("kim");
		my.add("lee");
		my.add("park");
		my.add("Ko");
		my.show();
	}
}
