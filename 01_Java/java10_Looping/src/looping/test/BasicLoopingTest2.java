package looping.test;
/*
 * �ݺ��������� break ����
 * break�� �ݺ��� �ȿ��� ����ϴµ�
 * if���� �Բ� ���Ǿ 
 * �ش��ϴ� ������ true�̸� �ݺ����� ����������.
 * --> if���� ���������� �� �ƴ�
 */

public class BasicLoopingTest2 {
	public static void main(String[] args) {
		//main Method �Ʒ��� ���� ���ú��� --> ���ú����� �⺻���� ���� --> �ʱ�ȭ�ϰ� ����ؾ��Ѵ�.
		int num = 0;//�ʱ�ȭ
		int total = 0;
		
		for(num=1; num<=100; num++) {//���� int �־ ���� ������
			total+= num; 
			if(total>120) break;//120���� ũ�� �ݺ� ���ϵ��� break --> ���� ������ ����
		}
		System.out.println("1���� 100������ �� ����"+total);

	}
}
