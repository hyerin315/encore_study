package looping.test;
/*
 * 반복문에서의 break 사용법
 * break는 반복문 안에서 사용하는데
 * if문과 함께 사용되어서 
 * 해당하는 조건이 true이면 반복문을 빠져나간다.
 * --> if문을 빠져나가는 게 아님
 */

public class BasicLoopingTest2 {
	public static void main(String[] args) {
		//main Method 아래에 쓰면 로컬변수 --> 로컬변수는 기본값이 없다 --> 초기화하고 사용해야한다.
		int num = 0;//초기화
		int total = 0;
		
		for(num=1; num<=100; num++) {//위에 int 있어서 선언 안했음
			total+= num; 
			if(total>120) break;//120보다 크면 반복 안하도록 break --> 값이 나오고 끝남
		}
		System.out.println("1부터 100까지의 총 합은"+total);

	}
}
