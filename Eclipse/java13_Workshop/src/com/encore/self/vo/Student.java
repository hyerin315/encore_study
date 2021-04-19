package com.encore.self.vo;

import com.encore.self.vo.Student;

public class Student {
	
	private int ssn;
	private String name;
	private String address;
	private int age;
	private String hakbun;
	
	public Student(int ssn,String name, String address, int age, String hakbun) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.age = age;
		this.hakbun = hakbun;
	}
	
	public int getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}	
	public String getAddress() {
		return address;
	}
	public void changeAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHakbun() {
		return hakbun;
	}
	public void changeHakbun(String hakbun) {
		this.hakbun = hakbun;
	}	//
	
	public String getDetails() {
		return name+","+age+","+address+","+hakbun;
	}
}




