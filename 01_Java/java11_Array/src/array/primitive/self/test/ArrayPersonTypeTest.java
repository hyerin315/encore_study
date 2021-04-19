package array.primitive.self.test;

import java.util.Scanner;

/*
 * Input sample
 * Scanner로 입력 받는다
 * 6 ---사람 숫자 = 배열 사이즈와 동일
 * 1 4 4 4 5 3
 */

public class ArrayPersonTypeTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int타입의 배열을 생성...사이즈는 얼마로?
		int num = sc.nextInt();
		//배열부터 만들기
		int [] people = new int[num]; //people이라는 이름의 배열
		
		for(int i=0; i<people.length; i++) //6번 돌아야함으로
			people[i] = sc.nextInt();//people이라는 배열에 우리가 입력한 값이 6개의 칸에 들어간 상태
		//for(int i : people) System.out.print(i+" "); --> 잘나온지 확인을 위해 써봄
		//제어문...switch...사용해서 문제를 해결하는 알고리즘을 만들어서 결과를 출력해보세요
		int[ ] types = new int[5];//5칸 짜리 배열 types를 만듦 --> 배열 안은 0으로 채워짐 --> index는 0~4까지
		for(int i=0; i<people.length; i++) {//people에 있는 값을 types에 넣고 싶어서 생성
			switch(people[i]) {
			case 1:
				types[0]++;
				break;
			case 2:
				types[1]++;
				break;
			case 3:
				types[2]++;
				break;
			case 4:
				types[3]++;
				break;
			case 5:
				types[4]++;
				break;
			}
		}//types의 배열을 초기화
			
		int max = 0;
		    for(int i=0; i<types.length;i++) {
			  if(max<types[i])max = types[i];
		}		
			//max값에 해당하는 인덱스를 다시 찾는다.
		    int answer = 0;
			 for(int i=0; i<types.length; i++) {
				 if(max==types[i]) answer = i+1;
	    }		
			System.out.println("Result :" +answer);
	}
}


