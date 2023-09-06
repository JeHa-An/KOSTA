package com.test04;

public abstract class Plane {
	String planeName;
	int fuelSize;
	
	Plane() {}
	Plane(String planeName, int fuelSize){
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	public String getPlaneName() {
		return planeName;
	}
	
	public int getFuelSize() {
		return fuelSize;
	}
	
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	
	public void setFuelSize(int fuelSize) {
		this.fuelSize= fuelSize;
	}
	
	@Override
	public String toString() {
		return planeName + " " + fuelSize;
	}
	public void refule(int fuel) {
		fuelSize += fuel;
	}
	abstract void flight(int distance);
}
