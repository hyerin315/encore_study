package condition.test;

import java.util.Scanner;

public class SwitchGradeTest4 {

	public static void main(String[] args) {//1. Start <-- JVM
		Scanner sc = new Scanner(System.in);//2. ��ü�� �����ϰ� �Ǹ� �޸𸮿� �ı��� �ö� = �ı��� �ö� ��ġ�� �Ҵ��
		System.out.println("����� �̸��� �Է��ϼ���");
		String name=sc.nextLine();//�Է��� ���� �޾Ƽ� String���� ��ȯ
		
		System.out.println("����� ����� �Է��ϼ���");
		String grade=sc.nextLine();//�Է��� ���� �޾Ƽ� String���� ��ȯ
		
		
		//�߰�...����� ��ġ�� �޼ҵ� �ȿ� �ֱ� ������, ���ú���
		String message="";//�ʱ�ȭ (�Է��� ���� ��� ���� �����)
		switch(grade) {
		    case "A" :
		    	message = name+"��, ����� ������ 90~100���Դϴ�.";
		    	break;//break�� ������ �ش��ϴ� case�� �������´�--> switch�� �������� 
		    	// == switch�� �Էµ� ���� �´� ���̽��� ������ ���� �극��ũ�� ���� ����ġ�� �������� --> System.out.println(message);�� ������ ��
		    	// == ���̽� �ϳ��� ������ �� 
			case "B" :
				message = name+"��, ����� ������ 80~89���Դϴ�.";
			    break; 
			case "C" :
				message = name+"��, ����� ������ 70~79���Դϴ�.";
			    break;
			default:
				message = name+"��, Try Again!";
				break;//��� �극��ũ�� ������ ���̽� �������� ������ default������ ���
		}
		System.out.println(message);
	}

}
