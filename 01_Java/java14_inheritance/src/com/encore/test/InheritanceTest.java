package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.util.MyDate;
/*
 * 오류
 * 1. 생년월일이 아니라 주소값이 출력
 * 2. Manager 정보 중에서 dept 출력이 안된다. ---> Manager클래스에서  getDerails 구현부 안에 super을 붙여줘야함
 */

public class InheritanceTest {

	public static void main(String[] args) {
		Manager m1 = new Manager("James", new MyDate(1965, 2, 12), 3000000.0, "IT");
		Engineer e1 = new Engineer("Mark", new MyDate(1988, 5, 27), 2500000.0, 1500000.0, "Java");
		Secretary s1 = new Secretary("Sony", new MyDate(1985, 10, 1), 3500000.0, "James");
		
//		System.out.println(m1.toString());
//		System.out.println(e1.toString());
//		System.out.println(s1.toString());

		System.out.println(m1);
		System.out.println(e1);
		System.out.println(s1);
//		System.out.println(m1.getDetails());
	}
}
