package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

//Employee�� �⺻ �����ڰ� ���ǵǾ� ���� ������ ������ ��
public class Manager extends Employee{//�θ�� ���� ���� ���� --> ���
	private String dept;
	
	public Manager(String name, MyDate birthDate, double salary, String dept) {
		super(name, birthDate, salary);//super�� �θ� �ǹ��ϴ� Ű����, �޼ҵ� �տ��� ���� �� ����
		this.dept = dept;
	}
	//�߰�
    public String getDept() {
		return dept;
	}
	public void changeDept(String dept) {
		this.dept = dept;
	}

	public String getDetails() {
		return super.getDetails()+" , "+ dept;//getDetails�� �������� private���� ���� �������� �� �� �ֵ��� super�� �ٿ�����Ѵ�.
	}
    
}

