package com.encore.banking;
//���忡 ���� ����
public class Account {
	public double balance; //10,000

	public Account(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	}
	
	//�������� �ݾ��� �Ա��ϴ� ���...����(����� + ������)
	public void deposit(double amount) { //5,000
    	// balance=balance+amount;
    	balance += amount;
	}
	//�������� �ݾ��� ����ϴ� ���...	����(����� + ������)
	public void withdraw(double amount) {
		balance -= amount;
		
	}
    
}
