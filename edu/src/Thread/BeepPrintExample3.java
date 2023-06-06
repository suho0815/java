package Thread;

import java.awt.Toolkit;

public class BeepPrintExample3 {
	// 메인 스레드와 작업 스레드 동시에 실행(익명 구현 객체(Thread의 매개값으로 익명 객체 구현) 이용, 이 방법이 많이 사용 됨)
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {
			
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
		});
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
