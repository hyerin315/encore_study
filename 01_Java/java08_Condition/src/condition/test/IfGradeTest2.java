package condition.test;

//java.lang�� �ƴ� �ٸ� ��Ű���� �ִ� Ŭ������ ����Ҷ��� �ݵ�� import�ؼ� ����Ѵ�.
import java.util.Scanner;

/*
 * step 2
 * ����� ���� �޾Ƽ� ó���ϵ��� ������ �ۼ�
 * Scanner ��ü�� ����
 */
public class IfGradeTest2 {
	public static void main(String[] args) {
		// int grade = 87; 
		
		// Ű����� �Է��� ���� �޴� Scanner ��ü�� ������ ��
		Scanner sc = new Scanner(System.in);
		//Scanner Ŭ������ ���...next(), nextLine(), nextInt() �Լ��� ������ ����
		System.out.println("����� �̸��� ������ �Է�>>");
		int grade=sc.nextInt();//���ڴ� int ���ڴ� string
		String name=sc.nextLine();//next�� ������ �������� ���� �з�, nextLine�� ���ͷ� �ٹٲ� �ؾ� ���� �з�
		
		if(grade>=90 && grade<=100) System.out.println(name+"��, A Grade...");
		else if(grade>=80 && grade<90) System.out.println(name+"��, B Grade...");			
		else if(grade>=70 && grade<80) System.out.println(name+"��, C Grade...");			
		else System.out.println("Try Again...");
	
	}
}
