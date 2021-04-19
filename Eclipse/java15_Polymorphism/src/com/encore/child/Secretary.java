package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Secretary extends Employee{
	private String bossOfName;

	public Secretary(String name, MyDate birthDate, double salary, String bossOfName) {
		super(name, birthDate, salary);//super는 부모를 의미하는 키워드, 메소드 앞에도 붙을 수 있음
		this.bossOfName = bossOfName;
	}
	
	
    public String getDetails() {
		return super.getDetails()+" , "+bossOfName;
	} 

}

