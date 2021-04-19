package com.encore.banking;
//통장에 대한 정보
public class Account {
	public double balance; //10,000

	public Account(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	}
	
	//일정량의 금액을 입금하는 기능...정의(선언부 + 구현부)
	public void deposit(double amount) { //5,000
    	// balance=balance+amount;
    	balance += amount;
	}
	//일정량의 금액을 출금하는 기능...	정의(선언부 + 구현부)
	public void withdraw(double amount) {
		balance -= amount;
		
	}
    
}
