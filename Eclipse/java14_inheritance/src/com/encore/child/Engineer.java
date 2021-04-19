package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Engineer extends Employee{
	private double bonus;
	private String tech;

	public Engineer(String name, MyDate birthDate, double salary, double bonus, String tech) {
		super(name, birthDate, salary);//super�� �θ� �ǹ��ϴ� Ű����, �޼ҵ� �տ��� ���� �� ����
		this.bonus = bonus;
		this.tech = tech;
	}
	
	
/*	public String getDetails() {
		return super.getDetails()+" , "+bonus+", "+tech;//getDetails�� �������� private���� ���� �������� �� �� �ֵ��� super�� �ٿ�����Ѵ�.
	} */
	
	public String toString() {
		//�ּҰ��� ��Ʈ������ ����...�� ����� �ڽĿ��� �°� ���ľ���...�ʵ尪�� �����ϴ� ������� �ٲ�
		return super.toString()+" , "+bonus+", "+tech;
	}
}

