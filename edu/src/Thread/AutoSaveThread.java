package Thread;

public class AutoSaveThread extends Thread{
	//데몬 스레드 : 주 스레드의 작업을 돕는 보조적인 스레드 (주 스레드 종료시 데몬스레드도 종료)
	//1초 주기로 save()메소드를 호출하는 데몬 스레드
	public void save() {
		System.out.println("작업 내용을 저장함");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				break;
			}
			save();
		}
	}
		
}
