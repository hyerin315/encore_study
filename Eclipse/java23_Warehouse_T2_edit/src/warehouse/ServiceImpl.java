package warehouse;

import java.util.Scanner;

import product_order.Order;

//��� ����

public class ServiceImpl implements Service {
	private Dao dao;//����� �۾����� ����Ϸ� ��� ������ ����
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}

	//1.��ǰ���
	@Override
	public void addProduct(Scanner sc) {//�迭�� �߰� --> �迭 ��ü Dao �ʿ�
		
		System.out.println("====��ǰ���====");
		System.out.print("name:");
		String name = sc.next();
		System.out.print("price:");
		int price = sc.nextInt();
		System.out.print("amount:");
		int amount = sc.nextInt();
		
		Product p = new Product(name, price, amount);
		dao.insert(p);
	}
	
	//2.��ȣ �˻�
	@Override
	public Product getByNum(int num) {
		return dao.selectByNum(num);
	}
	
	//_��ȣ�˻� ���
	@Override
	public void printProductByNum(Scanner sc) {
		System.out.println("====��ǰ ��ȣ�� �˻�====");
		System.out.println("�˻��� ��ǰ��ȣ :");
		int num = sc.nextInt();
		Product p = dao.selectByNum(num);
		if(p == null) {
			System.out.println("���� ��ǰ ��ȣ");
	}else {
		System.out.println(p);
		}
	}

	//3.�̸����� �˻�
	@Override
	public void getByName(Scanner sc) {
		System.out.println("====��ǰ �̸����� �˻�====");
		System.out.print("�˻��� ��ǰ�� :");
		String name = sc.next();
		Product[] arr = dao.selectByName(name);
		if(arr == null) {
			System.out.println("���� ��ǰ�Դϴ�.");
		}else {
			for(Product p : arr) {
				System.out.println(p);
			}
		}
	}
	
	//4.���ݼ��� 
	@Override
	public void editProduct(Scanner sc) {
		System.out.println("====��ǰ ���� ����====");
		System.out.print("������ ��ǰ��ȣ :");
		int num = sc.nextInt();
		System.out.print("������ ���� :");
		int price = sc.nextInt();
		dao.update(num, price);
	}
	
	//5.��ǰ����
	@Override
	public void delProduct(Scanner sc) {
		System.out.println("====��ǰ ����====");
		System.out.println("������ ��ǰ��ȣ :");
		int num = sc.nextInt();
		dao.delete(num);
	}
	
	//6.��ü��ǰ ��� 
	@Override
	public Product[] getAll()  {
		return dao.selectAll();
    }
	
	//__��ü ��ǰ ���
	@Override
	public void printAll() {
		Product[] arr = dao.selectAll();
		for(Product p : arr) {
			System.out.println(p);
		}
	}
	
	//7.�԰� & 8.���
	//__�԰�
	@Override
	public void inProduct(Scanner sc) {
		System.out.println("=====��ǰ �԰�=====");
		System.out.println("�԰��Ͻ� ��ǰ ��ȣ�� �Է����ּ��� : ");
		int num = sc.nextInt();
		System.out.println("�԰��Ͻ� ������ �Է����ּ��� : ");
		int a= sc.nextInt();
		dao.in_out(num, a);
	}
	
	//__���
	@Override
	public void outProduct(Order[] orders) {
		System.out.println("�غ���...order�� �Բ� �ϼ� ����");
		System.out.println("\n=====��ǰ ���=====");
		for(Order o : orders) {
			boolean flag = dao.in_out(o.getProd().getNum(), -o.getAmount());
			if(flag) {
				o.setOut_result(true);
				System.out.print("���ó�� �Ϸ� : ");
				System.out.println(o);
			}
		}
	}
}
