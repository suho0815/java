package chapter2;

public class Test3 {

	public static void main(String[] args) {
		
		byte age;
		short point;
		int price;
		long totalSales;
		
		age = 23;
		point = 32000;
		price = 2147483647;
		totalSales = 2147483648L;
		
		System.out.println(age);
		System.out.println(point);
		System.out.println(price);
		System.out.println("totalSales= " + totalSales);
		
	}

}
