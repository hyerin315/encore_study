package com.encore.self;

public class NoteBook {
	public int serialNum;
	public String model;
	public MyDate madeDate;
	public float price;
	
	public NoteBook(int serialNum, String model, MyDate madeDate, float price) {
		this.serialNum = serialNum;
		this.model = model;
		this.madeDate = madeDate;
		this.price = price;
	}	
	
	public String getNoteBookInfo() {
		return model+","+price+","+madeDate.getMyDate();
	}
}
