package com.encore.test;

class Test2{
	public void test1() {
		test2();//����ó�� ����
	}
	
	public void test2() {
		test3();//����ó�� ����
	}
	
	public void test3() {
		int x = 3/0;//���� �߻�
	}
}

public class Except4Main {
	public static void main(String[] args) {//������ ���������� �����ؼ� ã�´�
		Test2 t = new Test2();
		try {
			t.test1();
		} catch (ArithmeticException e) {//�ᱹ  �޼ҵ忡�� throws�� ������ �ʾƵ� ó���� ������ 
			System.out.println(e);
		}
	}
}
