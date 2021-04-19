package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.parent.Employee;
import com.encore.util.MyDate;
/*
 * �θ� Ÿ������ �ڽ� ��ü�� �����ϸ� �߻��ϴ� ������
 * Object Casting���� �ذ��Ѵ�
 */

public class PolyMorphismTest1 {
	public static void main(String[] args) {
		Employee e = new Employee("Employee", new MyDate(1999,1,1), 20000.0);
		Employee m = new Manager("James", new MyDate(1990,2,1), 20000.0, "���ߺ�");
		Employee eg = new Engineer("Engineer", new MyDate(1985,3,1), 30000.0, 100.0, "Java");
		
		//James�� �μ��� ���ߺο��� �����η� ����
		//m.change("������");
		//--> Employee�� Ÿ������ �Ŵ����� �ö󰬱� ������ Employee���� changeDept�� �����Ƿ�
		//    Employee�� �ƴ϶� Manager���� ã���� �ҷ�����Ѵ� --> Object Casting
		//ĳ���� ���� ()m; --> ()���� ã��!!!
		/*1) 
		 * Manager m1 = (Manager)m;
		   m1.changeDept("������"); */
		//2)
		((Manager) m).changeDept("������");//�ϳ��ϳ� �߰��ϸ鼭 �ڵ鸵���� �ʱ� ���� Test2.Topic ���
		
		System.out.println(e.getDetails());
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());

	}

}
