package com.encore.test;


interface MinMax {// 諛곗뿴 理쒕�, 理쒖냼 援ы븿
		int arrMin(int[] arr);

		int arrMax(int[] arr);
	}

interface Sort {// 諛곗뿴 �젙�젹
		void selectSort(int[] arr);
		void printArr(int[] arr);
	}

interface Search {
		int sequentialSearch(int[] arr, int x);
		int binarySearch(int[] arr, int n);
	}

//�씤�꽣�럹�씠�뒪 �긽�냽 �궎�썙�뱶:implements. �떎以묒긽�냽 媛��뒫. 肄ㅻ쭏濡� �긽�냽諛쏆쓣 �씤�꽣�럹�씠�뒪瑜� �굹�뿴�븿.
class WorkArr implements MinMax, Sort, Search {


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
		
		//출력
		@Override
		public void printArr(int[] arr) {
			for (int i : arr) {
				System.out.print(i+" ");
			}   System.out.println();
		}

		@Override
		public int sequentialSearch(int[] arr, int x) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int binarySearch(int[] arr, int n) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int arrMin(int[] arr) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int arrMax(int[] arr) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

public class Te {

		public static void main(String[] args) {
			WorkArr wa = new WorkArr();
			int[] a = { 7, 4, 2, 6, 9, 1, 8, 3, 5 };
			System.out.println("\n====selectSort 결과====");
		    wa.selectSort(a);
		    wa.printArr(a);

	}

}
