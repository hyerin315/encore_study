package com.encore.banking;
/*
 * ������ �����ϴ� ���� ������ ��� �ִ� Ŭ����
 * Account�� Customer�� Hasing�Ѵ�
 * �̷� Ŭ���� ���� ���踦 Has a Relation�̶� �Ѵ�
 * 1. �ʵ忡 �������� �ϴ� Ŭ������ ����
 *    Account a;
 * 2. ���� --> setter
 */
public class Customer {
	public String name;
	public int ssn;
	//1. �ʵ忡 �������� �ϴ� Ŭ������ ����
	public Account account;
	//�̸��� account�� �ϴ� ���� -- Ŭ���� �̸��� �Ȱ��� �ؾ��� (��, ù��° ���ڴ� �ҹ��ڷ�! �����ϱ�)
	//���� ���� �������� 1. �Ȱ��� �����ִ� ��  2. �� ���ڸ� �ҹ��ڷ� �����ִ� ��
	public Customer(String name, int ssn) {
		this.name = name;
		this.ssn = ssn;
	}	
	public void setAccount(Account account) {
		this.account = account;
	}	
	public String getName() {
		return name;
	}
	public int getSsn() {
		return ssn;
	}
	public Account getAccount() {
		return account;
	}



	

	
	
	
}
