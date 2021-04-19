package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

//Employee에 기본 생성자가 정의되어 있지 않으면 오류가 남
public class Manager extends Employee{//부모로 부터 물려 받음 --> 상속
	private String dept;
	
	public Manager(String name, MyDate birthDate, double salary, String dept) {
		super(name, birthDate, salary);//super는 부모를 의미하는 키워드, 메소드 앞에도 붙을 수 있음
		this.dept = dept;
	}
	
	//Method Overriding
	/*
	 * 반드시 상속관계에 있는 2개의 클래스에서 발생하는 성질이다.
	 * 1) 부모가 가진 것을 그대로 물려 받는다
	 * 2) 그걸 다시 고친다
	 * 
	 * <<문법>>
	 * 선언부는 같지만
	 * 구현부는 달라짐으로
	 * 메소들의 기능을 다시 정의할 때 사용한다
	 * 1. 메소드 선언부는 모두 일치한다.
	 * 2. 메소드의 구현부는 반드시 달라진다.
	 * --> 메소드의 하는 일이 달라진다...새로운 메소드가 다시 만들어진다...는 의미로 메소드 재정의 
	 */
	//getDetails()를 쓸 수 있지만...자식의 기능이 아니라 부모의 기능을 사용하게 된다.
	//똑똑한 자식들은 물려받되 기능을 자신에게 맞는 것으로 다시 고쳐써야한다.
/*	public String getDetails() {
		return super.getDetails()+" , "+ dept;//getDetails의 인지값이 private으로 묶여 있음으로 쓸 수 있도록 super을 붙여줘야한다.
	} */
	
	public String toString() {
		//주소값을 스트링으로 리턴...이 기능을 자식에게 맞게 고쳐쓴다...필드값을 리턴하는 기능으로 바꿈
		return super.toString()+" , "+dept;
	}
	
/*	public Manager(String name, MyDate birthDate, double salary, String dept) {
	//무조건 부모생성자가 호출되어야함 --> Employee();
	super(name, birthDate, salary);//부모를 가리키는 게 super(); --> super();만 가지고오는 게 아니라 함께 선언을 해줘야 초기화가 함께 이루어짐
	this.dept = dept;
}  */


}

