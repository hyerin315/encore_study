package com.encore.inter;
interface Add{
	int add(int a, int b);
}

interface Sub{
	int sub(int a, int b);
}

interface Calc extends Add, Sub{//인터페이스가 인터페이스 상속받는 키워드 extends(기존에는 emplment였는데 인터페이스끼리 상속받을 때는 extends)
	int mul(int a, int b);
}

class CalcImpl implements Calc{

	@Override
	public int add(int a, int b) {
		return a + b;
		
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int mul(int a, int b) {
		return a * b;
	}
}

public class InterTestMain {

	public static void main(String[] args) {
		CalcImpl c = new CalcImpl();
		System.out.println("add : " + c.add(1, 2));
		System.out.println("sub : " + c.sub(1, 2));
		System.out.println("mul : " + c.mul(1, 2));
	}
}
