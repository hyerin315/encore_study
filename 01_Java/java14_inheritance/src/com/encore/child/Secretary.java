package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Secretary extends Employee{
	private String bossOfName;

	public Secretary(String name, MyDate birthDate, double salary, String bossOfName) {
		super(name, birthDate, salary);//super는 부모를 의미하는 키워드, 메소드 앞에도 붙을 수 있음
		this.bossOfName = bossOfName;
	}
	
	
/*	public String getDetails() {
		return super.getDetails()+" , "+bossOfName;//getDetails의 인지값이 private으로 묶여 있음으로 쓸 수 있도록 super을 붙여줘야한다.
	} */
	
	public String toString() {
		//주소값을 스트링으로 리턴...이 기능을 자식에게 맞게 고쳐쓴다...필드값을 리턴하는 기능으로 바꿈
		return super.toString()+" , "+bossOfName;
	}
}

