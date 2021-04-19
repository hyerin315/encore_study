package condition.test;

//java.lang이 아닌 다른 패키지에 있는 클래스를 사용할때는 반드시 import해서 사용한다.
import java.util.Scanner;

/*
 * step 2
 * 실행시 값을 받아서 처리하도록 로직을 작성
 * Scanner 객체를 생성
 */
public class IfGradeTest2 {
	public static void main(String[] args) {
		// int grade = 87; 
		
		// 키보드로 입력할 값을 받는 Scanner 객체를 생성한 것
		Scanner sc = new Scanner(System.in);
		//Scanner 클래스의 기능...next(), nextLine(), nextInt() 함수의 차이점 정리
		System.out.println("당신의 이름과 성적을 입력>>");
		int grade=sc.nextInt();//숫자는 int 문자는 string
		String name=sc.nextLine();//next는 공백을 기준으로 값을 분류, nextLine은 엔터로 줄바꿈 해야 값을 분류
		
		if(grade>=90 && grade<=100) System.out.println(name+"님, A Grade...");
		else if(grade>=80 && grade<90) System.out.println(name+"님, B Grade...");			
		else if(grade>=70 && grade<80) System.out.println(name+"님, C Grade...");			
		else System.out.println("Try Again...");
	
	}
}
