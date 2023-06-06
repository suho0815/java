package Thread;

public class User2 extends Thread {
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		this.setName("User2"); // 스레드 이름 변경
		this.calculator = calculator; // 공유객체인 calculator를 필드에 저장
	}

	public void run() {
		calculator.setMemory(50);
	}
	
}
