package com.encore.lang;

public class StringTestMain {

	public static void main(String[] args) {
		String a = "aaa";//���ڿ� ���(==�ּҰ����� ����) -- ���� 10, 3.14�� ���� �̼��ε�, ���ڿ��� ��� => ���� ���� ��� ������ �����(text����)
		String b = new String("aaa");//Heap���ٰ� ���ڸ� ���� ��
		char[] d = {'a', 'b', 'c'};//�ϳ��ϳ� ���� �͵��� d�� ����
		String c = new String(d);//�ϳ��� ��Ʈ������ �����
		String e = a;//��� ������ �ִ� ���� �״�� ����
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);

		System.out.println("a==b: "+(a==b));
		System.out.println("a.equals(b) : " +a.equals(b));//�ּӰ��� ���� �ٸ�
		
		System.out.println("a==e: "+(a==e));
		System.out.println("a.equals(e) : " +a.equals(e));
		
		String x = b + c;//���ڿ������� ���ϱ�� ���� �� ���� ����
		//b�� c�� ������ �ʰ�, �� �޸𸮿� �Ҵ� �޾� b�� c�� ������ ���ο� ���ڿ��� �����ϰ� �� �������� x�� �Ҵ�
		System.out.println(x);
		
	}
}
