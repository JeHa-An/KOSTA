package com.test04;

public class Airplane extends Plane{
	Airplane() {}
	Airplane(String planeName, int fuelSzie){
		super(planeName, fuelSzie);
	}
	
	@Override
	void flight(int distance) {
		int cnt = distance / 10;
		setFuelSize(getFuelSize() - cnt * 30);
	}

}
