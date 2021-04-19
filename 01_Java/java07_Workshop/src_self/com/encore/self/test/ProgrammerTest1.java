package com.encore.self.test;

import com.encore.self.MyDate1;
import com.encore.self.NoteBook1;
import com.encore.self.Programmer1;

public class ProgrammerTest1 {

	public static void main(String[] args) {
		NoteBook1 noteBook = new NoteBook1(15483, "MacBook pro", new MyDate1(2020, 1, 1), 3800000.0F);
		Programmer1 pro = new Programmer1("Tomas", "C++", 3800000, 1000000);
		pro.buyNoteBook1(noteBook);
		NoteBook1 tomasNoteBook = pro.getNoteBook1();
		
		System.out.println("[구매 노트북 정보]");
		System.out.println(tomasNoteBook.getNoteBook1());
		System.out.println("\n[Tomas 정보]");
		pro.printProgrammer1Info();
		System.out.println(tomasNoteBook.getNoteBook1());
		System.out.println("\n[Tomas의 연봉]");
		System.out.println(pro.getAnnualSalary()+"원");	
	}

}
