package Chap2_기본자료구조;

class PhyscData implements Comparable<PhyscData>{
	private String name;
	private int height;
	private double vision;
	
	public PhyscData(String string, int i, double d) {
		name = string;
		height = i;
		vision = d;
	}
	
	public static void showData(PhyscData[] d) {
		for(int i = 0; i < d.length; i++) {
			System.out.println("name = " + d[i].name + ", height = " + d[i].height + ", vision = " + d[i].vision);
		}
		System.out.println();
	}
	
	public static void sortData(PhyscData[] d) {
		// 오름차순 정렬
		
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				
				if(d[i].compareTo(d[j]) > 0) {
					PhyscData temp = d[i];
					d[i] = d[j];
					d[j] = temp;
				}
			}
		}
		
	}

	@Override
	public int compareTo(PhyscData o) {
		
		if(o.name.compareTo(this.name) == 0) {
			if(this.height == o.height) {
				if(this.vision == o.vision) {
					return 0;
				}else {
					return (int) (o.vision - this.vision);
				}
			}else {
				return o.height - this.height;
			}
		}else {
			return o.name.compareTo(this.name);
		}
		
	}
}
public class 과제1_2장기본자료구조 {

	public static void main(String[] args) {
		//comparable과 comparator 차이점 조사
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("김홍길동", 172, 0.5),
				new PhyscData("김홍길동", 175, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		
		PhyscData.showData(data);
		PhyscData.sortData(data);
		PhyscData.showData(data);
	}

}


