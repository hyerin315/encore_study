package com.encore.test;

import java.util.Scanner;

import com.encore.service.Menu;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu m = new Menu();
		m.select(sc);
		m.run(sc);
	}
}
