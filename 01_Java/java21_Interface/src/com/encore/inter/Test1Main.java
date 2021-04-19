package com.encore.inter;

import java.util.Arrays;
import java.util.Scanner;

// ���߻�� �������̽� 

interface MinMax{//�迭�� �ִ� �ּҰ��� �޴� �������̽�
	int arrMin(int[] arr);
	int arrMax(int[] arr);
}
interface Sort{//�迭 ���� �������̽�
	void bubbleSort(int[] arr);//�������� �ֵ��� ������ ���ֱ⶧���� ��ȯ�� ��� ��
	void insertSort(int[] arr);
	void selectSort(int[] arr);
	void printArr(int[] arr);
}

interface Search{
	int sequentialSearch(int[] arr, int x);
	int binarySearch(int[] arr, int n);
}

//�������̽� : ��� Ű���� - implement, ���߻�� ���� - �޸��� ��ӹ��� �������̽��� ������
class WorkArr implements MinMax, Sort, Search {//�����͵� �� ���� ��� ����

	//bubbleSort : ���� ������, �ۿ� �ִ� ������ ����ǰ� �� ĭ�� �ٲٱ� ������ ������ ������
	@Override
	public void bubbleSort(int[] arr) {//�� ĭ�� ���ؼ� ������ �ٲ������ ��
		int i, j, tmp;
		for(i=0; i<arr.length-1; i++) {//�� ������ ���ڴ� �ڵ����� ������ �Ǳ� ������ ���� 
			for(j=0; j<arr.length-1; j++) {
				if(arr[j]>arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		} System.out.print(Arrays.toString(arr));
	} 

	//insertSort
	@Override
	public void insertSort(int[] arr) {
	     for(int i = 1; i <arr.length; i++) {
	    	 int tmp = arr[i];
	    	 int j = i-1;
	    	 while(j >= 0 && tmp < arr[j]) {
	    		 arr[j+1] = arr[j];
	    		 j--;
	    	 }		 
	     } System.out.print(Arrays.toString(arr));
	}
    //selectSort
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	@Override
	public void selectSort(int[] arr) {
		int i, j;
		for(i=0; i<arr.length-1; i++) {
			int min = i;
			for(j=i+1; j<arr.length; j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
				if(i!=min)
					swap(arr, i, min);
				
			}
		} System.out.print(Arrays.toString(arr));
	}
			

	//�迭�� �ּҰ��� ã�� ��ȯ�ϴ� �޼ҵ�
	@Override
	public int arrMin(int[] arr) {
		int min = arr[0];//min : �ּҰ��� ���� ����, ���ϸ鼭 �� ���� ���� ������ min������ �ٲ��� ���̱� ������ 0�̶�� �⺻���� �Ҵ�
		//for(int i=0; i<arr.length; i++)
		for(int i : arr) {
			if (min > i) {//������ ���� min���� ������ �װ� �ּҰ�
				min = i;
			}
		}
		return min;
	}
	
	//�迭�� �ִ밪�� ã�� ��ȯ�ϴ� �޼ҵ�
	@Override
	public int arrMax(int[] arr) {
		int max = arr[0];//max : �ִ밪�� ���� ����
		for(int i : arr) {
			if (max < i) {
				max = i;
			}
		}
		return max;
	}
	
	
    //����Ž�� : ó������ ������ ã�� �Ŷ� ������ ������ ȿ���� ������
	@Override
	public int sequentialSearch(int[] arr, int x) {
		int i;
		int tmp = 0;
		for(i=0; i<arr.length; i++) {
			if(arr[i] == x) {
				tmp = i;
			} else
				tmp = -1;
		} if(tmp == -1) {
			System.out.println("���� �����ϴ�");
		}
		return tmp;
	}//"~��° �ִٰ�"�ּҰ��� ����ϰ� ���� �� ��� �ؾ��ұ��...?

	//����Ž�� : 1.������ �Ǿ� �־����  2.�� �߰������� ������ 3. ã�� ���� �� ũ�� ����������, ������ �������� ������ ���ϴ� ���� ã��  
	@Override
	public int  binarySearch(int[] arr, int n) {
		int first = 0;
		int last = arr.length-1;
		int mid = 0;
		
		while(first<=last) {
			mid = (first + last) / 2;
			if(n == arr[mid])
				return mid;
			else {
				if(n < arr[mid])
					last = mid - 1;
				else
					first = mid + 1;
			}
		}
		return -1;
	}

	@Override
	public void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i+" ");
		}   System.out.println();
	}
	
	
}
public class Test1Main {

	public static void main(String[] args) {
		WorkArr wa = new WorkArr();
	    int[] a = {7,4,2,6,9,1,8,3,5};
	    wa.printArr(a);
	    System.out.println("\n�ִ밪 : " + wa.arrMax(a));
	    System.out.println("�ּҰ� : " + wa.arrMin(a));
	    System.out.println("\n=====bubbleSort ���====");
	    wa.bubbleSort(a);
	    int[] b = {7,4,2,6,9,1,8,3,5};
	    System.out.println("\n====insertSort ���====");
	    wa.insertSort(b);
	    int[] c = {7,4,2,6,9,1,8,3,5};
	    System.out.println("\n====selectSort ���====");
	    wa.selectSort(c);
	    
	    System.out.println("\n�˻��� �����͸� �Է��ϼ���(����Ž��)");
	    Scanner sc = new Scanner(System.in);
	    int x = sc.nextInt();
	    System.out.println(wa.sequentialSearch(a, x) + "�� °�� ��ġ�ϰ� �ֽ��ϴ�.");//��ġ�� ����
	    
	    System.out.println("\n�˻��� �����͸� �Է��ϼ���(����Ž��)");
	    Scanner s = new Scanner(System.in);
	    int n = s.nextInt();
	    System.out.println(wa.binarySearch(a, n) + "�� °�� ��ġ�ϰ� �ֽ��ϴ�.");//��ġ�� ����..?
	    
	    System.out.println("���� ��");
	    wa.printArr(a);
	}

}
