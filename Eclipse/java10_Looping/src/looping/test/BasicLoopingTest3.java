package looping.test;
/*
 * �ݺ��� �ȿ��� ���Ǵ� Ű���� : break, continue
 * 
 * �ݺ��������� continue ����
 * continue : if�� ���� ��쿡 �ٷ� �Ʒ� �ڵ�(totla+= num;)�� �ǳʶٰ� �ݺ����� ��� �Ѵ� (�׷��� Ű���尡 skip�� �ƴ� continue
 * 
 */

public class BasicLoopingTest3 {
	public static void main(String[] args) {
		//main Method �Ʒ��� ���� ���ú��� --> ���ú����� �⺻���� ���� --> �ʱ�ȭ�ϰ� ����ؾ��Ѵ�.
		int num = 0;//�ʱ�ȭ
		int total = 0;
		
		for(num=1; num<=10; num++) {//���� int �־ ���� ������
			if(num % 2 == 0) continue;//if�� ���̸� �ٷ� �Ʒ� �ִ� ���� totla+= num;�� �ǳʶٰ� for�� �ݺ��Ѵ�
			//num % 2 == 0 --> ¦�� ǥ�� (Ȧ�� ǥ���� 1)
			total+= num;
		}
		System.out.println("1���� 100���� Ȧ���� ����"+total);

	}
}
