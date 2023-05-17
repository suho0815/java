package Chap5_재귀알고리즘;


//재귀에 대한 이해를 돕는 순수 재귀 메서드(재귀를 제거)

import java.util.Scanner;


class IntStack {
	private int[]stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터
	
	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		}catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public int push(int x) throws OverflowIntStackException {
		if(ptr >= capacity) {
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x;
	}
	
	public int pop() throws EmptyIntStackException {
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[--ptr];
	}
	
	public int peek() throws EmptyIntStackException {
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr-1];
	}
	
	public void clear() {
		ptr = 0;
	}

	public int indexOf(int x) {
		for(int i = ptr -1; i >= 0; i--) {
			if(stk[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	public boolean isFull() {
		return ptr >= capacity;
	}
	
	public void dump() {
		if(isEmpty())
//		if(ptr <= 0)
			System.out.println("stack이 비었습니다.");
		else {
			for(int i = 0; i<ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
	
}

class EmptyIntStackException extends RuntimeException{
	public EmptyIntStackException() {}
}

class OverflowIntStackException extends RuntimeException{
	public OverflowIntStackException() {}
}

public class 리커시브X2_test {
	// --- 재귀를 제거한 recur ---//
	static void recur(int n) {
		IntStack s = new IntStack(n);

		while (true) {
			if (n > 0) {
				
				
				s.push(n); // n 값을 푸시
				n = n - 1;
				continue;
			}
			if (s.isEmpty() != true) { // 스택이 비어 있지 않으면
				n = s.pop(); // 저장하고 있던 값을 n에 팝
				System.out.println(n);
				n = n - 2;
				continue;
			}
			break;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();

		recur(x);
	}
}
