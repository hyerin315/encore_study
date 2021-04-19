package com.encore.util;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		super();
		//상위 클래스를 호출하는 키워드 --> 현재 상속 관계의 상위 클래스가 없음 --> 모든 클래스는 Object의 자식 클래스 --> 자식이 형성되면 무조건 부모인 Object를 호출하는 것
		//Object의 메소드가 다 들어와 있는 것
		this.year = year;
		this.month = month;
		this.day = day;
	}
	/*
	 * 상속관계의 2개의 클래스(부모-Object, 자식-MyDate)에서 작용하는 기능
	 * 1. 부모가 가진 기능을 물려 받고 --> 선언부는 완전히 일치
	 * 2. 그 기능을 자식이 고쳐서 사용하는 것을 말한다 (무조건 필드를 리턴하도록 나옴 --> 주소값은 쓸 곳이 별로 없음(심지어 가상의 주소값임))
	 *    --> 구현부는 달라진다(주소값이 아닌 필드 리턴)
	 *::
	 *
	 */
	@Override
	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
	//Overloading -- 상속과는 아무런 관계없이 하나의 클래스에서 일어나는 작용
	public void toString(String message) {
		System.out.println(message);
	}
	public void toString(int grade) {
		System.out.println(grade+"");
	}
	

}
