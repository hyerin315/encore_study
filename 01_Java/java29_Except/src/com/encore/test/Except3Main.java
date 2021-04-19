package com.encore.test;

//throw
//예외 출력 메세지 3가지

class MyNumExeption extends Exception{//재정의 해서 쓰고 싶으면 이렇게 클래스 만들어서 써도 됨 (근데 이거 안쓰고 그냥 Exception으로 던져도 됨)
	public MyNumExeption(String msg) {
		super(msg);
	}
}

class MyNum {
	private int num;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) throws MyNumExeption {
		if(num < 1 || num > 5) {//범위 내의 값이 아니면 예외 발생
			throw new MyNumExeption("num 같은 1~5만 가능");//예외 발생
		}
		this.num = num;
	}
}

public class Except3Main {

	public static void main(String[] args) {
		MyNum mn = new MyNum();
		try {
			mn.setNum(3);
			System.out.println(mn.getNum());
			mn.setNum(8);
			System.out.println(mn.getNum());
		} catch (MyNumExeption e) {
			//예외 발생시 출력 방법 3가지
			System.out.print("1.stakc trace: ");
			e.printStackTrace();//예외를 스택으로 추적하면서 출력
			System.out.println("2.e:"+ e);//toString() 반환값 출력, 예외 클래스는 등록된 예외 메세지 반환하도록 재정의
			System.out.println("3.getMessage():" + e.getMessage());//예외 클래스에 등록된 예외 메세지 반환
		}
		System.out.println("프로그램 끝까지 실행됨");
	}
}
