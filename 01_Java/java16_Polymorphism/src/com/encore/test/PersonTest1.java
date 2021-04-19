package com.encore.test;

import com.encore.child.Manager;
import com.encore.child.Students;
import com.encore.parent.Person;
import com.encore.util.MyDate;

/*
 * PolyMorphism
 * �ϳ��� Ÿ������ --- Super Type
 * �������� ��ü�� �����ϴ� ��� --- Sub Classes Creating
 */
public class PersonTest1 {
	public static void main(String[] args) {
		//�θ�Ÿ������ �ڽ��� �����
		Person s1 =  new Students("Student1", new MyDate(2000, 2, 2), "NY", "Date A");
		Person s2 =  new Students("Student2", new MyDate(1999, 3, 2), "NY", "Python");
		Person s3 =  new Students("Student3", new MyDate(2000, 11, 2), "Texas", "AI");
		Person m1 =  new Manager("Manager1", new MyDate(1980, 1, 2), "Texas", "Marketing", 1500000, 300000);
		
		//�������������� ��ü�� �����ϸ� �Ʒ� �ΰ��� ��ȭ�� �ݵ�� �����ؾ� �մϴ�
		//1. Manager1�� �μ��� IT �μ��� �����Ͻð� �ٽ� ������ Ȯ���ϼ��� -- Object Casting
		((Manager) m1).changeDept("IT");//�Ŵ������� ã��!!!
		
		//2. ���� ��ü�� ��� ������ ����ϼ��� -- Virtual Method(������ �޼ҵ� --> �ڽ� �޼ҵ� ȣ��) Invocation 
		/*
		 * ��Ӱ��迡�� �������̵��� �޼ҵ忡���� ��Ÿ���� �����̴�.
		 * Person s = New Student();
		 * 1) Compile ������ Method - �θ��� �޼ҵ带 ȣ�� : toString()
		 * 2) Runtime(����) ������ Method - �ڽ��� �޼ҵ带 ȣ�� : toString() 
		 *    --> �θ𲨸� ���� ��µ� �θ�� �ڽ��� �̾��� �ֱ� ������ ������������� ������ �ڽ��� �޼ҵ� ȣ��(�̷���)
		 *    
		 * 		System.out.println(m1.getDept());//�̰� �Ŵ������� �޼ҵ��� --> �ڽĸ��� �޼ҵ��̱� ������ ȣ���� �ȵ�
		 *      �׷���  System.out.println((Manager)m1).getDept()); �ؾ��ϴµ� �̰� �ٷ� Object Casting
		 */
		System.out.println(s1);//.toString�� �����Ǿ� ����
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(m1);
		


	}
}
