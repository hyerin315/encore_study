//���� �ذ�

package com.encore.oop.test;

import com.encore.oop.Person;

public class PersonTest2 {
	public static void main(String[] args) {
		//1. ��ü ����
		Person p1 = new Person();
		Person p2 = new Person();
		
		//2. �� �Ҵ�
		p1.setPersonInfo("��ȣ��", 44, "�Ż絿");
		p2.setPersonInfo("�̼���", 40, "���ǵ�");

		//3. �޼ҵ� ȣ��
		p1.getPersonInfo();
		p2.getPersonInfo();
		
		
	}
}
