package com.encore.child;

import com.encore.parent.Person;
import com.encore.util.MyDate;

public class Students extends Person{
	private String course;

	public Students(String name, MyDate birthDate, String adress, String course) {
		super(name, birthDate, adress);//Person
		this.course = course;
	}

	public String getcourse() {
		return course;
	}
	public void setCource(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return super.toString()+", "+ course;
		//1. 부모의 것을 물려받는다
		//2. 자식의 것을 추가한다
	}
}
