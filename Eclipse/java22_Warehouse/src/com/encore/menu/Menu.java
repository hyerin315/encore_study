package com.encore.menu;

import java.util.Scanner;
import com.encore.service.Service;
import com.encore.service.ServiceImpl;

public class Menu {
	public Service service;
	
	public Menu() {
		service = new ServiceImpl();
	}
		public void run(Scanner sc) {
			boolean flag = true;
			
			while(flag) {
				System.out.println("1.제품등록 2.번호로 검색 3.이름으로 검색. 4.가격수정 5.삭제  6.전체제품 출력 7.입고 8.출고 9.종료");
				int m = sc.nextInt();
				switch (m) {
				case 1:
					service.addProduct(sc);
					break;
				case 2:
					service.getByNum(sc);
					break;
				case 3:
					service.getByName(sc);
					break;
				case 4:
					service.editProduct(sc);
					break;
				case 5:
					service.delProduct(sc);
					break;
				case 6:
					service.getAll();
					break;
				case 7:
					service.inProduct(sc);
					break;
				case 8:
					service.outProduct(sc);
					break;
				case 9:
					flag = false;
					break;
				}
			}
		}
	}
