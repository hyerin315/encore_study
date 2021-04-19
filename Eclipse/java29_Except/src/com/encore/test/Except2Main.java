package com.encore.test;

import java.io.IOException;
import java.util.Scanner;

class Test{
	public void input() throws IOException {//�� �޼ҵ尡 IOException ����ó���� ȣ���ϴ� ������ �̷�
		char ch = ' ';
		while((ch = (char) System.in.read())!='\n') {//�ڹٴ� ����� �ڵ忡 ����ó���� ���� �䱸
			System.out.print(ch);
		}
	}
	//ȣ���ϴ� �ʿ��� ����ó���� ������ �ѱ� �� ���
	public void printArr(int[] arr) throws ArrayIndexOutOfBoundsException{
		for(int i=0; i<=arr.length; i++) {//���� ������ ������ ��
			System.out.println(arr[i]);
		}
	}
}

public class Except2Main {
	public static void main(String[] args) throws IOException {//���ο��� �� ����ó���� �̷�� �Ǹ� �ƿ� ����ó���� ���ϴ� �� ��
		Scanner sc = new Scanner(System.in);
		Test t = new Test();
		t.input();//ȣ��� ���� �Ʊ� �̷� ����ó���� �Ѿ��
		
		int[] a = {1,2,3};
		try {
			t.printArr(a);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
}
