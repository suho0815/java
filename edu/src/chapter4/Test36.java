package chapter4;

public class Test36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letter = 'A';
		char[] alphabet = new char[26];
		
		for(int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char) (letter + i); // 아스키코드(ASCII) 이용
		}
		for(char c : alphabet) {
			System.out.print(c);
		}
		
	}

}
