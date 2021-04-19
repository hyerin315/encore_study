package product;

import java.util.Scanner;

import product_order.OrderService;
import product_order.OrderServiceImpl;
import warehouse.Service;
import warehouse.ServiceImpl;

public class Menu {
	private Service service;// ���� ����
	private OrderService o_service;// �ֹ� ����

	public Menu() {
		service = new ServiceImpl();
		o_service = new OrderServiceImpl();
	}
	
	//order service
	public void run(Scanner sc) {
		boolean flag = true;

		while (flag) {
			System.out.println("1.���� 2.������ 3.����");
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
	public void run_o(Scanner sc) {
		boolean flag = true;

		while (flag) {
			System.out.println("1.�ֹ� 2.�ֹ���� 3.�ֹ���� 4.���� 5.����");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				break;
			case 3:
				o_service.printAll();
				break;
			}
		}
	}
	
	//warehouse Product service
	public void run_p(Scanner sc) {
		boolean flag = true;

		while (flag) {
			System.out.println("1.��ǰ��� 2.��ȣ�� �˻� 3.�̸����� �˻� 4.���ݼ��� 5.���� 6.��ü��� 7.�԰� 8.��� 9.����");
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
				service.outProduct(sc);
				break;
			case 9:
				flag = false;
				break;
			}
		}
	}
}