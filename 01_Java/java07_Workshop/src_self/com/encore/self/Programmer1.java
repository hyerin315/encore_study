package com.encore.self;

public class Programmer1 {
	public String name;
	public String tech;
	public int salary;
	public int bonus;
	public NoteBook1 noteBook;
	
	
	public Programmer1(String name, String tech, int salary, int bonus) {
		this.name = name;
		this.tech = tech;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public void buyNoteBook1(NoteBook1 noteBook) {
		this.noteBook = noteBook;
	}
	
	public NoteBook1 getNoteBook1() {
		return noteBook;
	}
	
	
	public void printProgrammer1Info() {
		System.out.println(name+", "+tech+", ±Þ¿© :"+salary);
	}
	
	public int getAnnualSalary() {
		return salary * 12 + bonus;
	}
	
}