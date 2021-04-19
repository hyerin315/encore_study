package com.encore.lang;

import java.util.Scanner;

public class StringBuilderTest {
	public static void main(String[] args) {
		//StringBuilder:내부 버퍼(배열)가 있어서 그안에서 문자열 조작함으로 문자열이 반복적으로 추가, 수정 같은 작업이 String보다 빠르다
		//--> 주기적으로 문자열을 덧붙이는 작업을 할 때 String보다 빠름
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		System.out.println("입력할 내용을 작성하시오. 멈추려면 /stop 입력");
		String buf = "";
		while(true) {
			System.out.println("msg:");
			buf = sc.next();
			if(buf.startsWith("/stop")) {
				break;
			}
			sb.append(buf);//append():문자열을 원본문자열 뒤에 덧붙이는 기능
		}
		System.out.println("입력내용");
		System.out.println(sb);
	}
}
