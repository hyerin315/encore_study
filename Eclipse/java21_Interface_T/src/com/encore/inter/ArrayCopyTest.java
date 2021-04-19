package com.encore.inter;

import java.awt.SystemColor;

//���� ����� ���� ����...

public class ArrayCopyTest {

	public static void printArr(int[] arr) {
		for(int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		
		//1. ���� ����
		int[] b = a;//���� ���� --> �������� ����
		b[2] = 300;//���� �ٲٸ� a�� ������ �� == ���� �� ���� �����ϰ� ���� ���縦 �߱� ������
		System.out.println("====a====");
		printArr(a);
		
		b[2] = 3;//���� ���� ���ø� ���� ������� ������
		
		//2. ���� ����
		int[] c = new int[a.length];//���� ���� --> ���Ӱ� ���� ������� heap ���ο� �޸𸮿� �Ҵ�
		int cnt = 0;
		for(int i : a) {
			c[cnt++] = i;
		}
		System.out.println("====c(a�� ���� ����)====");
		printArr(c);
		
	    c[2] = 300;//300���� �����ϰ� a�� �ٸ��� Ȯ�� 
	    System.out.println("====c(2���� 300���� ����)====");
	    printArr(c);
	    System.out.println("====a(c ���� ��)====");
	    printArr(a);//������ ������� ���� ���¿��� �� ���� ����
	    
	    //3. system Ŭ�������� �������ִ� ���� ���� == arraycopy
	    int[] dest = new int[3]; 
	    System.arraycopy(a, 2, dest, 0, 3);//a�迭�� 2�� ����� ������ + dest��� �迭���ٰ�(����� 3�� �迭) + dest�� 0�� ��ġ���� �־�� --> 3,4,5
	    //System.arraycopy(�����迭, �����迭 ������ġ, ������迭, ������迭�� ������ ��ġ, ������ ����)
	    System.out.println("====dest====");
	    printArr(dest);
	    
	    dest [1] = 500;
	    System.out.println("====a(dest ���� ��)====");
	    printArr(a);//���� �� �״�� ��� == dest�� ������ ���� �ʴ� ���� ���簡 �̷������
		
	}

}
