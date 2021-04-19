package com.encore.test;

import java.util.Arrays;
import java.util.Scanner;

// 다중상속 인터페이스 

interface MinMax{//배열의 최대 최소값을 받는 인터페이스
	int arrMin(int[] arr);
	int arrMax(int[] arr);
}
interface Sort{//배열 정렬 인터페이스
	void bubbleSort(int[] arr);//정렬의 결과 --> 원본 배열 자체를 정렬 --> 원본 배열 자체가 결과물 
    int[] bubbleSort2(int[] arr);//원본배열 복사본 정렬 : 복사본 배열 
	
	void insertSort(int[] arr);
	void selectSort(int[] arr);
	void printArr(int[] arr);
}

interface Search{
	int sequentialSearch(int[] arr, int x);
	int binarySearch(int[] arr, int n);
}

//인터페이스 : 상속 키워드 - implement, 다중상속 가능 - 콤마로 상속받을 인터페이스를 나열함
class WorkArr implements MinMax, Sort, Search {//위에것들 한 번에 상속 받음

	//bubbleSort : 성능 안좋음, 밖에 있는 램에서 진행되고 두 칸씩 바꾸기 때문에 성능이 안좋음
	@Override
	public void bubbleSort(int[] arr) {//두 칸씩 비교해서 순서를 바꿔버리는 것
		int i, j, tmp;
		for(i=0; i<arr.length-1; i++) {//맨 마지막 숫자는 자동으로 정렬이 되기 때문에 길이 하나 줄여줘야함
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
		System.arraycopy(arr, 0, dest, 0, arr.length);//arraycopy 사용
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
		bubbleSort(dest);//위에 코드와 같으니 이렇게 써줘도 됨
		return dest;//배여릐 주값 반환
	}


	//insertSort
	@Override
	public void insertSort(int[] arr) {
		int tmp, i, j;
		for(i=1; i<arr.length; i++) {
			tmp = arr[i];
			j = i-1;
			while(j>=0 && tmp<arr[j]) {
				arr[j+1] = arr[j];//tmp의 값보다 큰 요소는 뒤로 한칸씩 이동
				j--;//비교대상 위치를 한 칸 앞으로 이동
			}
			j++;//루프에 의해서 항상 tmp의 값이 들어갈 위치보다 한 칸 앞으로 가 있으므로 뒤로 한 칸 이동해줘야 실제 tmp가 들어갈 위치가 된다
			arr[j] = tmp;
		}
	}
	

    //selectSort
	@Override
	public void selectSort(int[] arr) {
		int i, j, min, tmp;
		for (i = 0; i < arr.length - 1; i++) {//최소값이 들어갈 위치
			min = i;//min은 최소값의 위치, i를 초기값으로 할당
			//j = i+1; / 최소값을 찾기 위해, 뒤로 한 칸씩 이동하면서 값을 비교할 대상의 위치
			for (j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;//min보다 더 작은 값을 만나면 min의 위치 변경
				}
				if (min != i) {//min과 i가 같다면 스스로 자기 자리에 있는 것임 (자리 교체할 필요가 없음)
					tmp = arr[min];//그래서 min과 i가 같지 않을 때 swap
					arr[min] = arr[i];
					arr[i] = tmp;
				}//이 루프를 다 돌고나면 결국 가장 작은 값을 min이 가리킴
			}
		}
	}
	

	//배열의 최소값을 찾아 반환하는 메소드
	@Override
	public int arrMin(int[] arr) {
		int min = arr[0];//min : 최소값을 담을 변수, 비교하면서 더 작은 값을 만나면 min값으로 바꿔줄 것이기 때문에 0이라는 기본값을 할당
		//for(int i=0; i<arr.length; i++)
		for(int i : arr) {
			if (min > i) {//꺼내온 값이 min보다 작으면 그게 최소값
				min = i;
			}
		}
		return min;
	}
	
	//배열의 최대값을 찾아 반환하는 메소드
	@Override
	public int arrMax(int[] arr) {
		int max = arr[0];//max : 최대값을 담을 변수
		for(int i : arr) {
			if (max < i) {
				max = i;
			}
		}
		return max;
	}
	
	
    //순차탐색 : 처음부터 끝까지 찾는 거라 정보가 많으면 효율이 떨어짐
	@Override
	public int sequentialSearch(int[] arr, int x) {
		//있으면 인덱스, 없으면 -1을 반환하도록 생성
		int i;
		for(i=0; i<arr.length; i++) {
			if(arr[i] == x) {
				return i;
			}
		}
		return -1; //찾는 값이 없으면 이 라인에 도달
	}
	
	//이진탐색 : 1.정렬이 되어 있어야함  2.그 중간값에서 시작함 3. 찾는 값이 더 크면 오른쪽으로, 작으면 왼쪽으로 움직여 원하는 값을 찾음  
	@Override
	public int  binarySearch(int[] arr, int n) {
		int first = 0, last = arr.length-1, mid;
		
		while(first<=last) {
			mid = (first + last) / 2;//중간위치 찾기
			if(n == arr[mid]) {
				return mid; 
			} else if(n < arr[mid]) {
				last = mid - 1;
			}else {
					first = mid + 1;
			}
		}
		return -1; //찾는 값이 없으면 이 라인에 도달
	}

	//출력
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
	    int[] a = {7,4,2,6,9,1,8,3,5};//참조 타입의 a 변수 - Stack / 10칸짜리의 배열이 Heap에 올라감
	    wa.printArr(a);
	    System.out.println("\n최대값 : " + wa.arrMax(a));
	    System.out.println("최소값 : " + wa.arrMin(a));
	    
	    System.out.println("\n=====bubbleSort 결과====");
	    wa.bubbleSort(a);//참조 타입의 a변수가 들어가면 bubbleSort(int[] arr)에 참조값  할당 --> 똑같은 놈으로 정렬했기 때문에 리턴 필요 없음 
	    wa.printArr(a);
	    
	    int[] b = {7,4,2,6,9,1,8,3,5};
	    int[] res = wa.bubbleSort2(b);
	    System.out.println("\n====bubbleSort2 결과====");
	    wa.printArr(res);
	    
	    int[] c = {7,4,2,6,9,1,8,3,5};
	    System.out.println("\n====insertSort 결과====");
	    wa.insertSort(c);
	    wa.printArr(c);
	    
	    int[] d = {7,4,2,6,9,1,8,3,5};
	    System.out.println("\n====selectSort 결과====");
	    wa.selectSort(d);
	    wa.printArr(d);
	    
	    System.out.println("\n검색할 데이터를 입력하세요(순차탐색)");
	    int idx = wa.sequentialSearch(a, 9);//(배열, 찾고자 하는 값)
	    if(idx<0) {
	    	System.out.println("찾을 수 없습니다");
	    } else {
	    	System.out.println(idx + "번 방에 있다");
	    }
	    
	    System.out.println("\n검색할 데이터를 입력하세요(이진탐색)");
	    wa.selectSort(a);
	    wa.printArr(a);
	    idx = wa.binarySearch(a, 3);
	    if(idx<0) {
	    	System.out.println("찾을 수 없습니다");
	    } else {
	    	System.out.println(idx + "번 방에 있다");//정렬 후의 방
	    	    }
	}

}
