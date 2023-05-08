package Chap3_이진탐색;


import java.util.Arrays;


//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;
	
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	
	@Override
	public int compareTo(PhyscData o) {
		
		if(o.name.compareTo(this.name) ==  0 ) {
			if(this.height == o.height) {
				if(this.vision == o.vision) {
					return 0;
				}else {
					return (int)(o.vision - this.vision);
				}
			}else {
				return o.height - this.height;
			}
		}else {
			return o.name.compareTo(this.name);
		}
	}

}
public class 객체배열이진탐색_Test {

	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5),
		};
		showData(data);
		sortData(data);
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);
		
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}
	
	static void showData(PhyscData[]arr) {
		System.out.println();
		for (PhyscData fruit: arr) {
			System.out.print(fruit.name+" " + fruit.height + " " + fruit.vision+" \n");
		}
		System.out.println();
	}
	
	static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				
				if(data[i].compareTo(data[j]) > 0) {
					PhyscData temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}
	
	static int linearSearch(PhyscData[] data, PhyscData key) {
		int p = 0;
		
		while(p < data.length) {
			if(data[p].compareTo(key) == 0) {
				return p;
			}
			p++;
		}
			
		return -1;
	}

	static int binarySearch(PhyscData[] data, PhyscData key) {
		int pl = 0;
		int pr = data.length -1;
		
		while(pl <= pr) {
			int pc = (pr + pl) /2;
			if(data[pc].compareTo(key) == 0) {
				return pc;
			}else if(data[pc].compareTo(key) > 0) {
				pr = pc-1;
			}else {
				pl = pc+1;
			}
		}
		
		return -1;
		
	}

	
	
}
