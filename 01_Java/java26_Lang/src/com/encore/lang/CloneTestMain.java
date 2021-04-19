package com.encore.lang;

class Point implements Cloneable {//복사 대상이 되는 클래스는 Cloneable 인터페이스 상속받아야 함
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
		Point p2 = new Point(p1.x,p1.y);//깊은 복사를 직접 구현 --> 다른 새로운 메모리를 할당받아서 안의 내용을 만들어줌
		Point p3 = null;
		
		try {
			 p3 = (Point) p1.clone();//clone()으로 깊은 복사
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Point p4 = p1;//얕은 복사 --> 주소가 같으니 내용도 같음
		
		System.out.println("p1.x: " + p1.x + ", p1.y: " + p1.y);
		System.out.println("p2.x: " + p2.x + ", p2.y: " + p2.y);
		System.out.println("p3.x: " + p3.x + ", p3.y: " + p3.y);
		System.out.println("p4.x: " + p4.x + ", p4.y: " + p4.y);

	}
}
