package com.encore.service;

import com.encore.vo.Movie;
public class MovieMgr {
	private Movie[ ] movies = new Movie[100];
	private int index;
	
	//�̱���...MovieMgr�� mgr�̸����� ��ü ����...getInstance�� ������ ��ü�� �޾ƿ´�.
	//
	
	public void add(Movie m) {
		
	}
	
	public Movie[] search() {
		
		return null;
	}
	
	public Movie[] search(String title) {
		int temp = 0;
		return null;
	}

	public Movie[] searchDirector(String name) {
		int size = 0;
		return null;
	}

	public Movie[] searchGenre(String genre) {
		return null;
	}

	public void delete(String title) {
		
		
	}
	
	public int getSize() {
		return index;
	}
}







