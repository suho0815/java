package chapter2;

public class Test13 {
	public static void main(String[] args) {
		byte a = 0b1011;
		byte b = 0b1101;
		int c = a & b;
		// byte c = (byte) (a & b);
		
		System.out.println("c = " + c);
		System.out.println(Integer.toBinaryString(c));
		System.out.println(Integer.toBinaryString(a));
		
		int e = a ^ b; // 비트 XOR 연산 (^)
		System.out.println(Integer.toBinaryString(e)); // 0110
		
		int f = 12;
		int g = (~f) +1; // 비트 부정 연산 (~)
		System.out.println(g); //
		System.out.println(Integer.toBinaryString(g));
		
		int h = f << 2; // 비트 왼쪽 쉬프트(shift) 연산 (원래 값에 * 2의 n승과 같다)
		int i = h >> 1; // 비트 오른족 쉬프트(shift) 연산 (원래 값에 / 2의 n승과 같다)
		System.out.println(Integer.toBinaryString(h));
		System.out.println(Integer.toBinaryString(i));
		
		char ch = 'A';
		int n = ch;
		System.out.println("n = " + n);
		System.out.println(Integer.toBinaryString(n));
		ch ^= (1 << 5);
		System.out.println(Integer.toBinaryString(ch));
		System.out.println(ch);
		int x = ch;
		System.out.println(x);
		
		/*
		int c = a & b; // 0
		System.out.println(Integer.toBinaryString(c));
		
		int d = a | b; // 1111
		System.out.println(Integer.toBinaryString(d));
		
		int e = a ^ b; // 1111
		System.out.println(Integer.toBinaryString(e));
		*/
	}
}
