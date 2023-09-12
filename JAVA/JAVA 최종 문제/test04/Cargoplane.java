package com.test04;

public class Cargoplane extends Plane{
	Cargoplane() {}
	Cargoplane(String planeName, int fuelSzie){
		super(planeName, fuelSzie);
	}
	
	@Override
	void flight(int distance) {
		int cnt = distance / 10;
		setFuelSize(getFuelSize() - cnt * 50);		
	}

	
}
