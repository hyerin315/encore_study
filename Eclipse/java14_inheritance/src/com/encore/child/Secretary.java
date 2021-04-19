package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Secretary extends Employee{
	private String bossOfName;

	public Secretary(String name, MyDate birthDate, double salary, String bossOfName) {
		super(name, birthDate, salary);//super�� �θ� �ǹ��ϴ� Ű����, �޼ҵ� �տ��� ���� �� ����
		this.bossOfName = bossOfName;
	}
	
	
/*	public String getDetails() {
		return super.getDetails()+" , "+bossOfName;//getDetails�� �������� private���� ���� �������� �� �� �ֵ��� super�� �ٿ�����Ѵ�.
	} */
	
	public String toString() {
		//�ּҰ��� ��Ʈ������ ����...�� ����� �ڽĿ��� �°� ���ľ���...�ʵ尪�� �����ϴ� ������� �ٲ�
		return super.toString()+" , "+bossOfName;
	}
}

