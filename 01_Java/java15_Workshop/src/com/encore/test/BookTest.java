package com.encore.test;


import java.util.Scanner;

import com.encore.manager.BookManager;
import com.encore.vo.Book;
import com.encore.vo.Magazine;

public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book("000010a", "�ճ��� �̿�����", "�̿���", "������̵��", 16000.0, "���� ������ ����� ��ȭ�� �Ұ��ϴ� �̿����� ��ȭ");
		Book b2 = new Book("000020a", "���� �ؼ�", "������Ʈ", "��������", 18000.0, "������ �ؼ����� ������Ʈ�� ���� ������ġ���� �󿡼� �Ⱓ�� ���źм��� ����");
		Book b3 = new Book("000030a", "�帣�� ����ó��", "�Ŀ�� �ڿ���", "���е���", 12000.0, "�� å�� �۰� �Ŀ�� �ڿ��ᰡ �ƴ� �ڿ��� �Ŀ�� �ڿ��Ḧ �����ش�.");
		Book b4 = new Book("000040a", "Ʈ���� �ڸ��� 2021", "�賭���� 21��", "�̷��� â", 16000.0, "���̷���ۡ ����, V-nomics(���̳�ͽ�) �ô��� ������ ���ϴ�");
		Book b5 = new Book("000050a", "���ڴ� �ɸ������̴�", "�ӵ巹 �ڽ����� ", "�̷��� â", 10000.0, "�������� ������, �ӵ巹 �ڽ����ϰ� ����ִ� ������ ���ۿ��� ��Ƴ���");
		
		Book[ ] bk = {b1, b2, b3, b4, b5};
		
		printBooks(bk);
	}
	

	private static void printBooks(Book[] bk) {
		
	}
}
