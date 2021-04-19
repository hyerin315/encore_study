package condition.self.test;

import java.util.Scanner;

/*
 * package
 * static --> 객체 생성 필요 없이 이 부분은 미리 메모리가 올라가 있다
 * Scanner
 * abs()
 * if
 */
public class CatchAMouseTest {//3.
	public static String solv(int x, int y, int z) {//x : cat A, y : cat B, z : mouse 
		if(Math.abs(x-z) > Math.abs(y-z)) return "CatB Catch a Mouse!!";
		else if(Math.abs(x-z) < Math.abs(y-z)) return "CatA Catch a Mouse!!";
		else return "Mouse Escapes!!!";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 순서대로 값을 입력받는다
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
        //CatchAMouseTest t = next CatchAMouseTest();
		String result = CatchAMouseTest.solv(catA, catB, mouse);//2. calling 4. 값을 받는다
		//solv 메소드는 static --> String으로 받고 있음
		System.out.println("Result : "+result);
	}

}
