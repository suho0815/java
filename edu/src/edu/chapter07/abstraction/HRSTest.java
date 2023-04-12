package edu.chapter07.abstraction;


abstract class Employee {
	private String name;
	private int salary; //기본급
	
	public Employee() {
		this(null, 0);
	}
	
	public Employee(String name) {
		this(name, 0);
	}
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	//미완성 클래스 상속받은 자식 클래스에서 반드시 완성해야하는 메서드
	public abstract void calcSalary();
	public abstract void calcBonus();
}

class Salesman extends Employee{
	
	
	// 생성자
	public Salesman() {
		this(null, 0);
	}
	
	public Salesman(String name) {
		this(name, 0);
	}
	
	public Salesman(String name, int salary) {
		super(name, salary);
	}
	
	public void calcSalary() {
		 
//		System.out.println(String.format("%10s", getName())+ "급여 : %d " + );
		System.out.println(String.format(" "));
		System.out.println(String.format("%8s : %5d","기본급", getSalary()));
		
		
	}
	public void calcBonus() {
		System.out.println( getName() + " 보너스 = 기본급 * 12 * 4");
	}
}

class Consultant extends Employee {
	
	
	
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}
}

abstract class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
	
}

class Director extends Manager {
	public void calcBonus() {
//		System.out.println("Director 보너스 = 기본급 * 12 * 6");
		
	}
}

public class HRSTest {
	public static void main(String[] args) {
		Salesman s = new Salesman("홍길동", 300);
		Consultant c = new Consultant();
		Director d = new Director();

		s.calcSalary();
		
//		s.calcBonus();
//		c.calcBonus();
//		
//		d.calcSalary();
//		d.calcBonus();
	}
}
