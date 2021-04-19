package com.encore.banking;
/*
 * 통장을 개설하는 고객의 정보를 담고 있는 클래스
 * Account를 Customer가 Hasing한다
 * 이런 클래스 간의 관계를 Has a Relation이라 한다
 * 1. 필드에 가지고자 하는 클래스를 선언
 *    Account a;
 * 2. 주입 --> setter
 */
public class Customer {
	public String name;
	public int ssn;
	//1. 필드에 가지고자 하는 클래스를 선언
	public Account account;
	//이름은 account로 하는 이유 -- 클래스 이름과 똑같이 해야함 (단, 첫번째 글자는 소문자로! 변수니까)
	//가장 좋은 변수명은 1. 똑같이 적어주는 것  2. 앞 글자를 소문자로 적어주는 것
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
