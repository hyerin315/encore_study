package condition.self.test;

import java.util.Scanner;

/*
 * package
 * static --> ��ü ���� �ʿ� ���� �� �κ��� �̸� �޸𸮰� �ö� �ִ�
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
		//1. ������� ���� �Է¹޴´�
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
        //CatchAMouseTest t = next CatchAMouseTest();
		String result = CatchAMouseTest.solv(catA, catB, mouse);//2. calling 4. ���� �޴´�
		//solv �޼ҵ�� static --> String���� �ް� ����
		System.out.println("Result : "+result);
	}

}
