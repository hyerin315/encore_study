package com.encore.oop.test;

import com.encore.oop.Person;

public class PersonTest {

	public static void main(String[] args) {//calling method --> JVM이 main을 찾는데 JVM이 main();을 해줌
		Person p = new Person();//디폴트(인자값이 없다)로 기본생성자 호출 --> null, 0, null값인 사람 생성
		Person p2 = new Person("호호", 22, "방배동");//명시적 생성자, 인자값이 없다. 에러나는 이유는 Person에서 받을 수 있는 게 없음
		
		p.setPersonInfo("하하", 22, "신당동");//그리고 새로운 값을 주입
		p.getPersonInfo();
		
		p2.getPersonInfo();

	}

}
