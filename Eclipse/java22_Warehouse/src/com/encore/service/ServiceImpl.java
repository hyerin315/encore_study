package com.encore.service;

import java.util.Scanner;

import com.encore.inter.Dao;
import com.encore.inter.DaoImpl;
import com.encore.vo.Product;

//기능 구현

public class ServiceImpl implements Service {
	private Dao dao;//저장소 작업에서 사용하려 멤버 변수로 정의
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addProduct(Scanner sc) {//배열에 추가 --> 배열 객체 Dao 필요

		System.out.print("name:");
		String name = sc.next();
		System.out.print("price:");
		int price = sc.nextInt();
		System.out.print("amount:");
		int amount = sc.nextInt();
		
		Product p = new Product(name, price, amount);
		dao.insert(p);
	}
	
	//혜린님 : 번호로 검색
	@Override
	public void getByNum(Scanner sc) {
		int num = sc.nextInt();
		Product p = dao.selectByNum(num);
		if(p==null)
			System.out.println("해당 번호가 존재하지 않습니다");
	}
	
	//혜린님 : 이름으로 검색
	@Override
	public void getByName(Scanner sc) {
		String name = sc.next();
		dao.selectByName(name);
	}
	
	//해영님 : 가격 수정
	@Override
	public void editProduct(Scanner sc) {
		boolean flag = false;
		System.out.print("가격 수정할 제품번호: ");
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
		else System.out.println("해당 제품은 존재하지 않습니다.");
	}
	
	//해영님 : 삭제
	@Override
	public void delProduct(Scanner sc) {
		boolean flag = false;
		System.out.print("삭제 할 제품번호: ");
		int num= sc.nextInt();
		for(Product p : dao.selectAll()) {
			if(p.getNum()==num)
				flag = true;
		}
		if (flag) dao.delete(num);
		else System.out.println("해당 제품은 존재하지 않습니다.");
	}
	
	//찬식님 : 전체 목록 출력
	@Override
	public void getAll()  {
		System.out.println("전체 목록 출력 메뉴를 선택하셨습니다.");
		Product[] product = dao.selectAll();	
		for(Product p : product) {
			if(p == null) {
				System.out.println("이 외에 상품이 없습니다.");
		} System.out.println(p.toString());
	  }	
    }
	
	//찬식님 : 입고
	@Override
	public void inProduct(Scanner sc) {
		System.out.println("입고하실 제품 번호를 입력해주세요 : ");
		int inProductNum = sc.nextInt();
		System.out.println("입고하실 수량을 입력해주세요 : ");
		int inProductCnt = sc.nextInt();
		
		dao.in_out(inProductNum, inProductCnt);
		
		System.out.println("수량을 확인해주세요.");
		getByNum(sc);
	}

	//찬식님 : 출고
		@Override
		public void outProduct(Scanner sc) {
			
			System.out.println("출고하실 제품 번호를 입력해주세요 : ");
			int outProductNum = sc.nextInt();
			System.out.println("출고하실 수량을 입력해주세요 : ");
			int outProductCnt = sc.nextInt();
			
			dao.in_out(-outProductNum, outProductCnt);
			
			System.out.println("수량을 확인해주세요.");
			getByNum(sc);
		}
}
