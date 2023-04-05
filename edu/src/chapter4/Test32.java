package chapter4;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = new int[5];
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
//		
//		for(int i=0; i<5; i++) {
//			System.out.println(arr[i]);
//		}
		
		int[] arr = new int[5];
		int i = 0;
		arr[0] = 10;
		for(i = 1; i < 5; i++) {
			arr[i] = arr[i-1] + 10;
		}

		int j = 0;
		for(j = 0; j < 5; j++) {
			System.out.println(arr[j]);
		}
		
	}

}
