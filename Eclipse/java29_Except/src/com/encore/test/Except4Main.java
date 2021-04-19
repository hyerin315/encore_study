package com.encore.test;

class Test2{
	public void test1() {
		test2();//예외처리 없음
	}
	
	public void test2() {
		test3();//예외처리 없음
	}
	
	public void test3() {
		int x = 3/0;//예외 발생
	}
}

public class Except4Main {
	public static void main(String[] args) {//스택을 역방향으로 추적해서 찾는다
		Test2 t = new Test2();
		try {
			t.test1();
		} catch (ArithmeticException e) {//결국  메소드에서 throws로 던지지 않아도 처리가 가능함 
			System.out.println(e);
		}
	}
}
