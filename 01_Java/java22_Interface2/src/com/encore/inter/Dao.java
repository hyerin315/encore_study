package com.encore.inter;

//�������̽� : ����� �߻�޼ҵ�θ� ������ ���� �߻� Ŭ����
//JDBC(java databases connectivity) : �ڹٶ� ������ ���̽� �������ִ� �������̽�
//--> �ڹٴ� �� �������̽��� �ٸ� ȸ�翡 �����ؼ� ���� ������ ���� ȸ����� �ڱ� ��ǰ�� �°� ����(ex.����Ŭ, SQL ���) --> �̰� ����̹�

//DAO�� Ŭ������ ������ �ʰ� �������̽��� ���� ����
//- �ٸ� �ڵ�� �����ϴ� �� ���� (�ٸ� �ڵ�� ������ �ٿ��� �� �� �ִ� ����)
//
public interface Dao {//Database Access object - DB ��� Ŭ����
	void insert();
	void select();
	void update();
	void delete();
	
}
