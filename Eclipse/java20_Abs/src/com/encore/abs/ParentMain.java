package com.encore.abs;
//1. 추상클래스 : 추상 메소드를 하나라도 포함한 클래스 - 객체를 만들 수 없음 
//            --> 완성을 해야지 객체 생성(상속받은 클래스에서 모든 추상메소드를 구현해야 객체 생성 가능)
//   만드는 이유   : 상속을 목적으로 하는 클래스의 메소드를 구현할 필요 없음 --> 하위 클래스에서 원하는 모양으로 구현하라
//              하위클래스의 아웃라인을 잡아줌 --> 이 추상 클래스를 상속 받으면 모둔 추상 메소드를 구현해야 객체 생성 가능,
//              그러므로 적어도 이 메소드들은 구현해야만 한다 (멤버 변수나 메소드를 더 추가하는 것은 상관없음)
//2. 추상메소드 : 구현하지 않고 프로토 타입(메소드만)만 가진 메소드 - 선언문만 적은 메소드

//메소드에서 중요한 것 - 선언부 : 반환타입, 이름, 파일리스트

abstract class Parent{//추상 메소드가 하나라도 있으면 추상 클래스 == 미원성된 메소드를 하나라도 가지고 있으면 미완성 클래스
	//기존 방법
	//void add(int a, int b); / 메소드 선언, 메소드 프로토 타입
	//void add(int a, int b) {//메소드 안에서 중괄호를 열고 닫으면 아무것도 없어도 있는 것으로 침
	//}
	
	//추상메소드
    abstract void add(int a, int b);

	public void test1() {
		System.out.println("asfd");
	}
}

class Child extends Parent{
	
	@Override
	void add(int a, int b) {//상속받지 않았다면 추상클래스
		int c = a + b;
		System.out.println(a + " + " + b + " = " + c);
	}

}

public class ParentMain {
	public static void main(String[] args) {
		//Parent p = new Parent();
		Child c = new Child();
		c.add(12, 34);
		c.test1();
		}
}