package com.encore.inter;
import java.awt.Frame;
//�ڹ��� ��� - ���� ���, ���� ��� �Ұ� - �������̽������� ����

//Frame�̸鼭 �������� -- Frame�� ��ӹ����鼭 ������(Runnable) ��ӵ� ����
//Runnable : Thread ��� �������̽�, �����带 ����� ���� ��ӹ޴� �������̽� 
//           (���� ��ӿ��� ���, ���� ����̶�� extends Thread ���)

//ä��  - �ٸ� ��� �޼��� �����κ��� �޾Ƽ� ȭ�鿡 ���
//    - ���� �Է��� �޼����� ������ ����
//    --> ���ÿ� 2���� ���� �������� ���� == ���ÿ� 2���� ���� �����ؾ���

class Test extends Frame implements Runnable{//������� ���ü� ���α׷��� © �� ���� ��
//implements ������ �������̽��� �� --> �������̽��� ��ӹ޴� Ű����� implements == ���߻�� ����
//extends ������ Ŭ���� �̸�

	@Override
	public void run() {
        for (int i=0; i<10; i++) {
        	this.setTitle("������ ���: "+i);
        	try {
        		Thread.sleep(1000);
        	} catch (InterruptedException e) {
        		e.printStackTrace();
        	}
        }
	}
}

public class UIThreadMain {
	public static void main(String[] args) {
		Test t = new Test();
		t.setSize(500, 200);//Frame â�� ����, ���� ũ�� ����
		t.setVisible(true);//ȭ�鿡 ���ϲ���?
		Thread th = new Thread(t);
		th.start();
	}
}
