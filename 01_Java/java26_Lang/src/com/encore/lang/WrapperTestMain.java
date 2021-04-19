package com.encore.lang;

public class WrapperTestMain {

	public static void main(String[] args) {
		//���� ���
		//Object[] arr = {"aaa", 10, 3.14}; <-- auto boxing
		//for(Object o : arr) {
		//   System.out.println(o); <--auto unboxing
	   //}
		
		//������(����)
		Object[] arr = {"aaa", new Integer(10), new Float(3.14)};
		String a = (String) arr[0];
		int b = ((Integer)arr[1]).intValue();
		float c = ((Float)arr[2]).floatValue();
		
		System.out.println("a:" + a + ", b:" + b + ", c :" + c);
		
		//Integer.parseInt Ȱ��
		String n1 = "123";
		String n2 = "456";
		int num1 = Integer.parseInt(n1);//���ڿ��� �ִ� ���ڸ� int�� ��ȯ, Float.parsFloat()
		int num2 = Integer.parseInt(n2);
		
		System.out.println("n1+n2:"+(n1+n2));
		System.out.println("num1+num2:"+(num1+num2));
	}
}
