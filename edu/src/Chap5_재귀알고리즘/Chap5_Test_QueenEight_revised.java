
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
	
	public int push(Point x) throws OverflowIntStackException {
		if(top >= capacity) {
			throw new OverflowIntStackException();
		}
		data.add(x);
		return top++;
	}
	
	public Point pop() throws EmptyIntStackException {
		if(top <= 0) {
			throw new EmptyIntStackException();
		}
		//Point p = data.get(top--);
		Point p = data.remove(top-1);
		top--;
		return p;
	}
	
	public Point peek() throws EmptyIntStackException {
		if(top <= 0) {
			throw new EmptyIntStackException();
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

	public static void SolveQueen(int[][] d) {
		int count = 0;
		int ix = 0, iy = 0;
		Stack3 st = new Stack3(10);
		Point p = new Point(ix, iy);
		d[ix][iy] = 1;
		count++;
		st.push(p);
		
		while (count < 8) {
			ix++;
			int cy = 0;
			boolean queenPlaced = false;
			while (ix < d.length ){
				p = new Point(ix, cy);
				if (cy < d[0].length ) {
//					System.out.println(st.peek().getX() + " " + st.peek().getY());
					
					if(CheckMove(d, ix, cy)) {
						
						d[ix][cy] = 1;
						st.push(p);
						count++;
//						cy = 0;
						queenPlaced = true;
//						cy++;
						break;
					}
					cy++;
//					System.out.println(cy);
					
				} else {
					if(!st.isEmpty()) {
						p = st.pop();
						
						d[ix][p.getY()] = 0;
						ix = p.getX();
						cy = p.getY() +1;
						count--;
						queenPlaced = true;
					}else {
						break;
					}
				}
				
//				if (cy != d[0].length) {
//					break;
//				} else if(!CheckMove(d, ix, cy)){
//				 p = st.pop();
//				 d[ix][cy] = 0;
//				 count--;
//
//				}
//				cy++;
			}
			if (!queenPlaced) {
	            if (!st.isEmpty()) {
	                p = st.pop();
	                ix = p.getX();
	                cy = p.getY() + 1;
	                d[ix][p.getY()] = 0;
	                count--;
	            } else {
	                // All possibilities have been explored, and no more queens can be placed
	                break;
	            }
	        }
			
		}

//		for(int i = 0; i < d.length; i++) {
//			for(int j = 0; j < d[0].length; j++) {
//				if(count >= 8) { // 퀸이 모두 배치되어있으면 루프 탈출
//					break;
//				}else if(CheckMove(d, i, j)) { // 퀸을 놓을 수 있는지 검사 후 스택에 푸쉬
//					p = new Point(i, j);
//					count++;
//					d[i][j] = 1;
//					st.push(p);
//				}
//				
//				
//			}
//		}


		
		
	}

	public static boolean checkRow(int[][] d, int crow) {
		for(int i = 0; i < d[0].length; i++) {
			if(d[crow][i] != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		for(int i = 0; i < d[0].length; i++) {
			if(d[i][ccol] != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int cx, int cy) { //x++, y-- or x--, y++ where 0<= x,y <= 7 (/로 check)
		for(int i = 0; i < d[0].length; i++) {
			if(d[cx++][cy--] != 0 || cx >= 0 || cy <= 7) {
				return false;
			}
		}
		for(int i = 0; i < d[0].length; i++) {
			if(d[cx--][cy++] != 0 || cx >= 0 || cy <= 7) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int cx, int cy) {//x++, y++ or x--, y-- (\로 check)
		for(int i = 0; i < d[0].length; i++) {
			if(d[cx--][cy++] != 0 || cx >= 0 || cy <= 7) {
				return false;
			}
		}
		for(int i = 0; i < d[0].length; i++) {
			if(d[cx++][cy--] != 0 || cx >= 0 || cy <= 7) {
				return false;
			}
		}
		return true;
	}
    public static boolean CheckMove(int[][]d, int x, int y) {//(x,y)로 이동 가능한지를 check
    	if(checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y)) {
    		return true;
    	}else {
    		return false;
    	}
    }
    public static boolean NextMove(int[][]d, int row, int col) {//다음 row에 대하여 이동할 col을 조사
    	if(CheckMove(d, row, col)) {
    		return true;
    	}
    	
    	return false;
    }
	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[8][8];
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


