package baekjoon;

import java.util.*;

class Parent{
	int x = 100;
	
	Parent(){
		this(500);
	}
	
	Parent(int x){
		this.x = x;
	}
	int getX() {
		return this.x;
	}
}
class Child extends Parent{
	int x = 1000;
	
	Child(){
		this(5000);
	}
	
	Child(int x){
		this.x= x;
	}
	
	int getX(int n) {
		return n;
	}
}


public class Main {

	public static void main(String[] args) {
		Child obj = new Child();
		System.out.println(obj.getX());
		
	}

}
