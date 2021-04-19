package product;

import java.util.Scanner;

import order.Order;
import order.OrderService;
import order.OrderServiceImpl;
import warehouse.Product;
import warehouse.Service;
import warehouse.ServiceImpl;

public class Menu {
	private Service service;//창고 서비스
	private OrderService o_service;//주문 서비스

	public Menu() {
		service = new ServiceImpl();
		o_service = new OrderServiceImpl();
	}

	public void run(Scanner sc) {//상위 메뉴
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

	public void make_order(Scanner sc) {// 창고와 편의점 기능이 함께 필요해서 메뉴에서 구현
		System.out.println("======= 주문 ========");
		service.printAll();
		Product p = null;
		int num = 0;
		while (p == null) {
			System.out.print("주문할 제품 번호:");
			num = sc.nextInt();
			p = service.getByNum(num);
		}
		System.out.print("주문수량:");
		int amount = sc.nextInt();
		Order o = new Order(amount, p);
		o_service.addOrder(o);
	}

	public void run_o(Scanner sc) {// 하위 메뉴-주문
		boolean flag = true;

		while (flag) {
			System.out.println("1.주문 2.주문취소 3.주문목록 4.결제 5.종료");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				make_order(sc);
				break;
			case 2:
				o_service.cancelOrder(sc);
				break;
			case 3:
				o_service.getAll();
				break;
			case 4:
				o_service.pay(sc);
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}

	public void run_p(Scanner sc) {//하위 메뉴-창고
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
