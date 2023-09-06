package com.test05;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
		HashMap<Integer, Employee> map = new HashMap<>();
		Secretary e1 = new Secretary("홍길동", 1, "Secretary", 800);
		Sales e2 = new Sales("이순신", 2, "Sales", 1200);
		map.put(e1.number, e1);
		map.put(e2.number, e2);
		
		System.out.println("name             department     salary");
		System.out.println("---------------------------------------");
		for(int key : map.keySet()) {
			System.out.println(map.get(key));
		}
		
		System.out.println("\n");
		e1.incentive(100);
		e2.incentive(100);
		System.out.println("인센티브 100지급\n\n");
	    
		System.out.println("name             department     salary       tax");
		System.out.println("---------------------------------------");
		for(int key : map.keySet()) {
			System.out.println(map.get(key));
		}
		
		
	}
}
