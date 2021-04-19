package com.encore.self.test;

import com.encore.self.MyDate;
import com.encore.self.NoteBook;
import com.encore.self.Programmer;
/*
 * 1. ���� �ۼ��� �ڵ带 �帳�ϴ�.
 * 2. �������� �ۼ��� �κа� ���ؼ�
 * 3. �ڵ带 �ϼ��Ͻñ� �ٶ��ϴ�.
 * 4. �Ʒ� ���̴� 2���� �������� ���� �ذ��� �ֽñ� �ٶ��ϴ�.
 */
public class ProgrammerTest {

	public static void main(String[] args) {
		NoteBook noteBook = new NoteBook(123, "HP", new MyDate(2020, 1, 1), 1000000.0F);
		Programmer pro = new Programmer("James", "Java", 5000000, 1000000);
		pro.buyNoteBook(noteBook);
		NoteBook jamesNoteBook = pro.getNoteBook();
		
		System.out.println("James�� ������ ��Ʈ���� �����Դϴ�....\n");
		// �Ʒ� �ּҰ��� ������ �κ��� ������ ��µǵ��� �ذ��ϼ���~
		System.out.println(jamesNoteBook.getNoteBookInfo()); //!!
		System.out.println("\n James�� �����Դϴ�......");
		pro.printProgrammerInfo();
		System.out.println(pro.getProgrammer());//!!!
		System.out.println("\n James�� �����Դϴ�......");
		System.out.println(pro.getAnnualSalary()+"�� !!");	
	}

}
