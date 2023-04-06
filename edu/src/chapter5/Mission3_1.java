package chapter5;

public class Mission3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		int i = 0;
		
		for(int a =2023; ; a++) {
			if(a % 4 ==0 && a % 100 != 0) {
				arr[i++] = a;
				System.out.println(arr[i]);
			}else if (a % 4 ==0 && a % 100 == 0 && a % 400 == 0) {
				arr[i++] = a;
				System.out.println(arr[i]);
			}
			
			if(i == 10)
				break;
		}
		
		
	}

}
