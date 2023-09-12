package com.test03;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestMain03 {

	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		
		StringTokenizer st = new StringTokenizer(str,",");
		List<Double> list = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			list.add(Double.parseDouble(st.nextToken()));
		}
		
		
		double tot = 0; 
		double avg = 0;
		for(double li : list) {
			tot += li;
		}
		System.out.printf("합 계: %.3f\n", tot);
		System.out.println("평 균: " + Math.round(tot / list.size() * 1000)/ 1000.0 );
	}

}
