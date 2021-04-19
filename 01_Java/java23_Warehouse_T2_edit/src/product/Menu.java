package product;

import java.util.Scanner;

import product_order.Order;
import product_order.OrderService;
import product_order.OrderServiceImpl;
import warehouse.Service;
import warehouse.ServiceImpl;

public class Menu {
	private Service service;//창고 서비스
	private OrderService o_service;//주문 서비스

	public Menu() {
		service = new ServiceImpl();
		o_service = new OrderServiceImpl();
	}
	
	//상위메뉴
	public void run(Scanner sc) {
		boolean flag = true;

		while (flag) {
			System.out.println("1.창고 2.편의점 3.종료");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				run_p(sc);
				break;
			case 2:
				run_o(sc);
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}
	
	//하위메뉴 - 주문
	public void run_o(Scanner sc) {
		boolean flag = true;

		while (flag) {
			System.out.println("1.주문 2.주문취소 3.주문목록 4.결제 5.종료");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				o_service.printAll();
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}
	}
	
	//하위메뉴 - 창고
	public void run_p(Scanner sc) {
		boolean flag = true;

		while (flag) {
			System.out.println("1.제품등록 2.번호로 검색 3.이름으로 검색 4.가격수정 5.삭제 6.전체목록 7.입고 8.출고 9.종료");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				service.addProduct(sc);
				break;
			case 2:
				service.printProductByNum(sc);
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
				service.printAll();
				break;
			case 7:
				service.inProduct(sc);
				break;
			case 8:
				Order[] orders = o_service.getByOutFalse();
				service.outProduct(orders);
				break;
			case 9:
				flag = false;
				break;
			}
		}
	}
}