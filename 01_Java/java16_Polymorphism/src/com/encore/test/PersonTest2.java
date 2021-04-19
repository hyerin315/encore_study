package com.encore.test;

import com.encore.child.Manager;
import com.encore.child.Students;
import com.encore.parent.Person;
import com.encore.util.MyDate;

public class PersonTest2 {
	public static void main(String[] args) {
		//��� x
		Students s11 =  new Students("Student1", new MyDate(2000, 2, 2), "NY", "Date A");
		Students s22 =  new Students("Student2", new MyDate(1999, 3, 2), "NY", "Python");
		Students s33 =  new Students("Student3", new MyDate(2000, 11, 2), "Texas", "AI");
		Manager m11 =  new Manager("Manager1", new MyDate(1980, 1, 2), "Texas", "Marketing", 1500000, 300000);
		
//		Students[ ] sarr = {s11, s22, s33, m11};
		//�迭�� ����� �������� : Same Data Type --> m11�� Students Ÿ�� �ƴ�
		//Same Data Type --> Homogeneous Collection �������� �ݷ���
		//Encore Academy ���忡���� ����� �����ϱ� ������ �ڵ尡 ���� �� �ۿ� ����
		//��? Homogeneous Collection�̱� ������
		
		/////////////////////////////////////////////////////////////////////////////////////
		//���
		
		Person s1 =  new Students("Student1", new MyDate(2000, 2, 2), "NY", "Date A");
		Person s2 =  new Students("Student2", new MyDate(1999, 3, 2), "NY", "Python");
		Person s3 =  new Students("Student3", new MyDate(2000, 11, 2), "Texas", "AI");
		Person m1 =  new Manager("Manager1", new MyDate(1980, 1, 2), "Texas", "Marketing", 1500000, 300000);
		
		Person[ ] parr = {s1, s2, s3, m1};//Same Data Type�� �������鼭 --> Heterogeneous Collection
		//Encore Academy ���忡���� ����� �����ϱ� ȿ������ �ڵ尡 ���´�
		
		for(Person p : parr) System.out.println(p);//�������̵� �� toString�� �ڵ����� ��µ�

	}
}
