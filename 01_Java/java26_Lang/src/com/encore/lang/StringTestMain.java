package com.encore.lang;

public class StringTestMain {

	public static void main(String[] args) {
		String a = "aaa";//문자열 상수(==주소값으로 생각) -- 숫자 10, 3.14와 같은 싱수인데, 문자열인 상수 => 저장 또한 상수 영역에 저장됨(text영역)
		String b = new String("aaa");//Heap에다가 문자를 만든 것
		char[] d = {'a', 'b', 'c'};//하나하나 받은 것들을 d로 묶어
		String c = new String(d);//하나의 스트링으로 재생성
		String e = a;//상수 영역에 있는 것을 그대로 복사
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);

		System.out.println("a==b: "+(a==b));
		System.out.println("a.equals(b) : " +a.equals(b));//주속값이 서로 다름
		
		System.out.println("a==e: "+(a==e));
		System.out.println("a.equals(e) : " +a.equals(e));
		
		String x = b + c;//문자열에서의 더하기는 문자 두 개를 연결
		//b나 c가 변하지 않고, 새 메모리에 할당 받아 b와 c를 결합한 새로운 문자열을 생성하고 그 참조값을 x에 할당
		System.out.println(x);
		
	}
}
