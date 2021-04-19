package com.encore.inter;
interface InterA {
	default void init() {
	//�������̽��� ���� �߻� �޼ҵ�, ������ ���� Ŭ�������� ���� �����ϰ� ���� ���� �ؾ�������
	//�����ϰ� �����ϴ� �͵��� default ó�����ָ� ���� Ŭ�������� �⺻������ default�� �ް� ��
		System.out.println("�� �������̽��� ��ӹ޴� Ŭ�����鿡�� �⺻������ �����ϴ� �޼ҵ�");
	}
	
	//JDK 9 ���� �̻�
//	private void do_something_inner() {	- private�� ���� Ŭ���� ��������	
//       System.out.println("Inner job");
//	}
	
	void do_something();
	
	static void static_method() {//�������̽��� ��ӹ޴� ��ü�� �����Ǳ� ������ ��� ����
		System.out.println("static method");
	}
}

class classA implements InterA {//�������̽��� ��� ������, ��ӹ��� ��� �޼ҵ�� �����ؾ��� --> ���� �ٸ��� ���� 

	@Override
	public void do_something() {
		System.out.println("classA�� do_something");
		//do_something_inner();
		
	}
	
}

class classB implements InterA {

	@Override
	public void do_something() {
		System.out.println("classB�� do_something");
		//do_something_inner();
	}
	
}

public class InterDefaultTest {

	public static void main(String[] args) {
		classA a = new classA();
		a.init();
		a.do_something();
		
		classB b = new classB();
		b.init();
		b.do_something();
		
		InterA.static_method();//�������̽� ��ü���� ��� ����, Ȯ�� �Ұ���
	}

}
