package com.encore.board;

import java.util.ArrayList;
import java.util.Scanner;

import com.encore.board.board.Board;
import com.encore.board.board.BoardService;
import com.encore.board.board.BoardServiceImpl;
import com.encore.board.member.MemService;
import com.encore.board.member.MemServiceImpl;


public class Menu {
	private MemService memService;
	private BoardService bService;

	public Menu() {
		memService = new MemServiceImpl();
		bService = new BoardServiceImpl();
	}

	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		while (flag) {
			System.out.println("1.ȸ������ 2.�Խ��� 3.����");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				mem_run(sc);
				break;
			case 2:
				if (MemServiceImpl.getLogin_id() == null) {
					System.out.println("�α��� ���� �Ͻÿ�");
				}else {
					b_run(sc);
				}
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}

	public void mem_run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		while (flag) {
			System.out.println("1.ȸ������ 2.�α��� 3.������Ȯ�� 4.���������� 5.�α׾ƿ� 6.Ż�� 7.����");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				memService.addMember(sc);
				break;
			case 2:
				memService.login(sc);
				break;
			case 3:
				memService.myInfo();
				break;
			case 4:
				memService.editInfo(sc);
				break;
			case 5:
				memService.logout(sc);
				break;
			case 6:
				memService.out();
				break;
			case 7:
				flag = false;
				break;
			}
		}
	}

	public void b_run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		ArrayList<Board> list = null;

		while (flag) {
			System.out.println("1.���ۼ� 2.�۸�� 3.�۹�ȣ�ΰ˻� 4.���ۼ��ڷΰ˻� 5.���������ΰ˻� 6.���� 7.���� 8.����");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				bService.addBoard(sc);
				break;
			case 2:
				list = bService.getAll();
				bService.printAll(list);
				break;
			case 3:
				bService.getByNum(sc);
				break;
			case 4:
				list = bService.getByWriter(sc);
				bService.printAll(list);
				break;
			case 5:
				list = bService.getByTitle(sc);
				bService.printAll(list);
				break;
			case 6:
				bService.editBoard(sc);
				break;
			case 7:
				bService.delBoard(sc);
				break;
			case 8:
				flag = false;
				break;
			}
		}
	}
}
