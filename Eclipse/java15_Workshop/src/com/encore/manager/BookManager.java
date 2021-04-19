package com.encore.manager;

import com.encore.vo.Book;

public class BookManager {
	Book[] list;
	int numberOfBooks;
	
	//1. å�� ����
	public BookManager(int numberOfBooks) {
		list = new Book[numberOfBooks];
	}
	
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	
	//2. å �߰�
	public void insertBook(Book newBook) {
		for(int i=0; i<list.length; i++) {
			if(list[i]==null) {
				list[i] = newBook;
				numberOfBooks++;
				break;
			}
		}
	}
	
	//3. å ��ü �ҷ�����
	public Book[ ] getAllBook(Book[ ] bk) {
		Book[ ] bo = new Book[bk.length];
		int idx = 0;
		for(Book b : bk) bo[idx++] = b;
		return bo;
	}
	
	//4. isbn���� å ã��
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
	
	//5. title�� å ã��
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
	
	//6. ���ǻ�� å ã��
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
	
	//7. �������� å ã��
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
	
	//8. å ���� ���ϱ�
	public double getSumPriceOfBooks() {
		double sum=0;
		for(int i=0; i<list.length; i++) {
			if(list[i]==null) continue;
			sum += list[i].getPrice();
			}
		return sum;
		}

	//9. å���� ���� ���
	public double getAvgPriceOfBooks() {
		return getSumPriceOfBooks()/numberOfBooks;
	}


}
