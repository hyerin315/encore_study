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
	//추가
    public String getDept() {
		return dept;
	}
	public void changeDept(String dept) {
		this.dept = dept;
	}

	public String getDetails() {
		return super.getDetails()+" , "+ dept;//getDetails의 인지값이 private으로 묶여 있음으로 쓸 수 있도록 super을 붙여줘야한다.
	}
    
}

