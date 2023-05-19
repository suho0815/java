
//package Chap5_재귀알고리즘;
// https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
// N Queen problem / backtracking
package Chap5_재귀알고리즘;

import java.util.ArrayList;
import java.util.List;


class Stack3{
    private List<Point> data;           // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터
	
	public Stack3(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Point>();
		}catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public int push(Point x) throws OverflowGenericStackException {
		if(top >= capacity) {
			throw new OverflowGenericStackException();
		}
		data.add(x);
		return top++;
	}
	
	public Point pop() throws EmptyGenericStackException {
		if(top <= 0) {
			throw new EmptyGenericStackException();
		}
		//Point p = data.get(top--);
		Point p = data.remove(top-1);
		top--;
		return p;
	}
	
	public Point peek() throws EmptyGenericStackException {
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
				System.out.print(data.get(i).getX() + " " + data.get(i).getY());
				System.out.println();
			}
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
	
}

class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
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
		Point px = (Point) p;
		if(this.x == px.x && this.y == px.y)
			return true;
		else
			return false;
	}
}

class OverflowGenericStackException extends RuntimeException{
	public OverflowGenericStackException() {}
}

class EmptyGenericStackException extends RuntimeException{
	public EmptyGenericStackException() {}
}


public class Chap5_Test_QueenEight_revised {

	static final int numberQueens = 4;
	
	public static void SolveQueen(int[][] d) {
		int count = 0, mode = 0;
		int ix = 0, iy = 0;
		Stack3 st = new Stack3(10);
		Point p = new Point(ix, iy);
		d[ix][iy] = 1; count++;
		st.push(p);
		while (count < numberQueens) {
			ix++;		int cy = 0;
			while (ix < numberQueens){
				cy = nextMove(d, ix);
				if(st.peek().getY() == cy && ix == st.peek().getX()) {
//				if(ix == st.peek().getX()) {
					p = st.pop(); count--;
					//d[p.getX()][p.getY()] = 0;
					//for(int i = st.peek().getY(); i < d[0].length; i++ ) {
						//checkMove(d, ix, i)
					//}
					
					cy++;
				}
				
//				if(p.getY() == cy) {
//					cy++;
//				}
				
				while (cy < numberQueens) {
						Point px = new Point(ix, cy);
						st.push(px); count++;
						st.dump();
						
						break;
			
				}
				if (cy != -1) { // 퀸을 놓을 곳이 없으면
					d[st.peek().getX()][st.peek().getY()] = 1;
					break;
				} else {
					
				 p = st.pop();	 count--;
				 d[st.peek().getX()][st.peek().getY()] = 0;
				 
				 ix--;
				 
				}

			}
		}
	}
	
//	public static void SolveQueen(int[][] d) {
//		int count = 0;
//		int ix = 0, iy = 0;
//		Stack3 st = new Stack3(10);
//		Point p = new Point(ix, iy);
//		d[ix][iy] = 1;
//		count++;
//		st.push(p);
//		
//		while (count < 8) {
//			ix++;
//			int cy = 0;
//			
//			while (ix < d.length ){
//				p = new Point(ix, cy);
//				if (cy < d[0].length ) {
////					System.out.println(st.peek().getX() + " " + st.peek().getY());
//					
//					if(CheckMove(d, ix, cy)) {
//						
//						d[ix][cy] = 1;
//						st.push(p);
//						count++;
//						cy = 0;
//						
//						cy++;
//						break;
//					}
////					cy++;
//					System.out.println(cy);
//					
//				} else {
//					if(!st.isEmpty()) {
//						p = st.pop();
//						
//						d[ix][p.getY()] = 0;
//						ix = p.getX();
//						cy = p.getY() +1;
//						count--;
//						
//					}else {
//						break;
//					}
//				}
//				
////				if (cy != d[0].length) {
////					break;
////				} else if(!CheckMove(d, ix, cy)){
////				 p = st.pop();
////				 d[ix][cy] = 0;
////				 count--;
////
////				}
////				cy++;
//			}
//			
//			
//		}
//
////		for(int i = 0; i < d.length; i++) {
////			for(int j = 0; j < d[0].length; j++) {
////				if(count >= 8) { // 퀸이 모두 배치되어있으면 루프 탈출
////					break;
////				}else if(CheckMove(d, i, j)) { // 퀸을 놓을 수 있는지 검사 후 스택에 푸쉬
////					p = new Point(i, j);
////					count++;
////					d[i][j] = 1;
////					st.push(p);
////				}
////				
////				
////			}
////		}
//
//
////		System.out.println("count : "+ count);
//		
//	}

	public static boolean checkRow(int[][] d, int crow) {
		//배열 d에서 crow에 Queen을 놓을 수 있나?
		
		for(int i = 0; i < d.length; i++) {
			if(d[crow][i] == 1) {
				return false;
			}
		}
		
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		//배열 d에 ccol 열에 배치 할 수 있나? 있다면 true 아니면 false
		for(int i = 0; i < d[0].length; i++) {
			if(d[i][ccol] != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int x, int y) { //x++, y-- or x--, y++ where 0<= x,y <= 7 (/로 check)
		//배열 d에 d[cx][cy]의 SW대각선에 배치 가능하냐?
		
		int cx = x, cy = y;
		while(cx >= 0 && cx < d.length && cy >= 0 && cy < d.length) {
			if(d[cx][cy] == 1) return false;
			cx++; cy--;
		}
		cx = x; cy = y;
		while(cx >= 0 && cx < d.length && cy >= 0 && cy < d.length) {
			if(d[cx][cy] == 1) return false;
			cx--; cy++;
		}
		
		
//		for(int i = 0; i < d[0].length; i++) {
//			if(d[cx++][cy--] != 0 || cx > 0 || cy < 7) {
//				return false;
//			}
//		}
//		for(int i = 0; i < d[0].length; i++) {
//			if(d[cx--][cy++] != 0 || cx > 0 || cy < 7) {
//				return false;
//			}
//		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int x, int y) {//x++, y++ or x--, y-- (\로 check)

		int cx = x, cy = y;
		while(cx >= 0 && cx < d.length && cy >= 0 && cy < d.length) {
			if(d[cx][cy] == 1) return false;
			cx++; cy++;
		}
		cx = x; cy = y;
		while(cx >= 0 && cx < d.length && cy >= 0 && cy < d.length) {
			if(d[cx][cy] == 1) return false;
			cx--; cy--;
		}
		
		//		for(int i = 0; i < d[0].length; i++) {
//			if(d[cx--][cy++] != 0 || cx > 0 || cy < 7) {
//				return false;
//			}
//		}
//		for(int i = 0; i < d[0].length; i++) {
//			if(d[cx++][cy--] != 0 || cx > 0 || cy < 7) {
//				return false;
//			}
//		}
		return true;
	}
    public static boolean checkMove(int[][]d, int x, int y) {//(x,y)로 이동 가능한지를 check
    	if(checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y)) {
    		return true;
    	}else {
    		return false;
    	}
    }
    public static int nextMove(int[][]d, int row) {//다음 row에 대하여 이동할 col을 조사
    	for(int i = 0; i < d.length; i++) {
    		if(checkMove(d, row, i)) {
        		return i;
        	}
    	}
    	
    	return -1;
    }
	public static void main(String[] args) {
		int row = numberQueens, col = numberQueens;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
		
	}
}


