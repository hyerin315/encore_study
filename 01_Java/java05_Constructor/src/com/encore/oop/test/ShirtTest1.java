package com.encore.oop.test;

import com.encore.oop.Shirt;
/*
 * Test Ŭ������ �ϴ� ��
 * �����ϴ� Ŭ����...main()
 * 1. �޸𸮿� �ø��� == ��ü ����(new)== Shirt�� �ı����� �޸𸮿� �ö󰣴�
 * 2. ����...�޼ҵ� ȣ��  --> �̶� ��ü�� ����Ű�� ����(��������)�� ���ؼ� �۾��� �����Ѵ�.
 *
 */

public class ShirtTest1 {
	public static void main(String[] args) {
		//1. Shirt�� �ı��� �޸𸮿� �ø��� == ��ü ����
		Shirt shirt = new Shirt(); //�޸� �ö�
		
		//2. ��� (����, ȣ��)
		shirt.setShirt("����Ű", true, 'Y', 4.5F);//�ʵ忡 ���� �Ҵ�
		System.out.println("========== Shirt Information===========");
		System.out.println(shirt.getShirt()); //shirt. == shirt Ŭ������ --> shirt Ŭ������ �ִ� �޼ҵ忡�� ��ȯ(return)�� ���� ��
		shirt.printShirtInfo(); //Shirt.java���� ��ȯ���� ���

	}
}
