package com.encore.test;

import java.io.IOException;
import java.util.Scanner;

class Test{
	public void input() throws IOException {//이 메소드가 IOException 예외처리를 호출하는 쪽으로 미룸
		char ch = ' ';
		while((ch = (char) System.in.read())!='\n') {//자바는 입출력 코드에 예외처리를 강제 요구
			System.out.print(ch);
		}
	}
	//호출하는 쪽에서 예외처리를 강제로 넘길 때 사용
	public void printArr(int[] arr) throws ArrayIndexOutOfBoundsException{
		for(int i=0; i<=arr.length; i++) {//오류 나도록 돌리는 것
			System.out.println(arr[i]);
		}
	}
}

public class Except2Main {
	public static void main(String[] args) throws IOException {//메인에서 또 예외처리를 미루게 되면 아예 예외처리를 안하는 게 됨
		Scanner sc = new Scanner(System.in);
		Test t = new Test();
		t.input();//호출된 곳에 아까 미룬 예외처리가 넘어옴
		
		int[] a = {1,2,3};
		try {
			t.printArr(a);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
}
