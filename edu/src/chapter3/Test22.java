package chapter3;

import java.util.Scanner; // Scanner 클래스 호출

public class Test22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		byte a = in.nextByte(); 		// byte 형 입력 및 리턴
//		short b = in.nextShort(); 		// short 형 입력 및 리턴
//		int c = in.nextInt(); 			// int 형 입력 및 리턴
//		long d = in.nextLong(); 		// long 형 입력 및 리턴
// 
//		float e = in.nextFloat(); 		// float 형 입력 및 리턴
//		double f = in.nextDouble(); 	// double 형 입력 및 리턴
// 
//		boolean g = in.nextBoolean(); 	// boolean 형 입력 및 리턴
// 
//		String h = in.next(); 			// String 형 입력 및 리턴 (공백을 기준으로 한 단어를 읽음)
//		String i = in.nextLine(); 		// String 형 입력 및 리턴 (개행을 기준으로 한 줄을 읽음)
		
		while(true) {
			int a = 0;
			int b = 0;
			System.out.println("연산자를 입력하세요 : ");
			Scanner sc = new Scanner(System.in); // Scanner 객체 생성
			char op = sc.next().charAt(0); // 입력받은 문자열 중 첫번째 문자 가져오기
//		char op = '+';

			if (op == '+' || op == '-' || op == '*' || op == '/') {
				System.out.println("첫번째 숫자를 입력하세요 : ");
				a = sc.nextInt();

				System.out.println("두번째 숫자를 입력하세요 : ");
				b = sc.nextInt();
			}

			switch (op) {
			case '+':
				System.out.println(a + b);
				break;
			case '-':
				System.out.println(a - b);
				break;
			case '*':
				System.out.println(a * b);
				break;
			case '/':
				System.out.println(a / b);
				break;
			default:
				System.out.println("잘못된 연산입니다.");
				sc.close();
				return;
			}
			
			sc.close();
		}
//		String op = sc.next();
//		
//		switch(op) {
//		case "+":
//			System.out.println(a + b);
//			break;
//		case "-":
//			System.out.println(a - b);
//			break;
//		case "*":
//			System.out.println(a * b);
//			break;
//		case "/":
//			System.out.println(a / b);
//			break;	
//		default:
//			System.out.println("잘못된 연산입니다.");
//			break;
//		}
		
	}

}
