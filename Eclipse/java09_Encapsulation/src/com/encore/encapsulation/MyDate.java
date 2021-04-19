package com.encore.encapsulation;
/*
 * Encapsulation �ۼ��ϴ� ����
 * 1. Field - private ����
 * 2. setter() / getter() - public ����
 * 3. setter() �޼ҵ� ������ ù���ο���(�ʵ� �ʱ�ȭ �ϱ� ������) ����� �޾Ƽ� Ÿ���� ���� �Ҵ� �ǵ��� �Ѵ�.
 */
public class MyDate {
	private int month;//13
	private int day;//33
	
	public int getMonth() {
		return month;
	}
	//���� �����ϴ� ���...
	//void ������ ������ ���� �ʿ� ���� set ���� ���� �����ϴ��İ� �ڿ� ����
	//void setMonth(���ڰ�)
	public void setMonth(int month) {//Ű����� �Է��� ���� �� --> setMonth�� �ϴ� ���� �Ʒ� �����θ� ����� (setMonth�� ���� ���ִϱ�
		//�ʵ��ʱ�ȭ �ϱ� ������ ���۹����� ���� ���� Ÿ������ ���θ� �˻��ϰ� Ÿ���� ���� �ʵ忡 �Ҵ�
		if(month>=1 && month<=12) {//setMonth�� �ϴ� ���� Test���� ���� ���� 1~12������ ���̸� �ʵ� �ʱ�ȭ�� ���ְ�
			this.month = month;//������� ������ �ϰ� month�� �ش��ϴ� �´� ���� �˿�
		} else {//1~12�� �ش��ϴ� ���� �ƴҶ��� �Ʒ� �ؽ�Ʈ�� ��� --> �ʵ� �ʱ�ȭ�� �ȵ��� �ǹ� --> �⺻���� ���� �ǹ� == 0�� �Ҵ�Ǿ� �ִٴ� �̾߱�
			System.out.println("���� �մ��� ���� �ƴϴ�! (Invalid Month Value!!");//������� ���� �׽�Ʈ�� ���ư�
		}		
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {//void���� �ϴ� ����, String�� �ȵǴ� ������ ���� ���ԵǴ� �� �����̱� ������ void�� ����
		switch(month) {//���⼭�� month�� �ʵ��� month�� �������� �� --> setMonth()�� ���� �ʱ�ȭ�� �̹� �Ǿ��� �ִ� ���� (���ð� �ʵ� �̸��� �����Ҷ� ������ ���� this�� ����)
		//month�� �⺻���� 0�� ������ default�� ������ ��
		case 2://month�� 2������ ���
			if(day>=1 && day<=28) {
				this.day = day;
			}else {
				System.out.println("Invaild Day!");//�̰� ������ String�� ���� �� �ƴ�, ���� ���� �������� �˾ƾ���
				//return; �����ϰ� �Ǹ� ���� ȣ���� �������� ����! -->�ٽ� setDay�� ���� �� --> ������ �ذ��� �ȵ�
				//�������� �ذ� ��� --> �߸��� ���� ������ �� ���α׷��� ���������� ��
				System.exit(0);//0�̸� ��������...-1(����) ������ ����
			}
			break;
			
		case 4:
		case 6:
		case 9:
		case 11:
			if(day>=1 && day<=30) {
				this.day = day;
			}else {
				System.out.println("Invaild Day!");
				//return;
				System.exit(0);
		
			}
		break;
		
		default:
			if(day>=1 && day<=31) {
				this.day = day;
			}else {
				System.out.println("Invaild Day!");
				//return
				System.exit(0);
			}
		}//switch	
	}//setDay
}//class
