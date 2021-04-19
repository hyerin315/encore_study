package com.encore.lang;

public class StringTest2Main {

	public static void main(String[] args) {
		
		//split(������):�����ڸ� �������� ���ڿ��� �ɰ��� �迭�� ��Ƽ� ��ȯ(�ɰ��� �������ϱ�) --> �����ڴ� , / �ƹ��ų�, ���ڵ� ����
		String a = "aaa, bbb, ccc, ddd";//���ڿ��� ���� a ����
		String[] b = a.split(",");
		for(String s : b) {
			System.out.println(s);
		}

		String c = b[0].concat(b[1]);//���ڿ��� ����
		System.out.println(c);
		
		
		//statWith : �Ű����� ���ڿ��� ���۵Ǹ� true, �ƴϸ� false
		if(a.startsWith("aa")) {//a�� �ǰ�, aaa�� �� -> ��� �ش��ϱ� ����
			System.out.println("���ڿ��� aa�� ������");
		}
		
		//endWith : �Ű����� ���ڿ��� ������?
		if(a.endsWith("ddd")) {
			System.out.println("���ڿ��� ddd�� ����");
		}
		
		char x = a.charAt(5);//�Ű����� ��ġ�� ���� �ϳ��� ��ȯ
		System.out.println("a�� 5��° ��ġ ���ڴ� "+x);

		if(a.contains("b,c")) {//�Ű������� �����ϳ�?
			int idx = a.indexOf("b,c");//������ ��ġ�� ����? - �Ű����� ���ڿ��� ��ġ�� ��ȯ
			System.out.println("a�� ���� b,c�� "+idx+"��ġ�� ����");
		}
	}
}
