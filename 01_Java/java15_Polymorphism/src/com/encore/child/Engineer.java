package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Engineer extends Employee{
	private double bonus;
	private String tech;

	public Engineer(String name, MyDate birthDate, double salary, double bonus, String tech) {
		super(name, birthDate, salary);//super는 부모를 의미하는 키워드, 메소드 앞에도 붙을 수 있음
		this.bonus = bonus;
		this.tech = tech;
	}
	
    public String getDetails() {
		return super.getDetails()+" , "+tech+", "+bonus;
	}	
}

