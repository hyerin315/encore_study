package com.encore.vo;

public class MyDate {
	int day;
	int month;
	int year;
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public String getMyDate() {
		return year+"-"+month+"-"+day;
	}
}
