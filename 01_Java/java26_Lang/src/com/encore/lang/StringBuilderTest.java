package com.encore.lang;

import java.util.Scanner;

public class StringBuilderTest {
	public static void main(String[] args) {
		//StringBuilder:���� ����(�迭)�� �־ �׾ȿ��� ���ڿ� ���������� ���ڿ��� �ݺ������� �߰�, ���� ���� �۾��� String���� ������
		//--> �ֱ������� ���ڿ��� �����̴� �۾��� �� �� String���� ����
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է��� ������ �ۼ��Ͻÿ�. ���߷��� /stop �Է�");
		String buf = "";
		while(true) {
			System.out.println("msg:");
			buf = sc.next();
			if(buf.startsWith("/stop")) {
				break;
			}
			sb.append(buf);//append():���ڿ��� �������ڿ� �ڿ� �����̴� ���
		}
		System.out.println("�Է³���");
		System.out.println(sb);
	}
}
