package array.reference.test;

import array.reference.service.ProductService;
import array.reference.vo.Product;

public class PersonServiceTest2 {
	public static void main(String[] args) {
		Product[ ] pros = {
				new Product("Hp", 120, 1),
				new Product("Samsung", 80, 2),
				new Product("Apple", 42, 3),
				new Product("Apple", 200, 2),
		};
		
		//1. ProductService ��ü�� ����
		//2. ProductService�� ����� ȣ��...�̶� ���ڰ� �˾Ƽ� �� ��������!
		
		ProductService ps = new ProductService(pros);
		
		System.out.println(ps.maxPriceProduct());
		
		
	}
}
