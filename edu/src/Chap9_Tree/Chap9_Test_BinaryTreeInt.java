package Chap9_Tree;
/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;


//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode() {
		LeftChild = RightChild = null;
	}
	
	public TreeNode(int data) {
		this.data = data;
		LeftChild = RightChild = null;
	}
	
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() { //중위 순회(inorder traversal) left -> root -> right
		inorder(root);
	}

	void preorder() { //전위 순회 root -> left -> right
		preorder(root);
	}

	void postorder() { //후위 순회 left -> right -> root
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
		TreeNode temp = new TreeNode(x); 
		TreeNode p = root;
		
		if(root == null) {
			root = temp;
			return true;
		}
		
		while (p != null) {
			if( x < p.data) {
				if(p.LeftChild == null) {
					p.LeftChild = temp;
					return true;
				}
				p = p.LeftChild;
			}else {
				if(p.RightChild == null) {
					p.RightChild = temp;
					return true;
				}
				p = p.RightChild;
			}
		}
		
		return false;
	}

	boolean delete(int num) {

		TreeNode q = null; // p의 이전노드
		TreeNode p = root; 

		//leaf node 삭제
		//child가 1개인 노드 삭제
		//child가 2개인 노드 삭제
		if (p == null) {
			return false;
		}
		do {
			if(p.data == num) { //삭제할 노드 찾으면
				if (isLeafNode(p)) { // leafNode 인 경우
					if(q.RightChild == p) {
						q.RightChild = null;
					}else if(q.LeftChild == p) {
						q.LeftChild = null;
					}
					return true;
				}else if (p.LeftChild != null && p.RightChild != null) { //child가 2개인 노드
					//{
					TreeNode temp = inorderSucc(p);
					p.data = temp.data;
//					if (isLeafNode(temp)) {
//						//temp를 삭제
//						temp = null;
//						return true;
//					} 
//					else {
//						//non-leaf를 삭제하는 코딩
//						while(true) {
//							p = temp;
//							temp = inorderSucc(p);
//							p.data = temp.data;
//							if(isLeafNode(temp)) {
//								temp = null;
//								return true;
//							}
//							
//						}
//					}
					
					q = p;
		            p = p.RightChild;
		            num = temp.data;
		            continue;
				}
				else { //child가 1개인 노드
					if(p.LeftChild != null) {
						p = p.LeftChild; 
					}else {
						p = p.RightChild;
					}
					
					if(q == null) { //root를 삭제해야 하면?
						root = p;
					}else if (q.LeftChild != null && q.LeftChild.data == num) {
						q.LeftChild = p;
					}else if ( q.RightChild.data == num) {
						q.RightChild = p;
					}
					
					return true;
				}
				
			}
			q = p;
			if(num < p.data) {
				p = p.LeftChild;
			}else {
				p = p.RightChild;
			}
			
		}while(p != null);
		
		
		return false;
	}

	boolean search(int num) {
		TreeNode p = root;
		
		do {
			if(p.data == num) {
				return true;
			}
			
			if(num < p.data) {
				p = p.LeftChild;
			}else {
				p = p.RightChild;
			}
			
		}while(p != null);
		
		return false;
	}
}

public class Chap9_Test_BinaryTreeInt {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num) == true)
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
