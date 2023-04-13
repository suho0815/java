package edu.chapter08.polymorphism;

public class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}

	@Override
	public void calcBonus() {
		// TODO Auto-generated method stub
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}