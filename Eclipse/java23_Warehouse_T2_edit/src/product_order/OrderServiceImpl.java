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
	
	//�ֹ�
	@Override
	public void addOrder(Order o) {
		dao.insert(o);
	}

	//�ֹ����
	@Override
	public void getAll() {//�ֹ�����
		Order[] o = dao.selectAll();
		for(Order x : o) {
			System.out.println(x);
		}
	}

	//�ֹ���ȣ�� �ϳ� �˻� (�ؿ�)
	@Override
	public Order getOrder(int order_num) {
		//System.out.println("==== �ֹ� ��ȣ�� �˻� ====");
		return dao.select(order_num);
	}
	
	//�ֹ����. �����Ϸ�� ��� �ȵ� (���Ĵ�)
	@Override
	public void cancelOrder(Scanner sc) {
		System.out.println("�ֹ���� �޴��� �����ϼ̽��ϴ�.");
		getAll();
		System.out.println("����� �ֹ� ��ȣ�� �Է����ּ���");
		int nem = sc.nextInt();
	}
	
	//����ó��. �ֹ���ȣ�� ã�Ƽ� pay_result�� true. (�¿���)
	@Override
	public void pay(Scanner sc) {
		System.out.println("==== ����ó�� =========");
		Order[] o = getByPayFalse();
		if(o==null) {
			return;
		}
		
		for(Order x : o) {
			System.out.println(x);
		}
		System.out.print("������ �ֹ���ȣ:");
		int num = sc.nextInt();
		dao.update(num);
		
	}
	
	//�������
	@Override
	public Order[] getByPayFalse() {
		return dao.selectByPayFalse();
	}
	
	//�����
	public Order[] getByOutFalse() {
		return dao.selectByOutFalse();
	}
	
}