package com.test05;

public abstract class Employee {
	String name;
	int number;
	String department;
	int salary;
	
	public Employee(){}
	public Employee(String name, int number, String department, int salary){
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return String.format("%5s %20s %10d", name, department, salary);
	}
	public abstract double tax();
}
