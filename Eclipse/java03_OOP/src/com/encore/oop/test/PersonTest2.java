//문제 해결

package com.encore.oop.test;

import com.encore.oop.Person;

public class PersonTest2 {
	public static void main(String[] args) {
		//1. 객체 생성
		Person p1 = new Person();
		Person p2 = new Person();
		
		//2. 값 할당
		p1.setPersonInfo("강호동", 44, "신사동");
		p2.setPersonInfo("이수근", 40, "여의도");

		//3. 메소드 호출
		p1.getPersonInfo();
		p2.getPersonInfo();
		
		
	}
}
