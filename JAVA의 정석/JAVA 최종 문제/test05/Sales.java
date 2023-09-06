package com.test05;

public class Sales extends Employee implements Bonus {
	Sales() {}
	Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(pay * 1.2));
	}
	@Override
	public double tax() {
		return getSalary() * 0.13;
	}
	public String toString() {
		return String.format("%5s %20s %10d %10.2f", name, department, salary, tax());
	}
}
