package com.encore.banking.test;

import com.encore.banking.Account;
import com.encore.banking.Customer;

public class BankingTest1 {

	public static void main(String[] args) {
		//1. 객체 생성
		Customer c1 = new Customer("James", 1234);
		//2. james라는 고객이 잔액이 1만원인 통장을 개설
		c1.setAccount(new Account(10000.0));//생성과 동시에 주입한다.
		//3. james가 개설한 통장을 받아와서
		Account jamesAcc=c1.getAccount();
		//4. 7천원을 입금, 2천원을 입금, 5천원을 출금
		jamesAcc.deposit(7000.0);
		jamesAcc.deposit(2000.0);
		jamesAcc.withdraw(5000.0);
		//5. 최종적인 잔액을 확인...14,000원이 맞는지 출력하는 프로그램
		System.out.println("James Account Ballanse :: "+jamesAcc.getBalance());

	}

}
