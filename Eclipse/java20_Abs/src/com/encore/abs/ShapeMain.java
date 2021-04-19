package com.encore.abs;
//도형의 좌표
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
	public String toString() {//객체 설명 메서드 - 타입(클래스 풀네임), 참조값
		return "(" + x + "," + y + ")";//(3,4)
	}
}


//도형 클래스
abstract class Shape {//추상화 한 이유 : 그리는 메소드는 하위에서 상세화 --> 상속받는 곳에서 그리는 형태로 다양하게 상속받아 구현할 수 있도록 해준 것
	protected Point[] pts;//배열의 이름만 선언, 아직 배열 공간 만들지 않음
	public abstract void draw();
}


//1. 원
class Circle extends Shape {
	private int r;

	public Circle(int r, Point p) {//중심점 좌표 매개변수로 받은 것을 멤버 pts에 담으시오
		this.r = r;
		pts = new Point[1];
		pts[0] = p;
	}

	@Override
	public void draw() {
		System.out.println("중심점: "+ pts[0] + ", 반지름 :"+ r + "에 원그림");
	}
}


//2. 삼각형
class Triangle extends Shape{//삼각형은 좌표 3개 필요
//  방법 1)	
	public Triangle(Point p1, Point p2, Point p3) {
		pts = new Point[3];
		pts[0] = p1;
		pts[1] = p2;
		pts[2] = p3;
	}
	
//  방법 2)
	public Triangle(Point[] arr) {
		pts = arr;
	}
	@Override
	public void draw() {
		for(Point p : pts) {//객체를 하나씩 뽑아 넣어줌
			System.out.println(p+"  /  ");
		}   System.out.println("삼각형 그림");
	}
}


//3. 사각형
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
		}   System.out.println("사각형 그림");
	}
}


//메인 메소드
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
