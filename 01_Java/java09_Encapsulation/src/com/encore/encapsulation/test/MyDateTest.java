package com.encore.encapsulation.test;
import java.util.Scanner;

/* 
 * 1. Scanner �� �̿��ؼ� month, day�� �ش��ϴ� ���� �޴´�.
 * 2. month�� �ش��ϴ� ���� 1~12������ ���� �ް� �������� ���� �޼����� ��� -> "�̿� �ش��ϴ� ���� �ƴմϴ�."
 *    day�� 
 *    1,3,5,7,8,10,12���� 1~31��
 *    4,6,9,11���� 1~30��
 *    2���� 1~28�ϱ����� ���� ������
 *    --> If, switch���� �� �� ����ϼ���
 * 3. "�ش��ϴ� ���� �ƴմϴ�."
 *    "�ش��ϴ� ��¥�� �ƴմϴ�."
 *    --> �Ѵ� True�϶��� ���
 *    "������ 1�� 4���Դϴ�."
 *    "������ 0�� 4���Դϴ�." --> X
 *    "������ 4�� 0���Դϴ�." --> X
 */
import com.encore.encapsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//Ű����� ���� �޾Ƶ��̰ڴ� (�̰� Test ���ο��� ����)
		MyDate md = new MyDate();
		System.out.println("���Է�>>");
		int month = sc.nextInt();//�Է°��� month�� �޴´�
		System.out.println("��¥�Է�>>");
		int day = sc.nextInt();
		//md.setMonth(13);
		//md.setDay(33);
		//�� �ڵ��� ������? --> �ϵ��ڵ�
		//Invalid�� ���� �ٷ� �ʵ忡 ���Եȴ�. --> Direct Access = �߸��� ���� ���ԵǾ ���� �� ����
		/*md.month = 13; =  13�� ���� --> public�� �ƴϱ� ������ ������ ��, private�̱� ������ ������� ���� ����(�ִµ� �Ⱥ��̴� ��)
		md.day = 33;  =  33���� ���� */		
		
		// ���� ������ setter()�� �Ѵ�.
		md.setMonth(month);//MyDateŬ������ �ִ� setMonth�� �̵��Ѵ� (calling...���ڰ��� passing into)
		md.setDay(day);//setDay�޼ҵ� callingȣ��...���ڰ��� passing into
		
        //if(md.getMonth()!=0 && md.getDay()!=0)//0�� ������ �ȵ��ư��� �Է�
		System.out.println("������ "+md.getMonth()+"�� "+md.getDay()+"�� �Դϴ�.");//0�� 5��
	}
}
//�ڵ带 ������ ���� ������ ������ ���� �� --> ���� �� ����
//�ڵ带 92% �ذ��϶� �׷��� 2���� 