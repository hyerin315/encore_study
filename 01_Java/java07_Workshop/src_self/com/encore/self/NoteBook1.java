package com.encore.self;

public class NoteBook1 {
	public int serialNumber;
	public String model;
	public MyDate1 madeDate;
	public float price;
	
	public NoteBook1(int serialNumber, String model, MyDate1 madeDate, float price) {
		this.serialNumber = serialNumber;
		this.model = model;
		this.madeDate = madeDate;
		this.price = price;
	}
	
	public String getNoteBook1() {
		return model+" ("+serialNumber+", "+madeDate.getMyDate1Info()+") "+":: "+price+"¿ø";
	}

	public void printNoteBook1Info() {
		System.out.println(model+" ("+serialNumber+") "+":: "+price);
	
		
		
	}
	
	


}
