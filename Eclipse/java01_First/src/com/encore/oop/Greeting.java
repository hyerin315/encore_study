package com.encore.oop;

/*
 * Greeting 클래스는 인사말을 콘솔창에 출력하는 클래스
 */

public class Greeting {
	//인삿말을 저장할 수 있는 공간을 하나 만들어준다 = 변수
	//변수는 값이 저장되는 공간
	public String greet;
	public String toYou;

	public void sayHello() {
		System.out.println(toYou+", "+greet);
	
	}
}
