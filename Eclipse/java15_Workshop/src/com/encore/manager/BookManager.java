package com.encore.manager;

import com.encore.vo.Book;

public class BookManager {
	Book[] list;
	int numberOfBooks;
	
	//1. 책의 개수
	public BookManager(int numberOfBooks) {
		list = new Book[numberOfBooks];
	}
	
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	
	//2. 책 추가
	public void insertBook(Book newBook) {
		for(int i=0; i<list.length; i++) {
			if(list[i]==null) {
				list[i] = newBook;
				numberOfBooks++;
				break;
			}
		}
	}
	
	//3. 책 전체 불러오기
	public Book[ ] getAllBook(Book[ ] bk) {
		Book[ ] bo = new Book[bk.length];
		int idx = 0;
		for(Book b : bk) bo[idx++] = b;
		return bo;
	}
	
	//4. isbn으로 책 찾기
	public Book searchBook(String isbn) {
		Book temp = null;
		for(Book b : list) {
			if(b != null) {
				if(b.getIsbn().equals(isbn)) {
					temp = b;
				}
			}
		}
	return temp;
	}
	
	//5. title로 책 찾기
	public Book searchBookByTitle(String title) {
		Book temp1 = null;
		for(Book b : list) {
			if(b != null) {
				if(b.getTitle().equals(title)) {
					temp1 = b;
				}
			}
		}
	return temp1;	
	}
	
	//6. 출판사로 책 찾기
	public Book searchBookByPublisher(String publisher) {
		Book temp2 = null;
		for(Book b : list) {
			if(b != null) {
				if(b.getPublisher().equals(publisher)) {
					temp2 = b;
				}
			}
		}
	return temp2;	
	}
	
	//7. 가격으로 책 찾기
	public Book searchBookByPrice(double price) {
		Book temp3 = null;
		for(Book b : list) {
			if(b != null) {
				if(b.getPrice()==price) {
					temp3 = b;
				}
			}
		}
	return temp3;
	}
	
	//8. 책 값을 더하기
	public double getSumPriceOfBooks() {
		double sum=0;
		for(int i=0; i<list.length; i++) {
			if(list[i]==null) continue;
			sum += list[i].getPrice();
			}
		return sum;
		}

	//9. 책들의 가격 평균
	public double getAvgPriceOfBooks() {
		return getSumPriceOfBooks()/numberOfBooks;
	}


}
