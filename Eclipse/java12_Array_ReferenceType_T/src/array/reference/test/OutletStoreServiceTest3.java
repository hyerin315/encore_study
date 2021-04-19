package array.reference.test;
/*
 * 1. ���� ����
 * 2. ���� Ŭ������ �ִ� �޼ҵ� ȣ��
 */

import array.reference.service.OutletStoreService;
import array.reference.vo.Customer;
import array.reference.vo.Product;

public class OutletStoreServiceTest3 {
	public static void main(String[] args) {
		Customer c1 = new Customer(111, "�����", "��赿");
		Customer c2 = new Customer(222, "����ȯ", "���ʵ�");
		Customer c3 = new Customer(333, "������", "���ǵ�");
		Customer[ ] customs = {c1, c2};
		
		Product[] pros1 = {
				new Product("�Ŷ��", 30000, 3),
				new Product("���϶���Ǫ", 20000, 2),
				new Product("������", 150000, 1),
		};
		
		Product[] pros2 = {
				new Product("�����", 2500, 7),
				new Product("����Ÿ��", 80000, 2),
				new Product("��Ʈ��Ź��", 2330000, 1),
				new Product("�鵵��", 1000, 3)
		};
		
		customs[0].buyProduct(pros1);
		customs[1].buyProduct(pros2);
		
		OutletStoreService service = new OutletStoreService();
		
		//////////////////////////Service Method Calling//////////////////////////////
		
		System.out.println("=======1. �����Ͻ� ��ǰ �̸� �����Դϴ�.===============");
		String[ ] brands=service.getAllBrand(customs[0]);
		for(String s : brands)  System.out.println(s);
		
		
		System.out.println("=======2. Outlet ��ü �� ��� �����Դϴ�.==============");
		Customer[ ] rCust=service.getAllCustomer(customs);
		for(Customer c : rCust) {
			System.out.println(c.getName()+","+c.getAddress());
			System.out.println("-------------------------------");
		}
		
		System.out.println("=======3. Ư�� �� ��� �����Դϴ�.==============");
		Customer rCustomer=service.getACustomer(customs, 222);
		System.out.println(rCustomer.getName()+", "+rCustomer.getAddress());
		
		
		System.out.println("=======4. Ư�� ���� �ְ� ��ǰ�����Դϴ�.==============");
		int maxPrice=service.maxPriceProduct(customs[1]);
		System.out.println(maxPrice);
		
		
		System.out.println("=======5. ��հ� �̻�Ǵ� ��ǰ�� �����Դϴ�.==============");	
		Product[ ] rProduct=service.getMoreAvgProduct(customs[1]);
		for(Product p : rProduct) {
			if(p==null) continue; //if(p==!null) ����
			System.out.println(p.getBrand()+","+p.getPrice());
        }
	}
}
