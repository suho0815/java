package com.ruby.java.ch13;

class Solid{
	
}
class Liquid{
	
}
class book2 extends Solid{
	
}
class pencil2 extends Solid{
	
}
class note extends Solid{
	
}
class Water extends Liquid{
	
}
class Coffee extends Liquid{
	
}

class Bag2<T>{
	T item;
	Object owner;
	public Bag2(T thing) {
		item = thing;
	}
public T getThing() {
		return item;
	}
String getOwner() {
	return null;
	
}
boolean isSameOwner(Bag2<T> obj) {
	if(this.owner.equals(obj.getOwner()))
		return true;
	return false;
}

}

public class Test03_1 {
	public static void main(String[] args) {
		Bag2<book2> book = new Bag2<>(new book2());
		Bag2<Water> Water = new Bag2<>(new Water());
		
	}
}
