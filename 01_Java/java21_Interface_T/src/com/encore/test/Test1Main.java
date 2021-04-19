package com.encore.test;

import java.util.Arrays;
import java.util.Scanner;

// ���߻�� �������̽� 

interface MinMax{//�迭�� �ִ� �ּҰ��� �޴� �������̽�
	int arrMin(int[] arr);
	int arrMax(int[] arr);
}
interface Sort{//�迭 ���� �������̽�
	void bubbleSort(int[] arr);//������ ��� --> ���� �迭 ��ü�� ���� --> ���� �迭 ��ü�� ����� 
    int[] bubbleSort2(int[] arr);//�����迭 ���纻 ���� : ���纻 �迭 
	
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
		for(i=0; i<arr.length-1; i++) {//�� ������ ���ڴ� �ڵ����� ������ �Ǳ� ������ ���� �ϳ� �ٿ������
			for(j=0; j<arr.length-1; j++) {
				if(arr[j]>arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		} 
	} 
	
	//bubbleSort2
	@Override
	public int[] bubbleSort2(int[] arr) {
		int[] dest = new int[arr.length];
		System.arraycopy(arr, 0, dest, 0, arr.length);//arraycopy ���
/*		int i, j, tmp;
		for(i=0; i<arr.length-1; i++) {
			for(j=0; j<dest.length-1; j++) {
				if(arr[j]>dest[j + 1]) {
					tmp = dest[j];
					arr[j] = dest[j + 1];
					arr[j + 1] = tmp;
				}
			}
		} */
		bubbleSort(dest);//���� �ڵ�� ������ �̷��� ���൵ ��
		return dest;//�迩�l �ְ� ��ȯ
	}


	//insertSort
	@Override
	public void insertSort(int[] arr) {
		int tmp, i, j;
		for(i=1; i<arr.length; i++) {
			tmp = arr[i];
			j = i-1;
			while(j>=0 && tmp<arr[j]) {
				arr[j+1] = arr[j];//tmp�� ������ ū ��Ҵ� �ڷ� ��ĭ�� �̵�
				j--;//�񱳴�� ��ġ�� �� ĭ ������ �̵�
			}
			j++;//������ ���ؼ� �׻� tmp�� ���� �� ��ġ���� �� ĭ ������ �� �����Ƿ� �ڷ� �� ĭ �̵������ ���� tmp�� �� ��ġ�� �ȴ�
			arr[j] = tmp;
		}
	}
	

    //selectSort
	@Override
	public void selectSort(int[] arr) {
		int i, j, min, tmp;
		for (i = 0; i < arr.length - 1; i++) {//�ּҰ��� �� ��ġ
			min = i;//min�� �ּҰ��� ��ġ, i�� �ʱⰪ���� �Ҵ�
			//j = i+1; / �ּҰ��� ã�� ����, �ڷ� �� ĭ�� �̵��ϸ鼭 ���� ���� ����� ��ġ
			for (j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;//min���� �� ���� ���� ������ min�� ��ġ ����
				}
				if (min != i) {//min�� i�� ���ٸ� ������ �ڱ� �ڸ��� �ִ� ���� (�ڸ� ��ü�� �ʿ䰡 ����)
					tmp = arr[min];//�׷��� min�� i�� ���� ���� �� swap
					arr[min] = arr[i];
					arr[i] = tmp;
				}//�� ������ �� ������ �ᱹ ���� ���� ���� min�� ����Ŵ
			}
		}
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
		//������ �ε���, ������ -1�� ��ȯ�ϵ��� ����
		int i;
		for(i=0; i<arr.length; i++) {
			if(arr[i] == x) {
				return i;
			}
		}
		return -1; //ã�� ���� ������ �� ���ο� ����
	}
	
	//����Ž�� : 1.������ �Ǿ� �־����  2.�� �߰������� ������ 3. ã�� ���� �� ũ�� ����������, ������ �������� ������ ���ϴ� ���� ã��  
	@Override
	public int  binarySearch(int[] arr, int n) {
		int first = 0, last = arr.length-1, mid;
		
		while(first<=last) {
			mid = (first + last) / 2;//�߰���ġ ã��
			if(n == arr[mid]) {
				return mid; 
			} else if(n < arr[mid]) {
				last = mid - 1;
			}else {
					first = mid + 1;
			}
		}
		return -1; //ã�� ���� ������ �� ���ο� ����
	}

	//���
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
	    int[] a = {7,4,2,6,9,1,8,3,5};//���� Ÿ���� a ���� - Stack / 10ĭ¥���� �迭�� Heap�� �ö�
	    wa.printArr(a);
	    System.out.println("\n�ִ밪 : " + wa.arrMax(a));
	    System.out.println("�ּҰ� : " + wa.arrMin(a));
	    
	    System.out.println("\n=====bubbleSort ���====");
	    wa.bubbleSort(a);//���� Ÿ���� a������ ���� bubbleSort(int[] arr)�� ������  �Ҵ� --> �Ȱ��� ������ �����߱� ������ ���� �ʿ� ���� 
	    wa.printArr(a);
	    
	    int[] b = {7,4,2,6,9,1,8,3,5};
	    int[] res = wa.bubbleSort2(b);
	    System.out.println("\n====bubbleSort2 ���====");
	    wa.printArr(res);
	    
	    int[] c = {7,4,2,6,9,1,8,3,5};
	    System.out.println("\n====insertSort ���====");
	    wa.insertSort(c);
	    wa.printArr(c);
	    
	    int[] d = {7,4,2,6,9,1,8,3,5};
	    System.out.println("\n====selectSort ���====");
	    wa.selectSort(d);
	    wa.printArr(d);
	    
	    System.out.println("\n�˻��� �����͸� �Է��ϼ���(����Ž��)");
	    int idx = wa.sequentialSearch(a, 9);//(�迭, ã���� �ϴ� ��)
	    if(idx<0) {
	    	System.out.println("ã�� �� �����ϴ�");
	    } else {
	    	System.out.println(idx + "�� �濡 �ִ�");
	    }
	    
	    System.out.println("\n�˻��� �����͸� �Է��ϼ���(����Ž��)");
	    wa.selectSort(a);
	    wa.printArr(a);
	    idx = wa.binarySearch(a, 3);
	    if(idx<0) {
	    	System.out.println("ã�� �� �����ϴ�");
	    } else {
	    	System.out.println(idx + "�� �濡 �ִ�");//���� ���� ��
	    	    }
	}

}
