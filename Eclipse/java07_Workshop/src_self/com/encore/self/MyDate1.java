package com.encore.self;

public class MyDate1 {
	public int year;
	public int month;
	public int day;
	
	public MyDate1(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getMyDate1Info() {
		return year+"년 "+month+"월 "+day+"일 제조";
	}
}
