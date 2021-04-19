package com.encore.encapsulaion.self;
import java.util.Scanner;
import com.encore.encapsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyDate m = new MyDate();
		
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();
		
		System.out.println("일을 입력하세요");
		int day = sc.nextInt();
		
		String message = "월";
		switch (month) {
		       case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 : case 8 : case 9 : case 10 : case 11 : case 12 : 
		    	   message = month+"월";
		           break;	       		       
	           default:
	        	   System.out.println("해당하는 월이 아닙니다.");
				   break;
			          
				   

        if(abs(month/2)>0) System.out.println(month+"월 "+day+"일");
        else if(m.getMonth()!=0 && m.getDay()!=0) System.out.println(month+"월과"+day+"은 날짜가 아닙니다.");
        else System.out.println("Try Again...");
		}

	}

	private static int abs(int i) {
		return 0;
	}
}
