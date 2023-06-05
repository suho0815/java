package Chap8_List;

/*
 * 정수 리스트 > 객체 리스트> 객체 원형 리스트
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject3 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	public SimpleObject3(String no, String name) {
		this.no = no;
		this.name = name;
	}
	public SimpleObject3() {
		this.no = null;
		this.name = null;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요." + sw);

		if ((sw & NO) == NO) { // & 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

class Node3 {
	SimpleObject3 data;
	Node3 link;

	public Node3(SimpleObject3 element) {
		data = element;
		link = null;
	}
}

class CircularList {
	Node3 first;

	public CircularList() { //head node
		first = null;
	}

	public String Delete(SimpleObject3 element, Comparator<SimpleObject3> cc) {// delete the element
		Node3 pre = first; //노드 앞
		Node3 ptr = first; //뒤
		
		while (pre != null) {
			//첫 번째 일 때
			
			if (cc.compare(first.data, element) == 0) {
				while(pre.link != first) {
					ptr = pre;
					pre = pre.link;
				}
				ptr = pre;
				pre = pre.link;
				ptr.link = first.link;
				first = ptr.link;
				return pre.data.toString();
			}
			// 중간일 때
			if(cc.compare(pre.data, element) == 0 && pre.link != first) {
				ptr.link = pre.link;
				return pre.data.toString();
			}
			//마지막 일 때		
			if(cc.compare(pre.data, element) == 0 && pre.link == first) {
				ptr.link = first;
				return pre.data.toString();
			}
			ptr = pre;
			pre = pre.link;
		}
		
		return "실패";
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node3 pre = first;
		
		if (pre == null) {
	        return;
	    }
		
		do{
			System.out.println(pre.data.toString());
			pre = pre.link;
		}while (pre != first);
		
	}

	public void Add(SimpleObject3 element, Comparator<SimpleObject3> cc) {// 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
		Node3 nd = new Node3(element);
		Node3 p = first, q = null;
		
		if(p == null) { // 첫번째에 노드를 삽입해야 하면 삽입 후 종료
			first = nd;
			nd.link = first; //첫 노드 이므로 자기자신을 가르킴
			return;
		}
		// 중간에 노드를 삽입
		// element가 더 크면 다음 노드로 이동
		while (p.link != first && cc.compare(p.data, element) < 0) {
	        q = p;
	        p = p.link;
	    }

        // 삽입할 위치를 찾았을 때
	    if (cc.compare(p.data, element) >= 0) { 
	        nd.link = p;
	        if (q != null) { //이전 노드가 있으면
	            q.link = nd;
	        } else { // 이전 노드가 없으면 (노드가 제일 앞쪽에 배치되어야 할 경우)
	        	while(p.link != first) { // 맨끝의 노드로 이동
	            	p = p.link;
	            }
	        	p.link = nd; // 맨끝 노드가 가르키는 곳을 first로  
	            first = nd; 
	        }
	    } else { // 마지막에 노드를 삽입할 때
	        p.link = nd;
	        nd.link = first;
	    }
		
	}

	public boolean Search(SimpleObject3 element, Comparator<SimpleObject3> cc) { // 전체 리스트를 순서대로 출력한다.
		Node3 pre = first;
		
		do{
			if(cc.compare(pre.data, element) == 0 ) {
				return true;
			}
			pre = pre.link;
		}while(pre != first);
		
		return false;
		
	}
}

public class 객체원형리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

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
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		System.out.println("Linked List");
		CircularList l = new CircularList();
		Scanner sc = new Scanner(System.in);
		SimpleObject3 data;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = new SimpleObject3();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject3.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
				data = new SimpleObject3();
				data.scanData("삭제", SimpleObject3.NO);
				String num = l.Delete(data, SimpleObject3.NO_ORDER);
				System.out.println("삭제된 데이터 성공은 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				data = new SimpleObject3();
				data.scanData("탐색", SimpleObject3.NO);
				boolean result = l.Search(data, SimpleObject3.NO_ORDER);
				if (result == true)
					System.out.println("검색 성공 = " + result);
				else
					System.out.println("검색 실패 = " + result);
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
