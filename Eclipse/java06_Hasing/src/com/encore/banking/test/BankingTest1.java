package com.encore.banking.test;

import com.encore.banking.Account;
import com.encore.banking.Customer;

public class BankingTest1 {

	public static void main(String[] args) {
		//1. ��ü ����
		Customer c1 = new Customer("James", 1234);
		//2. james��� ���� �ܾ��� 1������ ������ ����
		c1.setAccount(new Account(10000.0));//������ ���ÿ� �����Ѵ�.
		//3. james�� ������ ������ �޾ƿͼ�
		Account jamesAcc=c1.getAccount();
		//4. 7õ���� �Ա�, 2õ���� �Ա�, 5õ���� ���
		jamesAcc.deposit(7000.0);
		jamesAcc.deposit(2000.0);
		jamesAcc.withdraw(5000.0);
		//5. �������� �ܾ��� Ȯ��...14,000���� �´��� ����ϴ� ���α׷�
		System.out.println("James Account Ballanse :: "+jamesAcc.getBalance());

	}

}
