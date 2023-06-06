package Thread;

import java.awt.Toolkit;

public class BeepThread extends Thread{
	// Thread 하위 클래스로 작업 스레드 생성
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
}
