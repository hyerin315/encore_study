package array.reference.test;
/*
 * 1. 객세 생성
 * 2. 서비스 클래스에 있는 메소드 호출
 */

import array.reference.service.OutletStoreService;
import array.reference.vo.Customer;
import array.reference.vo.Product;

public class OutletStoreServiceTest3 {
	public static void main(String[] args) {
		Customer c1 = new Customer(111, "손흥민", "방배동");
		Customer c2 = new Customer(222, "안정환", "서초동");
		Customer c3 = new Customer(333, "박지성", "여의도");
		Customer[ ] customs = {c1, c2};
		
		Product[] pros1 = {
				new Product("신라면", 30000, 3),
				new Product("라일락샴푸", 20000, 2),
				new Product("건조기", 150000, 1),
		};
		
		Product[] pros2 = {
				new Product("새우깡", 2500, 7),
				new Product("하이타이", 80000, 2),
				new Product("울트라세탁기", 2330000, 1),
				new Product("면도기", 1000, 3)
		};
		
		customs[0].buyProduct(pros1);
		customs[1].buyProduct(pros2);
		
		OutletStoreService service = new OutletStoreService();
		
		//////////////////////////Service Method Calling//////////////////////////////
		
		System.out.println("=======1. 구매하신 상품 이름 정보입니다.===============");
		String[ ] brands=service.getAllBrand(customs[0]);
		for(String s : brands)  System.out.println(s);
		
		
		System.out.println("=======2. Outlet 전체 고객 명단 정보입니다.==============");
		Customer[ ] rCust=service.getAllCustomer(customs);
		for(Customer c : rCust) {
			System.out.println(c.getName()+","+c.getAddress());
			System.out.println("-------------------------------");
		}
		
		System.out.println("=======3. 특정 고객 명단 정보입니다.==============");
		Customer rCustomer=service.getACustomer(customs, 222);
		System.out.println(rCustomer.getName()+", "+rCustomer.getAddress());
		
		
		System.out.println("=======4. 특정 고객의 최고가 상품정보입니다.==============");
		int maxPrice=service.maxPriceProduct(customs[1]);
		System.out.println(maxPrice);
		
		
		System.out.println("=======5. 평균가 이상되는 상품들 정보입니다.==============");	
		Product[ ] rProduct=service.getMoreAvgProduct(customs[1]);
		for(Product p : rProduct) {
			if(p==null) continue; //if(p==!null) 가능
			System.out.println(p.getBrand()+","+p.getPrice());
        }
	}
}
