package edu.chapter08.polymorphism;

public class HRSTest {

    public static void calcTax(Employee e) {
        System.out.println("소득세를 계산합니다.");
    }

    public static void main(String[] args) {
//        Salesman s = new Salesman();
//        Consultant c = new Consultant();
//        Director d = new Director();

//        calcTax(s);
//        calcTax(c);
//        calcTax(d);
        
//        System.out.println(s.toString());
//        System.out.println(c.toString());
//        System.out.println(d.toString());
//        
//        Salesman s2 = s;
//        System.out.println(s2.toString());
//        
//        if(s.equals(s2)) {
//        	System.out.println("동일한 객체입니다.");
//        }else {
//        	System.out.println("서로 다른 객체입니다.");
//        }
        
    	Salesman s1 = new Salesman();
    	Employee s2 = new Salesman();
    	Object s3 = new Salesman();
    	
    	Object m1 = new Manager();
    	Employee m2 = new Manager();
    	Manager m3 = new Manager();
    	//Director m4 = new Manager();
    	
    	Object arr[] = new Object[6];
    	arr[0] = s1;
    	arr[1] = s2;
    	arr[2] = s3;
    	arr[3] = m1;
    	arr[4] = m2;
    	arr[5] = m3;
        
    	for(int i = 0; i < arr.length; i++) {
    		System.out.println(arr[i]);
    	}
    	
    }
}
