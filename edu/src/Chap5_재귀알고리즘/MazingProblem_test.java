package Chap5_재귀알고리즘;

import java.util.ArrayList;
import java.util.List;

enum Directions {N, NE, E, SE, S, SW, W, NW}

class StackList{
    private List<Items> data;           // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터
	
	public StackList(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Items>();
		}catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public int push(Items x) throws OverflowGenericStackException {
		if(top >= capacity) {
			throw new OverflowGenericStackException();
		}
		data.add(x);
		return top++;
	}
	
	public Items pop() throws EmptyGenericStackException {
		if(top <= 0) {
			throw new EmptyGenericStackException();
		}
		//Point p = data.get(top--);
		Items p = data.remove(top-1);
		top--;
		return p;
	}
	
	public Items peek() throws EmptyGenericStackException {
		if(top <= 0) {
			throw new EmptyGenericStackException();
		}
		return data.get(top-1);
	}
	
	public void clear() {
		top = 0;
	}

	public int indexOf(Point x) {
		for(int i = top -1; i >= 0; i--) {
			if(data.get(i).equals(x)) {
				return i;
			}
		}
		return -1;
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top <= 0;
	}
	
	public boolean isFull() {
		return top >= capacity;
	}
	
	public void dump() {
		if(isEmpty())
//		if(ptr <= 0)
			System.out.println("stack이 비었습니다.");
		else {
			for(int i = 0; i < top; i++) {
				System.out.print(data.get(i).getX() + " " + data.get(i).getY() + " " + data.get(i).getDir());
				System.out.println();
			}
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
	
}

class Items { //
	int x;
	int y;
	int dir; // 방향?
	
	public Items(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir; 
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

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

}
class Offsets { //
	int a;
	int b;
	
	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
}

public class MazingProblem_test {

	static Offsets[] moves = new Offsets[8];//static을 선언하는 이유를 알아야 한다

	public static void path(int[][] maze, int[][] mark, int ix, int iy) {
	
		mark[1][1] = 1;
		StackList st = new StackList(50);
		Items temp = new Items(0, 0, 0);//N :: 0
		temp.x = 1;
		temp.y = 1;
		temp.dir = 2;//E:: 2
		mark[temp.x][temp.y] = 2;//미로 찾기 궤적은 2로 표시
		st.push(temp);
		
		while (!st.isEmpty()) { // stack not empty
		
			Items tmp = st.pop(); // unstack
			int i = tmp.x;
			int j = tmp.y;
			int d = tmp.dir;
			mark[i][j] = 1;//backtracking 궤적은 1로 표시
			while (d < 8) {// moves forward
				int g = i + moves[d].a;
                int h = j + moves[d].b;

				if ((g == ix) && (h == iy)) { // reached exit 미로 탙출하면
												// output path 미로 이동경로 결과 출력
                    mark[g][h] = 2;
//                    st.dump();
                    System.out.println("exit: " + ix + " " + iy);
                    return;
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
					mark[g][h] = 2;
//                    temp.x = i;
//                    temp.y = j;
//                    temp.dir = d + 1;
					Items temp1 = new Items(i, j, d+1);
                    st.push(temp1);
                    i = g;
                    j = h;
                    d = 0;
				} else {
					d++;
				}
				
			}
		}
		System.out.println("no path in maze ");
	}

	public static void main(String[] args) {
		int[][] maze = new int[14][17]; 
		int[][] mark = new int[14][17]; // 이동 한 곳 체크

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);//배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;	moves[0].b = 0;
		moves[1].a = -1;	moves[1].b = 1;
		moves[2].a = 0;		moves[2].b = 1;
		moves[3].a = 1;		moves[3].b = 1;
		moves[4].a = 1;		moves[4].b = 0;
		moves[5].a = 1;		moves[5].b = -1;
		moves[6].a = 0;		moves[6].b = -1;
		moves[7].a = -1;	moves[7].b = -1;
		//Directions d;
		//d = Directions.N;
		//d = d + 1;//java는 지원안됨
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
//				maze[i][j] = input[i][j];
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
					
				mark[i][j] = 0;

			}
		}
		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");
				
			}
			System.out.println();
		}
		System.out.println("mark::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}
		path(maze, mark, 12, 15);
		System.out.println("mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}

	}
}
