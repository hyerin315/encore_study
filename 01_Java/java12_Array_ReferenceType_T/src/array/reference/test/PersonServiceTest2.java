package array.reference.test;
//1. ProductService 객체를 생성
//2. ProductService의 기능을 호출...이때 인자값 알아서 잘 넣으세요!

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
		
		ProductService service = new ProductService();
		System.out.println("1. 모든 제품의 브랜드 명을 출력합니다...");
		service.printAllBrand(pros);
		
		System.out.println("\n2. 모든 제품의 총가격을 출력합니다...");
		System.out.println(service.getTotalPrice(pros)+"만원");//리턴된 값을 출력하기 위해서 sysout 해줘야함
		
		System.out.println("3. 모든 제품의 평균가격을 출력합니다...");
		System.out.println(service.getAvgPrice(pros)+"만원");//리턴된 값을 출력하기 위해서 sysout 해줘야함

		System.out.println("4. 100만원 이상의 고가제품의 정보를 출력합니다...");
		service.printOverPrice(pros, 100);
		
		System.out.println("5. 특정한 회사 제품을 출력합니다...");
		Product[ ] products = service.getCertainBrand(pros, "Apple");//Service에서 배열 리턴되면
		for(Product p : products) {
			if(p==null)continue;//동일한 객체의 브랜드를 못만났으면 스킵하고 다음으로 간다
			System.out.println(p.getDetails());//여기서 출력시 null을 만나게 되면 비정상적으로 종료하게 됨
		}

	}
}
