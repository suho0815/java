package Thread;

import java.awt.Toolkit;

public class BeepPrintExample5 {
	// 메인 스레드와 작업 스레드 동시에 실행(Thread의 하위 클래스로 작업스레드 만들기 (익명 객체))
	public static void main(String[] args) {
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0; i<5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					}catch(Exception e) {
						
					}
				}
			}
		};
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
