package com.encore.lang;

class Point implements Cloneable {//���� ����� �Ǵ� Ŭ������ Cloneable �������̽� ��ӹ޾ƾ� ��
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class CloneTestMain {
	public static void main(String[] args) {
		Point p1 = new Point(1,2);
		Point p2 = new Point(p1.x,p1.y);//���� ���縦 ���� ���� --> �ٸ� ���ο� �޸𸮸� �Ҵ�޾Ƽ� ���� ������ �������
		Point p3 = null;
		
		try {
			 p3 = (Point) p1.clone();//clone()���� ���� ����
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Point p4 = p1;//���� ���� --> �ּҰ� ������ ���뵵 ����
		
		System.out.println("p1.x: " + p1.x + ", p1.y: " + p1.y);
		System.out.println("p2.x: " + p2.x + ", p2.y: " + p2.y);
		System.out.println("p3.x: " + p3.x + ", p3.y: " + p3.y);
		System.out.println("p4.x: " + p4.x + ", p4.y: " + p4.y);

	}
}
