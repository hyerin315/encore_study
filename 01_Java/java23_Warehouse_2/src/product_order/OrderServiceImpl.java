package product_order;

import java.util.Scanner;

import product_order.DaoImpl;
import warehouse.Product;
import product_order.Dao;

public class OrderServiceImpl implements OrderService {
	private Dao dao;
	public OrderServiceImpl() {
		dao = new DaoImpl();
	}
	
	//�ֹ� (�¿���)
	@Override
	public void addOrder(Scanner sc) {// �迭 �߰�. ���: �ֹ���ȣ, ��ǰ��, ����, �����ݾ� �Է¹޾Ƽ� ����
		System.out.println("==== �ֹ� ��� =========");
		System.out.print("prod_num:");
		int prod_num = sc.nextInt();
		System.out.print("amount:");
		int amount = sc.nextInt();
		System.out.print("Product p");
		Product p = sc.next();
		
		
		Order o = new Order(prod_num, amount, p);
		dao.insert(o);
	}

	//�ֹ���� (����)
	@Override
	public Order[] getAll() {
			return dao.selectAll();
	}
	
	public void printAll() {
		Order[] arr = dao.selectAll();
		for(Order o : arr) {
			System.out.println(o);
		}
	}

	//�ֹ���ȣ�� �ϳ� �˻� (�ؿ�)
	@Override
	public Order getOrder(Scanner sc) {
		//System.out.println("==== �ֹ� ��ȣ�� �˻� ====");
		System.out.println("�ֹ� ��ȣ: ");
		int order_num = sc.nextInt();
		return dao.select(order_num);
	}
	
	//�ֹ����. �����Ϸ�� ��� �ȵ� (���Ĵ�)
	@Override
	public void cancelOrder(Scanner sc) {
		System.out.println("�ֹ���� �޴��� �����ϼ̽��ϴ�. ���� �Ϸ�� �׸��� ��� �ȵ˴ϴ�. �ֹ���ȣ�� �Է����ּ���.");
		int tempInt = sc.nextInt();
		dao.delete(tempInt);
		System.out.println("���������� �ֹ� ��� �Ǿ����ϴ�.");
	}
	
	//����ó��. �ֹ���ȣ�� ã�Ƽ� pay_result�� true. (�¿���)
	@Override
	public void pay(Scanner sc) {
		System.out.println("==== ����ó�� =========");
		System.out.print("�ֹ���ȣ:");
		int num = sc.nextInt();
		System.out.print("price:");
		
		
		Order o = dao. select(num);
		int price = sc.nextInt();
		if(num ==price) {
			 dao.update(num);
			 System.out.print("������ �Ϸ�Ǿ����ϴ�.");
			o.setPay_result(true);
		}else {
			System.out.print("�̰����Դϴ�.");
			o.setPay_result(false);
		}
	}
	
	//�������. pay_result�� false�� �͸� �˻��ؼ� ��ȯ (������)
	@Override
	public Order[] getByPayFalse() {
		return dao.selectByPayFalse();
	}
	
	//�����. (������)
	public Order[] getByOutFalse() {
		System.out.println("=======��ǰ ���======");
		return dao.selectByOutFalse();
	}
	
}