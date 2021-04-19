package com.encore.service;
/*
 * �� Ŭ������ �̱������� �����ϰ�
 * ~Test Ŭ�������� ��ü ���� ��ſ� ������ ��ü�� �޾ƿͼ� ����ϴ� �ڵ�� ����
 */
import com.encore.child.Manager;
import com.encore.parent.Person;

public class PersonService {
	//�̱������� ����
	private static PersonService service = new PersonService();
	private PersonService() {}
	public static PersonService getInstance() {
		return service;
	}


	//1. ��� ������ ����ϴ� ���
	public Person[ ] getAllPerson(Person[ ] parr) {
		Person[ ] all = new Person[parr.length];
		int idx = 0;
		for(Person p : parr) all[idx++] = p; 
		
		return all;
	}
	
	//2. �̸����� ��� �˻��ϱ�...�̸��� �ߺ� ��� �ȵȴ�
	public Person findPersonByName(Person[ ] parr, String name) {
		Person person = null;
		for(Person p : parr) 
			if(p.getName().equals(name)) person = p;
		
		return person;
	}
	
	//3. Ư���� ����� ������ ��ȯ
	public int getAnnualSalary(Person[ ] parr, Person p) {
		int annualSalary = 0;
		for(Person per : parr) {
			if(per instanceof Manager) {
				annualSalary = ((Manager) per).getSalary() * 12 + ((Manager) per).getBonus();
			}
		}
		return annualSalary;
	}
	
	//4. �� �ΰǺ�
	public int getTotalCost(Person[ ] parr) {
		int total = 0;
		for(Person p : parr) {
			if(p instanceof Manager) 
				total += getAnnualSalary(parr, p);
			}
		return total;
	}
}
