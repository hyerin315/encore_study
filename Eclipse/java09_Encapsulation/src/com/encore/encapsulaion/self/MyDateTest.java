package com.encore.encapsulaion.self;
import java.util.Scanner;
import com.encore.encapsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyDate m = new MyDate();
		
		System.out.println("���� �Է��ϼ���");
		int month = sc.nextInt();
		
		System.out.println("���� �Է��ϼ���");
		int day = sc.nextInt();
		
		String message = "��";
		switch (month) {
		       case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 : case 8 : case 9 : case 10 : case 11 : case 12 : 
		    	   message = month+"��";
		           break;	       		       
	           default:
	        	   System.out.println("�ش��ϴ� ���� �ƴմϴ�.");
				   break;
			          
				   

        if(abs(month/2)>0) System.out.println(month+"�� "+day+"��");
        else if(m.getMonth()!=0 && m.getDay()!=0) System.out.println(month+"����"+day+"�� ��¥�� �ƴմϴ�.");
        else System.out.println("Try Again...");
		}

	}

	private static int abs(int i) {
		return 0;
	}
}
