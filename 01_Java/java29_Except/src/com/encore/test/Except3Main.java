package com.encore.test;

//throw
//���� ��� �޼��� 3����

class MyNumExeption extends Exception{//������ �ؼ� ���� ������ �̷��� Ŭ���� ���� �ᵵ �� (�ٵ� �̰� �Ⱦ��� �׳� Exception���� ������ ��)
	public MyNumExeption(String msg) {
		super(msg);
	}
}

class MyNum {
	private int num;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) throws MyNumExeption {
		if(num < 1 || num > 5) {//���� ���� ���� �ƴϸ� ���� �߻�
			throw new MyNumExeption("num ���� 1~5�� ����");//���� �߻�
		}
		this.num = num;
	}
}

public class Except3Main {

	public static void main(String[] args) {
		MyNum mn = new MyNum();
		try {
			mn.setNum(3);
			System.out.println(mn.getNum());
			mn.setNum(8);
			System.out.println(mn.getNum());
		} catch (MyNumExeption e) {
			//���� �߻��� ��� ��� 3����
			System.out.print("1.stakc trace: ");
			e.printStackTrace();//���ܸ� �������� �����ϸ鼭 ���
			System.out.println("2.e:"+ e);//toString() ��ȯ�� ���, ���� Ŭ������ ��ϵ� ���� �޼��� ��ȯ�ϵ��� ������
			System.out.println("3.getMessage():" + e.getMessage());//���� Ŭ������ ��ϵ� ���� �޼��� ��ȯ
		}
		System.out.println("���α׷� ������ �����");
	}
}
