package chapter2;

public class Test15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 0b1011;
//		byte b = 0b1101;	
		char c = 'A';
		c = (char) a;
		int n;
		n = a;
		a = (byte) n;
		String gender = (c == 'A') ? "여자" : "남자"; // (조건) ? 조건이 참일 때의 값 : 조건이 거짓일 때의 값
		System.out.println(gender);
		
	}

}
