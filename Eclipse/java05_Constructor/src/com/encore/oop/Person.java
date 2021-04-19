package com.encore.oop;
/*
 * Constructor?
 * ��ü�� ������ ������ �����ϴ� ��
 * 
 * ������
 * 1. �⺻������    Person(){]
 *    ���ڰ��� ���� �����ο��� �ƹ����� ���� �ʴ� ������...Nothig Working
 *    �������� A.M�� Ŭ������ ���󰣴�
 *    �����ڰ� �ٸ� ������(?)�� �־����� ������ �����Ϸ��� �⺻ �����ڸ� ��� �ְ� �ڵ带 ������
 *    �ϳ��� Ŭ�������� �ݵ�� �ϳ� �̻��� �����ڰ� �����Ѵ�
 *    
 * 2. ����� ������ 
 *    ���ڰ��� �ϳ� �̻��� ������
 *    �ʵ� �ʱ�ȭ
 *    ����� �����ڰ� �ϳ��� ������ �����Ϸ��� �⺻ �����ڸ� �־����� �ʴ´�
 */
/*
 * Ŭ���� ����� �ۼ��� �� �ʼ������� �����ϴ� �͵�
 * 1. �ʵ带 �� �����ؼ� �����Ѵ�.
 * 2. ���� �����Ѵ�.
 *    ���� ���ԵǴ� ���
 *    - setter (���2)
 *    - constructor(������) : � �繰�� ������ �� �Բ� �����Ǵ� ���� �����ڷ� (���1)
 * 3. ���Ե� ���� �޾ƿ´�.
 * 
 */

public class Person {

	public String name;
	public int age;
	public String address;
	
	
	//public Person() --> �������� �ʾ��� �� �ڵ����� �����������, �츮�� ����� �����ڸ� �ϳ��� ������ٸ� �⺻ �����ڵ� ����������
	public Person() {}
	//�Ʒ��� �޼ҵ� �ƴ�, returnŸ���� ����
	//��� 1. ����� ������ ����
	public Person(String name, int age, String address) {//Passing Into...���ڰ��� ����, Ÿ��, ���� ��Ȯ�ؾ��� 
		this.name = name;
		this.age = age;
		this.address = address;
		
	}
	public void getPersonInfo() {
		System.out.println(name+","+age+","+address);
	}
	
	//���2. �޼ҵ� �ۼ�
	public void setPersonInfo(String name, int age, String address) {//�޼ҵ�� void��� ����Ÿ���� �ƴ� ����Ÿ���� �ְų� return�� �־����
		this.name = name;
		this.age = age;
		this.address = address;

	}
	
	
	
	
	
	
}
