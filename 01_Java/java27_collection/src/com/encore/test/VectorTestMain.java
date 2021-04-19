package com.encore.test;

import java.util.Vector;
class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}

public class VectorTestMain {

	public static void main(String[] args) {
		//������
		// Vector<String> v = new Vector<>(); �̷��� ��� ���� --> �׷��� �̷��� �ϸ� String ���� �޾ƾ��ؼ� ������
		// ������Ʈ �Ǹ鼭 �� �ᵵ ��
		Vector v = new Vector();//�� ����, ���� ����, ũ�� ���� �ص� �ǰ� ���ص� �� (ũ�������ص� �ʱⰪ�ϻ� �����͸� �ʰ��ؼ� ���� �� �ִ� == �Ÿ� ū���� �̻簨)
		v.add("asdf");//add(). ���� ������ �߰�
		v.add(3.45f);
		v.add(10);
		v.add(new Point(1,2));
		v.add(1, "test");//1���濡 �־��ִµ�, ���� ���� ����°� �ƴ϶� �ؽ�Ʈ�� ���� �ִ� �� (���� ������ �� ĭ�� �̵��ϴ� ��)
		
		System.out.println("�������� ��: "+ v.size());
		System.out.println("���� ��: "+ v.capacity());
		for(int i = 0; i < v.size(); i++) {//size(): ����� ������ ���� 
			System.out.println(v.get(i));//get(i): i��° ���� �� ����
		}
	}
}
