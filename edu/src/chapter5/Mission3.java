package chapter5;

public class Mission3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2023년 이후 윤년 10개를 찾아 배열에 저장 후 출력
		// 4로 나누어 떨어지는 해는 윤년, 그 밖의 해는 평년
		// 4로 나누어 떨어져도 100으로 나누어지고 떨어지면 평년
		// 4로 나누어 떨어져도 100으로 나누어 떨어지지만 400으로 나누어 떨어지면 윤년
		
		int[] year = new int[40]; // 윤년을 저장 할 배열
		int yearTemp = 2023; // 2023년 이후부터 윤년을 찾기 위한 변수 
		int index = 0; // 배열의 값을 참조하기 위한 변수
		
		while(true) { // 무한루프를 이용해서 윤년인지 판단하여 배열 저장
			
			if(index >= year.length) { // year 배열의 마지막 값이 있으면 무한루프 종료 
				break;
			}
			
			if( yearTemp % 4 == 0 ) { // 윤년이면 배열에 저장
				if( yearTemp % 100 == 0) { // 4로 나누어 떨어져도 100으로 나누어 떨어지면 평년
					if( yearTemp % 400 == 0) { // 4로 나누어 떨어지고 100으로 나누어 떨어지지만 400으로 나누어 떨어져서 윤년
						year[index] = yearTemp;
						index++;
						yearTemp++;
						continue;
					}	
					yearTemp++;
					continue;
				}
				year[index] = yearTemp;
				index++;
			}
			
			yearTemp++;
		}
		
		for(int i = 0; i < year.length; i++) { // 저장한 배열의 값 출력
			System.out.println(year[i]);
		}
		
	}

}
