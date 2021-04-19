package com.encore.inter;

//연동 연습

public class Daoimpl_Oracle implements Dao {

	@Override
	public void insert() {
		System.out.println("Oracle insert");

	}

	@Override
	public void select() {
		System.out.println("Oracle select");

	}

	@Override
	public void update() {
		System.out.println("Oracle update");

	}

	@Override
	public void delete() {
		System.out.println("Oracle delete");

	}
}
