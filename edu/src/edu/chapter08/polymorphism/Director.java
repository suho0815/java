package edu.chapter08.polymorphism;

public class Director extends Manager {
	@Override
	public void calcBonus() {
		// TODO Auto-generated method stub
		System.out.println("Manager 보너스 = 기본급 * 12 * 6");
	}
}