package Thread;

public class User1 extends Thread {
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		this.setName("User1"); // 스레드 이름 변경
		this.calculator = calculator; // 공유객체인 calculator를 필드에 저장
	}

	public void run() {
		calculator.setMemory(100);
	}
	
}
