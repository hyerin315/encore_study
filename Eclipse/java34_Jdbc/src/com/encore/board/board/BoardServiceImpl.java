package com.encore.board.board;

import java.util.ArrayList;
import java.util.Scanner;

import com.encore.board.member.MemServiceImpl;

public class BoardServiceImpl implements BoardService {
	private Dao dao;
	
	public BoardServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addBoard(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====���ۼ�====");

		Board b = new Board();
		b.setWriter(MemServiceImpl.getLogin_id());

		System.out.print("title:");
		sc.nextLine();//���� �� �ۼ����� �� ��� ���Ͱ� �����־ �Է��� �ȹ޾ƹ����ϱ�, nextLine�� �������
		String title = sc.nextLine();

		System.out.print("content(���߷��� /stop):");
		StringBuilder st = new StringBuilder(); //������ �ݺ������� �Ҷ��� StringBuilder�� ����

		while (true) {
			String str = sc.nextLine();
			if (str.startsWith("/stop")) {
				break;
			}
			st.append(str+"\n");//���͸� �����ؾ���, �츮�� ���͸� ġ�� �װ� ������ ���� ����
		}
		
		String content = st.toString();
		b.setTitle(title);
		b.setContent(content);
		dao.insert(b);
	}
	

	@Override
	public void printAll(ArrayList<Board> list) {
		System.out.println("====�۸��====");
		for (Board b : list) {
			System.out.println(b);
		}
	}

	@Override
	public void getByNum(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====�� ��ȣ�� �˻�====");
		System.out.print("�˻��� �۹�ȣ:");
		int num = sc.nextInt();
		Board b = dao.selectByNum(num);
		if (b == null) {
			System.out.println("���� �۹�ȣ");
		} else {
			System.out.println(b);
		}
	}

	@Override
	public ArrayList<Board> getByWriter(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====�� �ۼ��ڷ� �˻�====");
		System.out.print("�˻��� �ۼ��� ���̵�:");
		String writer = sc.next();
		ArrayList<Board> list = dao.selectByWriter(writer);
		return list;
	}

	@Override
	public ArrayList<Board> getByTitle(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====�� �������� �˻�====");
		System.out.print("�˻��� �ܾ�:");
		String title = sc.next();
		ArrayList<Board> list = dao.selectByTitle(title);
		return list;
	}
	
	public boolean checkMyArticle(int num) {//�α��� �� ����� ������ üũ
		Board b = dao.selectByNum(num);
		if (b != null && b.getWriter().equals(MemServiceImpl.getLogin_id())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void editBoard(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====�� ����====");
		System.out.print("������ �۹�ȣ:");
		int num = sc.nextInt();
		boolean flag = checkMyArticle(num);
		if (flag) {
			System.out.print("�� ����:");
			String title = sc.next();
			System.out.print("�� ����:");
			String content = sc.next();
			dao.update(new Board(num, "", null, title, content));
		} else {
			System.out.println("���� ���̰ų� ���� ���� �ƴ�");
		}
	}

	@Override
	public void delBoard(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====�� ����====");
		System.out.print("������ �۹�ȣ:");
		int num = sc.nextInt();
		boolean flag = checkMyArticle(num);
		if (flag) {
			dao.delete(num);
		} else {
			System.out.println("���� ���̰ų� ���� ���� �ƴ�");
		}
	}
	
	@Override
	public ArrayList<Board> getAll() {
		// TODO Auto-generated method stub
		System.out.println("====�� ��ü���====");
		ArrayList<Board> list = dao.selectAll();
		return list;
	}
}
