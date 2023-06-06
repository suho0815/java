package Thread;

public class StopFlagExample {
	public static void main(String[] args) {
		// stop()메소드가 있지만 사용 중인 자원들이 불안정한 상태로 남겨져서 사용x
		// stop 플래그를 이용하여 1초 후 출력 스레드 종료
		PrintThread1 printThread = new PrintThread1();
		printThread.start();
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		
		printThread.setStop(true);
	}
}
