package com.encore.oop;
//사람에 대한 정보를 저장하는 클래스...
/*
 * 클래스를 구상...다른 말로 설계할 때 
 * 클래스를 이루는 구성요소
 * 1) 필드(멤버 변수) : 값이 저장되는 공간
 * 2) 메소드 : 정의 
 */
public class Person {
	//필드 선언 : 데이터 타입 + 필드명;
	//필드는 반드시 클래스 바로 아래 선언 == 메소드{} 바깥에 선언된다
	public String name;
	public int age;
	public String address;
	
	//메소드 정의 : 선언부 + 구현부 
	public void getPersonInfo() {//선언부
		System.out.println(name+","+age+","+address);//구현부
	}
	
	//필드에 값을 할당하는 기능을 추가로 정의...일관성을 맞춰서 이름을 짓게 되면 정확도, 가시성이 높아짐.
	//Get은 받아오고(read) Set은 주입하는 것(write)
	//로컬변수와 필드의 이름이 동일할 때 필드 앞에 this를 붙여서 구분해준다 -- this.이름 이 클래스 자기자신의 참조를 따라 가서 필드로 가게됨
	public void setPersonInfo(String name, int age, String address) {//로컬변수 -- 메소드 안에서 깔짝거리겠다
		this.name = name;
		this.age = age;
		this.address = address;
		//n, a, adrr로 이름 지으면 정보를 담지 않은 네이밍은 좋지 않음 simple < detail
	}
	
	
	
	
	
	
}//class
