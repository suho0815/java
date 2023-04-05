package chapter2;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		a++;
		System.out.println(a); // 11
		++a;
		System.out.println(a); // 12
		
		int b = 10;
		b--;
		System.out.println(b); // 9
		--b;
		System.out.println(b); // 8
		
		int c = 10;
		int d = 10;
		System.out.println("++c = " + ++c); // 11 (전위연산) 증감 연산을 먼저 처리 후 다른 명령 수행
		System.out.println("d++ = " + d++); // 10 (후위연산) 다른 명령 수행 후 증감 연산 처리
	}

}
