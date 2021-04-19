package com.encore.test;

import java.util.ArrayList;

//ArrayList : �Ϲ����� ��Ȳ������ Vector���� '������ ������' ���� (���������� ���� ������ ����ȭ �����൵ ��)
//Vector : ���ÿ� ���������� ���� ��Ȳ������ Vector�� ���� �� ����

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();//Vector�� ���� ����������, ������ ����ȭ�� ����
		list.add("aaa");
		list.add("bbb");
		list.add(0, "ccc");
		list.add(0, "ddd");//set(): ����
		
		
		System.out.println("��ü ���");
		for(String s : list) {//get()���� ���� ����
			System.out.println(s);
		}
		
		if(list.contains("bbb")) {//list�� �Ű������� ������ ���� ������ true, ������ false
			System.out.println(list.indexOf("bbb")+" �� ����");//indexOf(): �Ű����� ���� �ִ� ���� �ε��� ��ȯ
		} else {
			System.out.println("����");
		}
		
		list.remove(1);//1�ݺ� ����
		list.remove("ddd");//�Ű������� ���� ���� ������ ��ü�� ã�Ƽ� ����
		
		//remove(), contain(), indexOf()�� equals() ��ü�� �� --> �ּҰ� ã�Ƽ� ��
		
		if(list.isEmpty()) {//isEmty(): list�� ������� true, �ƴϸ� false
			System.out.println("��ü ���");
			for(String s : list) {//get()���� ���� ����
				System.out.println(s);
			}
		}
	}
}
