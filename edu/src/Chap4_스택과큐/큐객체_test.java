package Chap4_스택과큐;

/*
 * Queue of ArrayList of Point
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//int형 고정 길이 큐
class ObjectQueue {
    private List<Point1> que;  
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

	public ObjectQueue(int maxlen) {
		front = rear = num = 0;
		capacity = maxlen;
		try {
			que = new ArrayList<Point1>();
		}catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public int size() {
		return num;
	}

	public int getCapacity() {
		return capacity;
	}

	public Point1 enque(Point1 x) {
		que.add(x);
		rear++;
		num++;

		return x;
	}

	public Point1 deque() {
		try {
			Point1 p = que.remove(front);
//			front++;
			rear--;
			num--;
			return p;
		}catch(EmptyQueueException e) {
			throw new EmptyQueueException();
		}

	}

	public Point1 peek() {
		try {
			return que.get(front);
		}catch(EmptyQueueException e) {
			throw new EmptyQueueException();
		}

	}

	public void dump() {
		if(isEmpty()) {
			System.out.println("큐가 비었습니다.");
		}else {
			for(int i = 0; i < num; i++) {
				Point1 p = que.get(i);
				System.out.println(p.getX() + " " + p.getY());
			}
		}
		
	}
	
	public boolean isEmpty() {
		return num == 0;
	}
	
}

class EmptyQueueException extends RuntimeException{
	public EmptyQueueException() {}
}

class Point1 {
	private int x;
	private int y;
	
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object p) {
		Point1 px = (Point1) p;
		if(this.x == px.x && this.y == px.y)
			return true;
		else
			return false;
	}
}

//int형 고정 길이 큐의 사용 예
public class 큐객체_test {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ObjectQueue s = new ObjectQueue(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point1 p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 인큐
				
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point1(rndx,rndy);
				s.enque(p);
				System.out.printf("데이터: %d , %d", rndx, rndy);
				break;

			case 2: // 디큐
				try {
					p = s.deque();
					System.out.println("디큐한 데이터는 " + p.getX() + " " + p.getY() + "입니다.");
				} catch (EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("피크한 데이터는 " + p.getX() + " " + p.getY() + "입니다.");
				} catch (EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}