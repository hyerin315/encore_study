package com.encore.inter;

import java.awt.SystemColor;

//얕은 복사와 깊은 복사...

public class ArrayCopyTest {

	public static void printArr(int[] arr) {
		for(int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		
		//1. 얕은 복사
		int[] b = a;//얕은 복사 --> 참조값만 참조
		b[2] = 300;//값을 바꾸면 a에 영향을 줌 == 둘이 한 곳을 참조하게 얕은 복사를 했기 때문에
		System.out.println("====a====");
		printArr(a);
		
		b[2] = 3;//깊은 복사 예시를 위해 원래대로 돌려둠
		
		//2. 깊은 복사
		int[] c = new int[a.length];//깊은 복사 --> 새롭게 같은 사이즈로 heap 새로운 메모리에 할당
		int cnt = 0;
		for(int i : a) {
			c[cnt++] = i;
		}
		System.out.println("====c(a를 깊은 복사)====");
		printArr(c);
		
	    c[2] = 300;//300으로 변경하고 a와 다른지 확인 
	    System.out.println("====c(2번방 300으로 변경)====");
	    printArr(c);
	    System.out.println("====a(c 변경 후)====");
	    printArr(a);//원본은 변경되지 않은 상태에서 값 변경 가능
	    
	    //3. system 클래스에서 제공해주는 깊은 복사 == arraycopy
	    int[] dest = new int[3]; 
	    System.arraycopy(a, 2, dest, 0, 3);//a배열의 2번 방부터 복사해 + dest라는 배열에다가(사이즈가 3인 배열) + dest의 0번 위치부터 넣어라 --> 3,4,5
	    //System.arraycopy(원본배열, 원본배열 복사위치, 복사대상배열, 복사대상배열의 복사할 위치, 복사할 개수)
	    System.out.println("====dest====");
	    printArr(dest);
	    
	    dest [1] = 500;
	    System.out.println("====a(dest 변경 후)====");
	    printArr(a);//원본 값 그대로 출력 == dest가 영향을 주지 않는 깊은 복사가 이루어졌다
		
	}

}
