package com.test02;

import java.util.ArrayList;
import java.util.List;

public class TestStudent {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
	
		list.add(new Student("홍길동", 20, 177, 74, "201301", "체육"));
		list.add(new Student("이순신", 44, 178, 77, "201302", "체육"));
		list.add(new Student("유관순", 18, 155, 45, "201303", "컴퓨터"));
		
		for(Student li : list) {
			System.out.println(li);
		}
	}

}
