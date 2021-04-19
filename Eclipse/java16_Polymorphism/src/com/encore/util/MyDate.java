package com.encore.util;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		super();
		//���� Ŭ������ ȣ���ϴ� Ű���� --> ���� ��� ������ ���� Ŭ������ ���� --> ��� Ŭ������ Object�� �ڽ� Ŭ���� --> �ڽ��� �����Ǹ� ������ �θ��� Object�� ȣ���ϴ� ��
		//Object�� �޼ҵ尡 �� ���� �ִ� ��
		this.year = year;
		this.month = month;
		this.day = day;
	}
	/*
	 * ��Ӱ����� 2���� Ŭ����(�θ�-Object, �ڽ�-MyDate)���� �ۿ��ϴ� ���
	 * 1. �θ� ���� ����� ���� �ް� --> ����δ� ������ ��ġ
	 * 2. �� ����� �ڽ��� ���ļ� ����ϴ� ���� ���Ѵ� (������ �ʵ带 �����ϵ��� ���� --> �ּҰ��� �� ���� ���� ����(������ ������ �ּҰ���))
	 *    --> �����δ� �޶�����(�ּҰ��� �ƴ� �ʵ� ����)
	 *::
	 *
	 */
	@Override
	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
	//Overloading -- ��Ӱ��� �ƹ��� ������� �ϳ��� Ŭ�������� �Ͼ�� �ۿ�
	public void toString(String message) {
		System.out.println(message);
	}
	public void toString(int grade) {
		System.out.println(grade+"");
	}
	

}
