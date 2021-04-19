package com.encore.service;

import java.util.Scanner;

import com.encore.inter.Dao;
import com.encore.inter.DaoImpl;
import com.encore.vo.Product;

//��� ����

public class ServiceImpl implements Service {
	private Dao dao;//����� �۾����� ����Ϸ� ��� ������ ����
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addProduct(Scanner sc) {//�迭�� �߰� --> �迭 ��ü Dao �ʿ�

		System.out.print("name:");
		String name = sc.next();
		System.out.print("price:");
		int price = sc.nextInt();
		System.out.print("amount:");
		int amount = sc.nextInt();
		
		Product p = new Product(name, price, amount);
		dao.insert(p);
	}
	
	//������ : ��ȣ�� �˻�
	@Override
	public void getByNum(Scanner sc) {
		int num = sc.nextInt();
		Product p = dao.selectByNum(num);
		if(p==null)
			System.out.println("�ش� ��ȣ�� �������� �ʽ��ϴ�");
	}
	
	//������ : �̸����� �˻�
	@Override
	public void getByName(Scanner sc) {
		String name = sc.next();
		dao.selectByName(name);
	}
	
	//�ؿ��� : ���� ����
	@Override
	public void editProduct(Scanner sc) {
		boolean flag = false;
		System.out.print("���� ������ ��ǰ��ȣ: ");
		int num= sc.nextInt();
		ServiceImpl data= new ServiceImpl();
		for(Product p : dao.selectAll()) {
			if(p.getNum()==num)
				flag = true;
		}
		if (flag) {
			System.out.print("Price: ");
			int price= sc.nextInt();
			dao.update(num, price);
		}
		else System.out.println("�ش� ��ǰ�� �������� �ʽ��ϴ�.");
	}
	
	//�ؿ��� : ����
	@Override
	public void delProduct(Scanner sc) {
		boolean flag = false;
		System.out.print("���� �� ��ǰ��ȣ: ");
		int num= sc.nextInt();
		for(Product p : dao.selectAll()) {
			if(p.getNum()==num)
				flag = true;
		}
		if (flag) dao.delete(num);
		else System.out.println("�ش� ��ǰ�� �������� �ʽ��ϴ�.");
	}
	
	//���Ĵ� : ��ü ��� ���
	@Override
	public void getAll()  {
		System.out.println("��ü ��� ��� �޴��� �����ϼ̽��ϴ�.");
		Product[] product = dao.selectAll();	
		for(Product p : product) {
			if(p == null) {
				System.out.println("�� �ܿ� ��ǰ�� �����ϴ�.");
		} System.out.println(p.toString());
	  }	
    }
	
	//���Ĵ� : �԰�
	@Override
	public void inProduct(Scanner sc) {
		System.out.println("�԰��Ͻ� ��ǰ ��ȣ�� �Է����ּ��� : ");
		int inProductNum = sc.nextInt();
		System.out.println("�԰��Ͻ� ������ �Է����ּ��� : ");
		int inProductCnt = sc.nextInt();
		
		dao.in_out(inProductNum, inProductCnt);
		
		System.out.println("������ Ȯ�����ּ���.");
		getByNum(sc);
	}

	//���Ĵ� : ���
		@Override
		public void outProduct(Scanner sc) {
			
			System.out.println("����Ͻ� ��ǰ ��ȣ�� �Է����ּ��� : ");
			int outProductNum = sc.nextInt();
			System.out.println("����Ͻ� ������ �Է����ּ��� : ");
			int outProductCnt = sc.nextInt();
			
			dao.in_out(-outProductNum, outProductCnt);
			
			System.out.println("������ Ȯ�����ּ���.");
			getByNum(sc);
		}
}
