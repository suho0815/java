package edu.chapter07;

public class Employee extends Person {

	private String dept;

	public Employee() {
		System.out.println("Employee 생성자가 생성되었습니다.");
	}
	
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		// 부모 Person클래스의 필드가 private이므로 getter를 가져와서 사용
		return "Employee [name=" + getName() + ", age=" + getAge() + ", dept=" + dept + "]";
	}
	
}
