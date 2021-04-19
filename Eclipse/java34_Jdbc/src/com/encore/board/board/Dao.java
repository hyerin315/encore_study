package com.encore.board.board;

import java.util.ArrayList;

public interface Dao {
	void insert(Board b);
	ArrayList<Board> selectAll();
	Board selectByNum(int num);
	ArrayList<Board> selectByWriter(String writer);
	ArrayList<Board> selectByTitle(String title);
	void update(Board b);//��ȣ�� ã�Ƽ� ��¥, ����, �������
	void delete(int num);
}
