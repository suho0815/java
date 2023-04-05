package chapter2;

public class Test9 {
	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		boolean gender = true;
		System.out.println(a == 10 && gender == false); // false
		System.out.println(a == 10 & gender == false); // false
		System.out.println(a == 10 || gender == false); // true
		
		if (a != 10 & !gender == false) {
			a++;
			System.out.println(a);
		}
		
		
		a+=b;
		System.out.println(a); // 12
		a-=b;
		System.out.println(a); // 10
		a*=b;
		System.out.println(a); // 20
		a/=b;
		System.out.println(a); // 5
		a%=b;
		System.out.println(a); // 0
	}
}
