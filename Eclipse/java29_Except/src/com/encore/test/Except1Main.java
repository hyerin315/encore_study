package com.encore.test;
//예외처리 구문
public class Except1Main {
	public int test;

	public static void main(String[] args) {
		System.out.println("예외 발생 전");
		//int x = 3 / 0; 상수는 0으로 나누면 안됨, 0으로 나누면 다운됨
		int x;
		int[] arr = {1,2,3};
		Except1Main em = null;
		try {
			System.out.println("try 블록 1");
			//x = 3 / 0;
			//arr[3] =  4;
			em.test = 10;
			System.out.println("try 블록 2");//실행 안됨. 위에서 예외 발생시 catch블록으로 분기
		} catch (ArithmeticException e) {
			System.out.println("예외발생: "+e);
		} catch (ArrayIndexOutOfBoundsException e) {//인덱스를 벗어나는 예외처리문이 발생하면, 캐치문을 써주면 됨
			System.out.println("예외발생: "+e);
		} catch (NullPointerException e) {//인덱스를 벗어나는 예외처리문이 발생하면, 캐치문을 써주면 됨
			System.out.println("예외발생: "+e);
		} catch (Exception e) {//(==if문 else의 역할): 위에 나열한 예외 객체가 아니면 여기서 걸러줌 (생각치 못한 예외가 또 있을 때)
		//Exception은 오류문의 상위 개념
			System.out.println("예외발생: "+e);
		} finally {//필요한 경우 (꼭 실행시켜야하는 경우) 작성
			System.out.println("꼭 실행");
		}
		  System.out.println("예외 발생 후");
	}
}
