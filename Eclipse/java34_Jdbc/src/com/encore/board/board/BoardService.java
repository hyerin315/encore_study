package com.encore.board.board;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public interface BoardService {
	void addBoard(Scanner sc);//���ۼ�
	void printAll(ArrayList<Board> list);//�۸��(��ȣ, ����, �ۼ���)
	ArrayList<Board> getAll();
	void getByNum(Scanner sc);//�� ��ȣ �Է¹޾� �˻�
	ArrayList<Board> getByWriter(Scanner sc);//�ۼ��� �Է¹޾� �ۼ��ڷ� �˻�
	ArrayList<Board> getByTitle(Scanner sc);//���� �Ϻ� �Է¹޾� �������� �˻�
	void editBoard(Scanner sc);//��ȣ, ������, ������ �Է¹޾� ����
	void delBoard(Scanner sc);//�� ��ȣ �Է¹޾� ����
}