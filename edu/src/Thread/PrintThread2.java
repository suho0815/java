package Thread;

public class PrintThread2 extends Thread{
	
	
	public void run() {
//		try {
			//일시 정지 상태인 스레드가 interrupt()메소드를 실행하면 InterruptedException 발생하여 예외처리로 실행대기 or 종료 가능
//			while(true) { 
//				System.out.println("실행 중");
//				Thread.sleep(1); //일시 정지
//			}
	
			
//		}catch(InterruptedException e) {} 
		
		// Thread.interrupted() 정적 메소드 활용 (interrupt()메소드가 호출되었으면 true반환)
			while(true) { 
				System.out.println("실행 중");
				if(Thread.interrupted()) {
					break;
				}
			}
					
		// objThread.isinterrupted() 인스턴스 메소드 활용 (interrupt()메소드가 호출되었으면 true반환)
//			while(true) { 
//				System.out.println("실행 중");
//				if(this.isInterrupted()) {
//					break;
//				}
//			}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
	
}
