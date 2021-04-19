package com.encore.oop;
/*
 * Constructor?
 * 객체가 생성될 때마다 구동하는 것
 * 
 * 생성자
 * 1. 기본생성자    Person(){]
 *    인자값이 없고 구현부에서 아무말도 하지 않는 생성자...Nothig Working
 *    생상자의 A.M는 클래스를 따라간다
 *    개발자가 다른 생성자(?)를 넣어주지 않으면 컴파일러가 기본 생성자를 대신 넣고 코드를 돌린다
 *    하나의 클래스에는 반드시 하나 이상의 생성자가 존재한다
 *    
 * 2. 명시적 생성자 
 *    인자값이 하나 이상인 생성자
 *    필드 초기화
 *    명시적 생성자가 하나라도 있으면 컴파일러가 기본 생성자를 넣어주지 않는다
 */
/*
 * 클래스 모듈을 작성할 때 필수적으로 들어가야하는 것들
 * 1. 필드를 잘 선택해서 선언한다.
 * 2. 값을 주입한다.
 *    값이 주입되는 통로
 *    - setter (방법2)
 *    - constructor(생성자) : 어떤 사물이 생성될 때 함께 생성되는 것을 생성자로 (방법1)
 * 3. 주입된 값을 받아온다.
 * 
 */

public class Person {

	public String name;
	public int age;
	public String address;
	
	
	//public Person() --> 지정되지 않았을 때 자동으로 만들어주지만, 우리가 명시적 생성자를 하나라도 만들었다면 기본 생성자도 만들어줘야함
	public Person() {}
	//아래는 메소드 아님, return타입이 없음
	//방법 1. 명시적 생성자 생성
	public Person(String name, int age, String address) {//Passing Into...인자값의 갯수, 타입, 순서 정확해야함 
		this.name = name;
		this.age = age;
		this.address = address;
		
	}
	public void getPersonInfo() {
		System.out.println(name+","+age+","+address);
	}
	
	//방법2. 메소드 작성
	public void setPersonInfo(String name, int age, String address) {//메소드는 void라는 리턴타입이 아닌 리턴타입이 있거나 return이 있어야함
		this.name = name;
		this.age = age;
		this.address = address;

	}
	
	
	
	
	
	
}
