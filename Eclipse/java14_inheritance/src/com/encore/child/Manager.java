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
	
	//Method Overriding
	/*
	 * �ݵ�� ��Ӱ��迡 �ִ� 2���� Ŭ�������� �߻��ϴ� �����̴�.
	 * 1) �θ� ���� ���� �״�� ���� �޴´�
	 * 2) �װ� �ٽ� ��ģ��
	 * 
	 * <<����>>
	 * ����δ� ������
	 * �����δ� �޶�������
	 * �޼ҵ��� ����� �ٽ� ������ �� ����Ѵ�
	 * 1. �޼ҵ� ����δ� ��� ��ġ�Ѵ�.
	 * 2. �޼ҵ��� �����δ� �ݵ�� �޶�����.
	 * --> �޼ҵ��� �ϴ� ���� �޶�����...���ο� �޼ҵ尡 �ٽ� ���������...�� �ǹ̷� �޼ҵ� ������ 
	 */
	//getDetails()�� �� �� ������...�ڽ��� ����� �ƴ϶� �θ��� ����� ����ϰ� �ȴ�.
	//�ȶ��� �ڽĵ��� �����޵� ����� �ڽſ��� �´� ������ �ٽ� ���Ľ���Ѵ�.
/*	public String getDetails() {
		return super.getDetails()+" , "+ dept;//getDetails�� �������� private���� ���� �������� �� �� �ֵ��� super�� �ٿ�����Ѵ�.
	} */
	
	public String toString() {
		//�ּҰ��� ��Ʈ������ ����...�� ����� �ڽĿ��� �°� ���ľ���...�ʵ尪�� �����ϴ� ������� �ٲ�
		return super.toString()+" , "+dept;
	}
	
/*	public Manager(String name, MyDate birthDate, double salary, String dept) {
	//������ �θ�����ڰ� ȣ��Ǿ���� --> Employee();
	super(name, birthDate, salary);//�θ� ����Ű�� �� super(); --> super();�� ��������� �� �ƴ϶� �Բ� ������ ����� �ʱ�ȭ�� �Բ� �̷����
	this.dept = dept;
}  */


}

