package Chap3_이진탐색;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

import java.util.Arrays;
import java.util.Comparator;

class Fruit {
	String name;
	int price;
	String expire;
	
	public Fruit(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}
	
}

public class Fruit객체배열이진탐색_Test {

	public static void main(String[] args) {
	Fruit[] arr = {
	        new Fruit("사과", 200, "2023-5-08"),  //이름, 가격, 유효기간 
	        new Fruit("키위", 500, "2023-6-08"),
	        new Fruit("오렌지", 200, "2023-7-08"),
	        new Fruit("바나나", 50, "2023-5-18"),
	        new Fruit("수박", 880, "2023-5-28"),
	        new Fruit("체리", 10, "2023-9-08")
	};
	System.out.println("정렬전 객체 배열: ");
	showData(arr);
	Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit에 compareTo()가 있어도 람다식 우선 적용
	System.out.println("람다식 정렬(가격)후 객체 배열: ");
	showData(arr);

	Arrays.sort(arr, new Comparator<Fruit>() {
		@Override
		public int compare(Fruit a1, Fruit a2) {
			return a1.getName().compareTo(a2.getName());
		}
	});
	System.out.println("comparator 정렬(이름)후 객체 배열: ");
	showData(arr);

	Comparator<Fruit> cc_name = new Comparator<Fruit>() {// 익명클래스 사용 (이름 비교)
		public int compare(Fruit f1, Fruit f2) {
			return (f1.name.compareTo(f2.name));
		}
	};
	
	Comparator<Fruit> cc_price = new Comparator<Fruit>() {// 익명클래스 사용 (가격 비교)

		@Override
		public int compare(Fruit f1, Fruit f2) {
			return (f1.price - f2.price);
		}
	};
	
	Comparator<Fruit> cc_expire = new Comparator<Fruit>() {// 익명클래스 사용 (기간 비교)

		@Override
		public int compare(Fruit f1, Fruit f2) {
			return (f1.expire.compareTo(f2.expire));
		}
	};
	
	//name 비교
	Fruit newFruit = new Fruit("체리", 500, "2023-5-18");
	int result3 = Arrays.binarySearch(arr, newFruit, cc_name);
	System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
	
	result3 = binarySearch(arr, newFruit, cc_name);
	System.out.println("\nbinarySearch() 조회결과::" + result3);

	//price 비교
	sortData(arr, cc_price);
	System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
	showData(arr);

	result3 = Arrays.binarySearch(arr, newFruit, cc_price);
	System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
	
	result3 = binarySearch(arr, newFruit, cc_price);
	System.out.println("\nbinarySearch() 조회결과::" + result3);
	
	//expire 비교
	sortData(arr, cc_expire);
	System.out.println("\ncomparator 정렬(유효기간)후 객체 배열: ");
	showData(arr);
	
	result3 = Arrays.binarySearch(arr, newFruit, cc_expire);
	System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
	
	result3 = binarySearch(arr, newFruit, cc_expire);
	System.out.println("\nbinarySearch() 조회결과::" + result3);
	
	}

	
	private static void showData(Fruit[] arr) {
		for(Fruit fruit : arr) {
			System.out.println(fruit.name + " " + fruit.price + " " + fruit.expire);
		}
		
	}
	
	private static void sortData(Fruit[] arr, Comparator<Fruit> cc_data) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr.length-i; j++) {
				if(cc_data.compare(arr[j-1], arr[j]) > 0) {
					Fruit temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}
	
	private static int binarySearch(Fruit[] arr, Fruit newFruit, Comparator<Fruit> cc_data) {
		//이진 탐색
		int pl = 0;
		int pr = arr.length -1;
		
		while(pl <= pr) {
			int pc = (pr + pl) /2;
			if(cc_data.compare(arr[pc], newFruit) == 0) {
				return pc;
			}else if(cc_data.compare(arr[pc], newFruit) < 0) {
				pl = pc+1;
			}else {
				pr = pc-1;
			}
		}
		
		return -1;
	}

}
