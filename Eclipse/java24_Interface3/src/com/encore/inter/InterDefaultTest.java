package com.encore.inter;
interface InterA {
	default void init() {
	//인터페이스는 완전 추상 메소드, 원래는 하위 클래스에서 각자 구현하고 싶은 것을 해야하지만
	//동일하게 들어가야하는 것들은 default 처리해주면 하위 클래스들은 기본적으로 default를 받게 됨
		System.out.println("이 인터페이스를 상속받는 클래스들에게 기본적으로 제공하는 메소드");
	}
	
	//JDK 9 버전 이상
//	private void do_something_inner() {	- private은 같은 클래스 내에서만	
//       System.out.println("Inner job");
//	}
	
	void do_something();
	
	static void static_method() {//인터페이스를 상속받는 객체가 생성되기 전에도 사용 가능
		System.out.println("static method");
	}
}

class classA implements InterA {//인터페이스를 상속 받으면, 상속받은 모든 메소드들 구현해야함 --> 각자 다르게 구현 

	@Override
	public void do_something() {
		System.out.println("classA의 do_something");
		//do_something_inner();
		
	}
	
}

class classB implements InterA {

	@Override
	public void do_something() {
		System.out.println("classB의 do_something");
		//do_something_inner();
	}
	
}

public class InterDefaultTest {

	public static void main(String[] args) {
		classA a = new classA();
		a.init();
		a.do_something();
		
		classB b = new classB();
		b.init();
		b.do_something();
		
		InterA.static_method();//인터페이스 자체에서 기능 제공, 확장 불가능
	}

}
