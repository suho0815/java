package Chap8_List;

/*
 * 정수 리스트 > 객체 리스트 > 
 */
import java.util.Comparator;
import java.util.Scanner;


class SimpleObject2 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?
	String no; // 회원번호
	String name; // 이름

	public SimpleObject2(String sno, String sname) {
		this.no = sno;
		this.name = sname;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임 
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}
	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject2> {
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : ((d1.no.compareTo(d2.no) < 0)) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject2> {
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.name.compareTo(d2.name) > 0) ? 1 : ((d1.name.compareTo(d2.name) < 0)) ? -1 : 0;
		}
	}
}

class Node4 {
	SimpleObject2 data; // 데이터
	Node4 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
	Node4 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)

	// --- 생성자(constructor) ---//
	Node4(SimpleObject2 so) {
		this.data = so;
		llink = rlink = this;
	}
	Node4() {
		this.data = null;
		llink = rlink = this;
	}
	Node4(String sno, String sname) {
		data = new SimpleObject2(sno, sname);
		llink = rlink = this;
	}
	public int compareNode(Node4 n2) {
		SimpleObject2 so1 = this.data;
		if (SimpleObject2.NO_ORDER.compare(so1, n2.data) < 0) return -1;
		else if (SimpleObject2.NO_ORDER.compare(so1, n2.data) > 0)return 1;
		else return 0;
	}
}

class DoubledLinkedList2 {
	private Node4 first; // 머리 포인터(참조하는 곳은 더미노드)

// --- 생성자(constructor) ---//
	public DoubledLinkedList2() {
		first = new Node4(); // dummy(first) 노드를 생성
		
	}

// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		return first.rlink == first;
	}

// --- 노드를 검색 ---//
	public boolean search(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 pre = first;
		
		do{
			if(c.compare(pre.data, obj) == 0 ) {
				return true;
			}
			pre = pre.rlink;
		}while(pre != null);
		
		return false;
	}

// --- 전체 노드 표시 ---//
	public void show() {
		Node4 pre = first;
		
		if (this.isEmpty()) {
	        return;
	    }
		
		do{
			System.out.println(pre.data.toString());
			pre = pre.rlink;
		}while (pre != null);
		
	}

// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 nd = new Node4(obj);
		Node4 p = first, q = null;
	
		if(p.data == null) { // 첫번째에 노드를 삽입해야 하면 삽입 후 종료
			first = nd;
			nd.rlink = null; //첫 노드 이므로 자기자신을 가르킴
			nd.llink = null;
			return;
		}
		// 중간에 노드를 삽입
		// element가 더 크면 다음 노드로 이동
		while (p.rlink != null && c.compare(p.data, obj) < 0) {
	        q = p;
	        p = p.rlink;
	    }

        // 삽입할 위치를 찾았을 때
	    if (c.compare(p.data, obj) >= 0) { 
	        nd.rlink = p;
	        p.llink = nd;
	        if (q != null) { //이전 노드가 있으면
	            q.rlink = nd;
	            nd.llink = q;
	        } else { // 이전 노드가 없으면 (노드가 제일 앞쪽에 배치되어야 할 경우)
	            first = nd; 
	        }
	    } else { // 마지막에 노드를 삽입할 때
	        p.rlink = nd;
	        nd.llink = p;
	        nd.rlink = null;
	    }

	}

// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 pre = first; //노드 앞
		Node4 ptr = first; //뒤
		
		while (pre != null) {
			//첫 번째 일 때
			if (c.compare(first.data, obj) == 0) {
				first = pre.rlink;
				System.out.println("삭제된 데이터 : " + pre.data.toString());
				return;
			}
			// 중간일 때
			if(c.compare(pre.data, obj) == 0 && pre.rlink != null) {
				pre.rlink.llink = pre.llink;
				ptr.rlink = pre.rlink;
				System.out.println("삭제된 데이터 : " + pre.data.toString());
				return;
			}
			//마지막 일 때		
			if(c.compare(pre.data, obj) == 0 && pre.rlink == null) {
				pre.llink = null;
				ptr.rlink = null;
				System.out.println("삭제된 데이터 : " + pre.data.toString());
				return;
			}
			ptr = pre;
			pre = pre.rlink;
		}
		
		System.out.println("삭제할 데이터를 찾지 못하였습니다.");
	}
	
	
	public DoubledLinkedList2 merge(DoubledLinkedList2 lst2) {
		DoubledLinkedList2 lst3 = new DoubledLinkedList2();
		
		Node4 pre = first;
		
		do{
			lst3.add(pre.data, SimpleObject2.NO_ORDER);
			pre = pre.rlink;
		}while (pre != null);
		
		pre = lst2.first;
		
		do{
			lst3.add(pre.data, SimpleObject2.NO_ORDER);
			pre = pre.rlink;
		}while (pre != null);
		
		return lst3;
	}
}

public class 객체이중리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("병합"), Exit("종료");

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
		Scanner sc1 = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc1.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Linked List");
		DoubledLinkedList2 lst1 = new DoubledLinkedList2(), lst2 = new DoubledLinkedList2(),lst3 = new DoubledLinkedList2();
		String sno1 = null, sname1 = null;
		SimpleObject2 so;
		boolean result = false;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				System.out.println(" 회원번호: ");
				sno1 = sc2.next();
				System.out.println(" 회원이름: ");
				sname1 = sc2.next();
				so = new SimpleObject2(sno1, sname1);
				lst1.add(so, SimpleObject2.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
				System.out.println(" 삭제할 회원번호: ");
				sno1 = sc2.next();
				System.out.println(" 삭제할 회원이름: ");
				sname1 = sc2.next();
				so = new SimpleObject2(sno1, sname1);
				lst1.delete(so, SimpleObject2.NO_ORDER);
				break;
			case Show: // 꼬리 노드 삭제
				lst1.show();
				break;
			case Search: // 회원 번호 검색
				System.out.println(" 검색할 회원번호: ");
				sno1 = sc2.next();
				System.out.println(" 검색할 회원이름: ");
				sname1 = sc2.next();
				so = new SimpleObject2(sno1, sname1);
				result = lst1.search(so, SimpleObject2.NO_ORDER);
				if (result == false)
					System.out.println("검색 값 = " + so + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + so + "데이터가 존재합니다.");
				break;
			case Merge:
				for (int i = 0; i < 5; i++) {
				 System.out.println(" 두번째 리스트 회원번호: ");
				 sno1 = sc2.next();
				 System.out.println(" 두번째 리스트 회원이름: ");
				 sname1 = sc2.next();
				 so = new SimpleObject2(sno1, sname1);
				 lst2.add(so, SimpleObject2.NO_ORDER);
				 lst3 = lst1.merge(lst2);
				 System.out.println("list1: ");
				 lst1.show();
				 System.out.println("list2: ");
				 lst2.show();
				 System.out.println("list3: ");
				 lst3.show();
				}
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
