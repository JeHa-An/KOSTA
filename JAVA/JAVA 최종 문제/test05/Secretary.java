package com.test05;

public class Secretary extends Employee implements Bonus{
	Secretary() {}
	Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	@Override
	
	public double tax() {
		return getSalary() * 0.1;
	}
	
	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(pay * 0.8));
 	}

	public String toString() {
		return String.format("%5s %20s %10d %10.2f", name, department, salary, tax());
	}
}
