package com.encore.parent;

import com.encore.util.MyDate;

/*
 * Super Class...
 * 
 * VO Class �ۼ�
 * 1. �ʵ� ����
 * 2. ������
 * 3. setter()/getter()
 * 4. toStrnig() �������̵�
 */
public class Person {
	private String name;
	private MyDate birthDate;
	private String adress;
	

	public Person(String name, MyDate birthDate, String adress) {
		super();//�ʵ� �ʱ�ȭ �ϱ� ������ ���� �θ� �����ؾ��Ѵ�. (�θ� �ȸ�������µ� ��� �ڽ��� ä����!)
		this.name = name;
		this.birthDate = birthDate;
		this.adress = adress;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}


	@Override
	public String toString() {
		return name + ", " + birthDate + ", " + adress;//MyDate���� toString�� �߱� ������ bithDate.toString ���ص� ��
	}
}
