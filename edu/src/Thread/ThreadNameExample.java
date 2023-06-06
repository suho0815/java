package Thread;

public class ThreadNameExample {
	public static void main(String[] args) {
		
		Thread mainThread = Thread.currentThread(); // 현재 스레드의 참조얻기(Thread 클래스의 정적 메소드)
		System.out.println("프로그램 시작 스레드 이름 : " + mainThread.getName());
		
		Thread threadA = new Thread() {
			
			@Override
			public void run() {
				for(int i = 0; i<2; i++) {
					System.out.println(getName()+ "가 출력한 내용");
				}
			}
		};
		threadA.setName("threadA");
		System.out.println("프로그램 시작 스레드 이름 : " + threadA.getName());
		threadA.start();
		
		
		ThreadB threadB = new ThreadB();
		System.out.println("프로그램 시작 스레드 이름 : " + threadB.getName());
		threadB.start();
		
		ThreadC threadC = new ThreadC();
		System.out.println("프로그램 시작 스레드 이름 : " + threadC.getName());
		threadC.start();
		
	}
}
