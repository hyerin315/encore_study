package com.encore.oop;
//����� ���� ������ �����ϴ� Ŭ����...
/*
 * Ŭ������ ����...�ٸ� ���� ������ �� 
 * Ŭ������ �̷�� �������
 * 1) �ʵ�(��� ����) : ���� ����Ǵ� ����
 * 2) �޼ҵ� : ���� 
 */
public class Person {
	//�ʵ� ���� : ������ Ÿ�� + �ʵ��;
	//�ʵ�� �ݵ�� Ŭ���� �ٷ� �Ʒ� ���� == �޼ҵ�{} �ٱ��� ����ȴ�
	public String name;
	public int age;
	public String address;
	
	//�޼ҵ� ���� : ����� + ������ 
	public void getPersonInfo() {//�����
		System.out.println(name+","+age+","+address);//������
	}
	
	//�ʵ忡 ���� �Ҵ��ϴ� ����� �߰��� ����...�ϰ����� ���缭 �̸��� ���� �Ǹ� ��Ȯ��, ���ü��� ������.
	//Get�� �޾ƿ���(read) Set�� �����ϴ� ��(write)
	//���ú����� �ʵ��� �̸��� ������ �� �ʵ� �տ� this�� �ٿ��� �������ش� -- this.�̸� �� Ŭ���� �ڱ��ڽ��� ������ ���� ���� �ʵ�� ���Ե�
	public void setPersonInfo(String name, int age, String address) {//���ú��� -- �޼ҵ� �ȿ��� ��¦�Ÿ��ڴ�
		this.name = name;
		this.age = age;
		this.address = address;
		//n, a, adrr�� �̸� ������ ������ ���� ���� ���̹��� ���� ���� simple < detail
	}
	
	
	
	
	
	
}//class
