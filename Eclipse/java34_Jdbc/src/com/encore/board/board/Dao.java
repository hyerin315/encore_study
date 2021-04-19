package com.encore.board.board;

import java.util.ArrayList;

public interface Dao {
	void insert(Board b);
	ArrayList<Board> selectAll();
	Board selectByNum(int num);
	ArrayList<Board> selectByWriter(String writer);
	ArrayList<Board> selectByTitle(String title);
	void update(Board b);//번호로 찾아서 날짜, 제목, 내용수정
	void delete(int num);
}
