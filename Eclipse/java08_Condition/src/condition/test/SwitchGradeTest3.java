package condition.test;

import java.util.Scanner;

public class SwitchGradeTest3 {

	public static void main(String[] args) {
		//���ú���(local V��riable) �޼ҵ� �ȿ� ����� ���� = �⺻���� ���� = ���� �Ҵ��ؾ���
		//���ú����� �޼ҵ� �ۿ��� ����� �� ���� (����ϸ� ����)
		Scanner sc = new Scanner(System.in); //��ĳ�� Ÿ���� ���� - ��ü�� �����ϰ� �Ǹ� �޸𸮿� �ı��� �ö� = �ı��� �ö� ��ġ�� �Ҵ��
		//���� �ؿ� ������� warnig ǥ��
		
		System.out.println("����� �̸��� �Է��ϼ���");
		String name=sc.nextLine(); //Ű���忡 �Է��� ���� �Ҵ� �޾ƾ��� (�̸�) --> name�̶�� ����
		
		System.out.println("����� ����� �Է��ϼ���");
		String grade=sc.nextLine();//���
		
		switch(grade) { //���� ���� ������ ���� ������ �־��ָ� ��
		    case "A" :
		    	System.out.println(name+"��, ����� ������ 90~100���Դϴ�.");
		    	break; //����� ����� ���� brake
			case "B" :
			    System.out.println(name+"��, ����� ������ 80~89���Դϴ�.");
			    break; //����� ����� ���� brake
			case "C" :
			    System.out.println(name+"��, ����� ������ 70~79���Դϴ�.");
			    break; //����� ����� ���� brake
			default: //else�� ���� ����
				System.out.println(name+"��, Try Again!");
				break;
		}
	}

}
