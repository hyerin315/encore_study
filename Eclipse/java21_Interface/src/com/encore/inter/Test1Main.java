package com.encore.inter;

import java.util.Arrays;
import java.util.Scanner;

// 다중상속 인터페이스 

interface MinMax{//배열의 최대 최소값을 받는 인터페이스
	int arrMin(int[] arr);
	int arrMax(int[] arr);
}
interface Sort{//배열 정렬 인터페이스
	void bubbleSort(int[] arr);//위에서의 애들을 정렬을 해주기때문에 반환값 없어도 됨
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
		for(i=0; i<arr.length-1; i++) {//맨 마지막 숫자는 자동으로 정렬이 되기 때문에 길이 
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
		int i;
		int tmp = 0;
		for(i=0; i<arr.length; i++) {
			if(arr[i] == x) {
				tmp = i;
			} else
				tmp = -1;
		} if(tmp == -1) {
			System.out.println("값이 없습니다");
		}
		return tmp;
	}//"~번째 있다고"주소값을 출력하고 싶은 데 어떻게 해야할까요...?

	//이진탐색 : 1.정렬이 되어 있어야함  2.그 중간값에서 시작함 3. 찾는 값이 더 크면 오른쪽으로, 작으면 왼쪽으로 움직여 원하는 값을 찾음  
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
	    System.out.println("\n최대값 : " + wa.arrMax(a));
	    System.out.println("최소값 : " + wa.arrMin(a));
	    System.out.println("\n=====bubbleSort 결과====");
	    wa.bubbleSort(a);
	    int[] b = {7,4,2,6,9,1,8,3,5};
	    System.out.println("\n====insertSort 결과====");
	    wa.insertSort(b);
	    int[] c = {7,4,2,6,9,1,8,3,5};
	    System.out.println("\n====selectSort 결과====");
	    wa.selectSort(c);
	    
	    System.out.println("\n검색할 데이터를 입력하세요(순차탐색)");
	    Scanner sc = new Scanner(System.in);
	    int x = sc.nextInt();
	    System.out.println(wa.sequentialSearch(a, x) + "번 째에 위치하고 있습니다.");//위치값 오류
	    
	    System.out.println("\n검색할 데이터를 입력하세요(이진탐색)");
	    Scanner s = new Scanner(System.in);
	    int n = s.nextInt();
	    System.out.println(wa.binarySearch(a, n) + "번 째에 위치하고 있습니다.");//위치값 오류..?
	    
	    System.out.println("정렬 후");
	    wa.printArr(a);
	}

}
