package Thread;

import java.awt.Toolkit;

public class SleepExample {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i<10; i++) {
			toolkit.beep();
			try {
				Thread.sleep(3000); //3초 동안 일시 정지 후 실행 대기(Runnable) 상태로 돌아가기
			}catch(InterruptedException e) {
				//interrupt() 메소드가 호출되면 실행
			}
		}
		
	}
}
