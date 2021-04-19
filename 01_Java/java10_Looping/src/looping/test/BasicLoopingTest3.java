package looping.test;
/*
 * 반복문 안에서 사용되는 키워드 : break, continue
 * 
 * 반복문에서의 continue 사용법
 * continue : if가 참인 경우에 바로 아래 코드(totla+= num;)는 건너뛰고 반복문을 계속 한다 (그래서 키워드가 skip이 아닌 continue
 * 
 */

public class BasicLoopingTest3 {
	public static void main(String[] args) {
		//main Method 아래에 쓰면 로컬변수 --> 로컬변수는 기본값이 없다 --> 초기화하고 사용해야한다.
		int num = 0;//초기화
		int total = 0;
		
		for(num=1; num<=10; num++) {//위에 int 있어서 선언 안했음
			if(num % 2 == 0) continue;//if가 참이면 바로 아래 있는 문장 totla+= num;은 건너뛰고 for을 반복한다
			//num % 2 == 0 --> 짝수 표현 (홀수 표현은 1)
			total+= num;
		}
		System.out.println("1부터 100까지 홀수의 총합"+total);

	}
}
