package com.encore.oop.test;

import com.encore.oop.Person;

public class PersonTest {

	public static void main(String[] args) {//calling method --> JVM�� main�� ã�µ� JVM�� main();�� ����
		Person p = new Person();//����Ʈ(���ڰ��� ����)�� �⺻������ ȣ�� --> null, 0, null���� ��� ����
		Person p2 = new Person("ȣȣ", 22, "��赿");//����� ������, ���ڰ��� ����. �������� ������ Person���� ���� �� �ִ� �� ����
		
		p.setPersonInfo("����", 22, "�Ŵ絿");//�׸��� ���ο� ���� ����
		p.getPersonInfo();
		
		p2.getPersonInfo();

	}

}
