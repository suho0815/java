package edu.chapter07.abstraction;

public interface Messenger {
	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 104857600;
	
	public abstract String getMessage(); //인터페이스 통일을 목적으로 바디 구현x
	public abstract void setMessage(String msg); //컴파일시 자동으로 public abstract 추가됨
	
	public default void setLogin(boolean login) {
		log();
		if(login) {
			System.out.println("로그인 처리합니다.");
		} else {
			System.out.println("로그아웃 처리합니다.");
		}
	}
	
	public static void getConnection() { 
		System.out.println("network에 연결합니다.");
	}
	
	private void log() { //접근 제한 default메서드에서 사용할 목적으로 사용
		System.out.println("start job!");
	}
	
}
