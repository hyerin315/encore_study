package com.encore.abs;
//������ ��ǥ
class Point {
	private int x;
	private int y;
	
	public Point() {}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {//��ü ���� �޼��� - Ÿ��(Ŭ���� Ǯ����), ������
		return "(" + x + "," + y + ")";//(3,4)
	}
}


//���� Ŭ����
abstract class Shape {//�߻�ȭ �� ���� : �׸��� �޼ҵ�� �������� ��ȭ --> ��ӹ޴� ������ �׸��� ���·� �پ��ϰ� ��ӹ޾� ������ �� �ֵ��� ���� ��
	protected Point[] pts;//�迭�� �̸��� ����, ���� �迭 ���� ������ ����
	public abstract void draw();
}


//1. ��
class Circle extends Shape {
	private int r;

	public Circle(int r, Point p) {//�߽��� ��ǥ �Ű������� ���� ���� ��� pts�� �����ÿ�
		this.r = r;
		pts = new Point[1];
		pts[0] = p;
	}

	@Override
	public void draw() {
		System.out.println("�߽���: "+ pts[0] + ", ������ :"+ r + "�� ���׸�");
	}
}


//2. �ﰢ��
class Triangle extends Shape{//�ﰢ���� ��ǥ 3�� �ʿ�
//  ��� 1)	
	public Triangle(Point p1, Point p2, Point p3) {
		pts = new Point[3];
		pts[0] = p1;
		pts[1] = p2;
		pts[2] = p3;
	}
	
//  ��� 2)
	public Triangle(Point[] arr) {
		pts = arr;
	}
	@Override
	public void draw() {
		for(Point p : pts) {//��ü�� �ϳ��� �̾� �־���
			System.out.println(p+"  /  ");
		}   System.out.println("�ﰢ�� �׸�");
	}
}


//3. �簢��
class Rectangle extends Shape{
        public Rectangle(Point p1, Point p2) {
        	pts = new Point[2];
        	pts[0] = p1;
    		pts[1] = p2;
	}
	@Override
	public void draw() {
		for(Point p : pts) {
			System.out.println(p+"  /  ");
		}   System.out.println("�簢�� �׸�");
	}
}


//���� �޼ҵ�
public class ShapeMain {

	public static void main(String[] args) {
		Shape[] arr = {new Circle(10, new Point(100, 100)), new Triangle(new Point(1,2),new Point(3,4),new Point(5,6)), 
				new Rectangle(new Point(7,8), new Point(100,100)), 
				new Triangle(new Point[] {new Point(10,20),new Point(30,40),new Point(50,60)}),
				new Circle(50, new Point(300,300))};
		
		for(Shape s:arr) {
			s.draw();
		}
	}
}
