package com.encore.lang;

public class StringTest2Main {

	public static void main(String[] args) {
		
		//split(구분자):구분자를 기준으로 문자열을 쪼개서 배열에 담아서 반환(쪼개면 여러개니까) --> 구분자는 , / 아무거나, 문자도 가능
		String a = "aaa, bbb, ccc, ddd";//문자열을 변수 a 담음
		String[] b = a.split(",");
		for(String s : b) {
			System.out.println(s);
		}

		String c = b[0].concat(b[1]);//문자열을 연결
		System.out.println(c);
		
		
		//statWith : 매개변수 문자열로 시작되면 true, 아니면 false
		if(a.startsWith("aa")) {//a도 되고, aaa도 됨 -> 모두 해당하기 때문
			System.out.println("문자열이 aa로 시작함");
		}
		
		//endWith : 매개변수 문자열로 끝나나?
		if(a.endsWith("ddd")) {
			System.out.println("문자열이 ddd로 끝남");
		}
		
		char x = a.charAt(5);//매개변수 위치의 문자 하나를 반환
		System.out.println("a의 5번째 위치 문자는 "+x);

		if(a.contains("b,c")) {//매개변수를 포함하나?
			int idx = a.indexOf("b,c");//있으면 위치가 어디야? - 매개변수 문자열의 위치값 반환
			System.out.println("a에 문자 b,c는 "+idx+"위치에 있음");
		}
	}
}
