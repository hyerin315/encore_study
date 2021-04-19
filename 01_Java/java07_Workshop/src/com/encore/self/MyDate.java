package com.encore.self;

//제조 연월일에 관한 정보를 저장하는 클래스
public class MyDate {
	public int year;
	public int month;
	public int day;
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getMyDate() {
		return year+"-"+month+"-"+day;
	}
}