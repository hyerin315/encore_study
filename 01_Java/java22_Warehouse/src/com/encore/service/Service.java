package com.encore.service;
import java.util.Scanner;

//��� ��

public interface Service {
	void addProduct(Scanner sc);//���
	void getByNum(Scanner sc);//��ȣ�� �˻�
	void getByName(Scanner sc);//�̸����� �˻�
	void editProduct(Scanner sc);//���� ����
	void delProduct(Scanner sc);//����
	void getAll();//��ü�˻�
	void inProduct(Scanner sc);//�԰�
	void outProduct(Scanner sc);//���
	
}
