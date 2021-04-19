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
		
		//1. ProductService 객체를 생성
		//2. ProductService의 기능을 호출...이때 인자값 알아서 잘 넣으세요!
		
		ProductService ps = new ProductService(pros);
		
		System.out.println(ps.maxPriceProduct());
		
		
	}
}
