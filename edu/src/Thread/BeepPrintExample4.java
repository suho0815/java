package Thread;

import java.awt.Toolkit;

public class BeepPrintExample4 {
	// 메인 스레드와 작업 스레드 동시에 실행(Thread의 하위 클래스로 작업스레드 만들기)
	public static void main(String[] args) {
		
		Thread thread = new BeepThread();
		thread.start();
		
		for(int i = 0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				
			}
		}
		

	}

}
