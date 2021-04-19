package array.primitive.self.test;

import java.util.Scanner;

/*
 * Input sample
 * Scanner�� �Է� �޴´�
 * 6 ---��� ���� = �迭 ������� ����
 * 1 4 4 4 5 3
 */

public class ArrayPersonTypeTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//intŸ���� �迭�� ����...������� �󸶷�?
		int num = sc.nextInt();
		//�迭���� �����
		int [] people = new int[num]; //people�̶�� �̸��� �迭
		
		for(int i=0; i<people.length; i++) //6�� ���ƾ�������
			people[i] = sc.nextInt();//people�̶�� �迭�� �츮�� �Է��� ���� 6���� ĭ�� �� ����
		//for(int i : people) System.out.print(i+" "); --> �߳����� Ȯ���� ���� �ẽ
		//���...switch...����ؼ� ������ �ذ��ϴ� �˰����� ���� ����� ����غ�����
		int[ ] types = new int[5];//5ĭ ¥�� �迭 types�� ���� --> �迭 ���� 0���� ä���� --> index�� 0~4����
		for(int i=0; i<people.length; i++) {//people�� �ִ� ���� types�� �ְ� �; ����
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
		}//types�� �迭�� �ʱ�ȭ
			
		int max = 0;
		    for(int i=0; i<types.length;i++) {
			  if(max<types[i])max = types[i];
		}		
			//max���� �ش��ϴ� �ε����� �ٽ� ã�´�.
		    int answer = 0;
			 for(int i=0; i<types.length; i++) {
				 if(max==types[i]) answer = i+1;
	    }		
			System.out.println("Result :" +answer);
	}
}


