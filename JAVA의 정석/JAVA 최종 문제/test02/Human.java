package com.test02;

public class Human {
	String name;
	int age;
	int height;
	int weight;
	
	Human(){}
	Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d  %d  %d", name, age, height, weight);
	}
	
	public String getName() {
		return name;
	}
	
	public int getInt() {
		return age;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
