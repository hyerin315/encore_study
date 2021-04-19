package com.encore.self.test;

import com.encore.self.MyDate;
import com.encore.self.NoteBook;
import com.encore.self.Programmer;
/*
 * 1. 지금 작성한 코드를 드립니다.
 * 2. 여러분이 작성한 부분과 비교해서
 * 3. 코드를 완성하시기 바랍니다.
 * 4. 아래 보이는 2가지 문제점은 직접 해결해 주시기 바랍니다.
 */
public class ProgrammerTest {

	public static void main(String[] args) {
		NoteBook noteBook = new NoteBook(123, "HP", new MyDate(2020, 1, 1), 1000000.0F);
		Programmer pro = new Programmer("James", "Java", 5000000, 1000000);
		pro.buyNoteBook(noteBook);
		NoteBook jamesNoteBook = pro.getNoteBook();
		
		System.out.println("James가 구매한 노트북의 정보입니다....\n");
		// 아래 주소값이 나오는 부분을 정보가 출력되도록 해결하세요~
		System.out.println(jamesNoteBook.getNoteBookInfo()); //!!
		System.out.println("\n James의 정보입니다......");
		pro.printProgrammerInfo();
		System.out.println(pro.getProgrammer());//!!!
		System.out.println("\n James의 연봉입니다......");
		System.out.println(pro.getAnnualSalary()+"원 !!");	
	}

}
