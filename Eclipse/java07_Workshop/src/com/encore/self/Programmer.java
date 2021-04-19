package com.encore.self;

public class Programmer {
	public String name;
	public String tech;
	public int salary;
	public int bonus;
	
	//
	public NoteBook noteBook;
	
	
	public Programmer(String name, String tech, int salary, int bonus) {
		this.name = name;
		this.tech = tech;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}

	public void printProgrammerInfo() {
		System.out.println(name+","+tech);
	}
	
	public int getAnnualSalary() {
		return salary * 12 + bonus;
	}
	
	public String getProgrammer() {
		return name+","+tech+","+noteBook.getNoteBookInfo()+","+salary;
	}	
}

