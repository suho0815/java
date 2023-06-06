package Thread;

public class Calculator {
	// 공유 객체
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	// 임계 영역(단 하나의 스레드만 실행할 수 있는 코드영역) 설정 전
//	public void setMemory(int memory) {
//		this.memory = memory;
//		try {
//			Thread.sleep(2000);
//		}catch(Exception e) {
//			
//		}
//		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
//	}
	
	// 동기화 메소드(임계영역 지정)로 수정
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
	
}
