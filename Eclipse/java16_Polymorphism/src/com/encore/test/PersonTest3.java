package com.encore.test;

import com.encore.child.Manager;
import com.encore.child.Students;
import com.encore.parent.Person;
import com.encore.service.PersonService;
import com.encore.util.MyDate;

public class PersonTest3 {
	public static void main(String[] args) {		
		Person s1 =  new Students("Student1", new MyDate(2000, 2, 2), "NY", "Date A");
		Person s2 =  new Students("Student2", new MyDate(1999, 3, 2), "NY", "Python");
		Person s3 =  new Students("Student3", new MyDate(2000, 11, 2), "Texas", "AI");
		Person m1 =  new Manager("Manager1", new MyDate(1980, 1, 2), "Texas", "Marketing", 600, 100);
		Person m2 =  new Manager("Manager2", new MyDate(1981, 1, 2), "Texas2", "Marketing2", 600, 100);
		Person m3 =  new Manager("Manager3", new MyDate(1982, 1, 2), "Texas3", "Marketing3", 600, 100);
		
		Person[ ] arr = {s1,s2,s3,m1,m2,m3};
//		PersonService service = new PersonService();
		PersonService service = PersonService.getInstance();
		
		//1~4�������� �޼ҵ带 ���� -> �̰����� ȣ���ؼ� �ϼ�
		System.out.println("===1. ��� ������ ����մϴ�.===");
		Person[ ] parr = service.getAllPerson(arr);
		for(Person p : parr) System.out.println(p);
		
		System.out.println("===2. �̸����� ����� �˻��մϴ�.===");
		Person p = service.findPersonByName(arr,"Manager3");
		System.out.println(p);
		
		System.out.println("===3. �̸����� ����� �˻��մϴ�.===");
		int annualSalary = service.getAnnualSalary(arr, m1);
		System.out.println(annualSalary+"����");
		
		System.out.println("===4. ���� ��ü ����� ��ȯ�մϴ�.===");
	    int totalCost = service.getTotalCost(arr);
		System.out.println(totalCost+"����");

	}
}
