package com.encore.board;

import java.util.Scanner;

import com.encore.board.member.Dao;
import com.encore.board.member.DaoImpl;
import com.encore.board.member.Member;

public class Main {
	public static void main(String[] args) {
		Dao dao = new DaoImpl();
		//dao.insert(new Member("bbb", "111", "nameb", "bbb@email.com"));
		//System.out.println(dao.select("aaa"));
		Scanner sc = new Scanner(System.in);
		Menu m = new Menu();
		m.run(sc);
	}
}