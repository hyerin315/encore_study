package com.encore.parent;

import com.encore.util.MyDate;

/*
 * Super Class...
 * 
 * VO Class 작성
 * 1. 필드 선언
 * 2. 생성자
 * 3. setter()/getter()
 * 4. toStrnig() 오버라이딩
 */
public class Person {
	private String name;
	private MyDate birthDate;
	private String adress;
	

	public Person(String name, MyDate birthDate, String adress) {
		super();//필드 초기화 하기 직전에 먼저 부모를 생성해야한다. (부모가 안만들어졌는데 어떻게 자식이 채워져!)
		this.name = name;
		this.birthDate = birthDate;
		this.adress = adress;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}


	@Override
	public String toString() {
		return name + ", " + birthDate + ", " + adress;//MyDate에서 toString을 했기 때문에 bithDate.toString 안해도 됨
	}
}
