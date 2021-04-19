package com.encore.parent;
/*
 * Overloading
 * ::
 * 이름은 같지만(동일한 기능이다)
 * 처리하는 데이터를 달리하는 기법
 * ::
 * 1) 생성자 오버로딩
 *    --> 생성자 이름은 같지만 처리하는 데이터가 다르다
 *        최소한의 기본값으로 일단 객체 생성을 가능하게 하는 기법
 *        나머지 값들은 추후에 다시 할당되어질 수 있다
 * 2) 메소드 오버로딩 
 * ::
 * this 사용법
 * 1) 변수명 앞에 this - 필드와 로컬변수의 이름이 같을때 이 2개를 구분하기 위해서 필드명 앞에 지정한다
 * 2) this() 생성자 앞의 this 용도 - 하나의 클래스 안에서 또 다른 생성자를 호출하는 기능
 */

import com.encore.util.MyDate;

public class Employee {
	//상수값으로 기본 salary값을 하나 설정
	public static final double BASE_SALARY = 100.0;
	private String name;
	private MyDate birthDate;
	private double salary;
	
	//생성자 오버로딩은 왜 사용하는가?
	/*생성자는 여러개의 인자값을 가지고 인자값이 만들어지는데 
	어떤 Employee가 salary에 대한 인자값이 없을 경우, 그래도 객체 생성이 되도록 만들어야함
	*/
	public Employee() {}//이게 없으면 자식 super();에서 오류남
	public Employee(String name, MyDate birthDate, double salary) {
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}//this 키워드 : 필드명이랑 로컬변수 이름이 똑같을 때 구분을 위해 필드명 앞에 this를 붙인다(해당하는 객체의 참조값을 의미)

    public Employee(String name) {//이름만 가지고 객체를 만들어야하는 경우
		this(name, new MyDate(2000, 1, 1), BASE_SALARY);//this를 만나면 이 클래스 안에서 또 다른 생성자 호출 -> 28라인으로 감 (왜? 인자값이 3개이므로) / 생일이랑 연봉은 기본값으로 넣어준 것
	}//이때 this는 생성자 
	
	public Employee(String name, MyDate birthDate) {
	   this(name, birthDate, BASE_SALARY);//28라인으로 감 (기입하지 않은 것 --> 필요한 값은 기본값으로 넣어줌) --> 이때 상수값을 잘 활용해줘야함
	}

/*	public String getDetails() {
		return name+", "+birthDate+", "+salary;
	} */
	
	public String toString() {
		return name+", "+birthDate+", "+salary;
	}

}
