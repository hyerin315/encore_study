package com.encore.test;


import java.util.Scanner;

import com.encore.manager.BookManager;
import com.encore.vo.Book;
import com.encore.vo.Magazine;

public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book("000010a", "먼나라 이웃나라", "이원복", "고려원미디어", 16000.0, "세계 각국의 역사와 문화를 소개하는 이원복의 만화");
		Book b2 = new Book("000020a", "꿈의 해석", "프로이트", "돋을새김", 18000.0, "《꿈의 해석》은 프로이트가 쓰고 라이프치히와 빈에서 출간한 정신분석학 저서");
		Book b3 = new Book("000030a", "흐르는 강물처럼", "파울로 코엘료", "문학동네", 12000.0, "이 책은 작가 파울로 코엘료가 아닌 자연인 파울로 코엘료를 보여준다.");
		Book b4 = new Book("000040a", "트렌드 코리아 2021", "김난도외 21명", "미래의 창", 16000.0, "바이러스發 경제, V-nomics(브이노믹스) 시대의 전략을 말하다");
		Book b5 = new Book("000050a", "투자는 심리게임이다", "앙드레 코스톨라니 ", "미래의 창", 10000.0, "전설적인 투자자, 앙드레 코스톨라니가 들려주는 투자의 정글에서 살아남기");
		
		Book[ ] bk = {b1, b2, b3, b4, b5};
		
		printBooks(bk);
	}
	

	private static void printBooks(Book[] bk) {
		
	}
}
