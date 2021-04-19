package array.reference.service;
//1. 모든 제품의 브랜드 명을 출력하는 기능을 정의 (메소드를 짜야함)
//2. 모든 제품의 총가격을 리턴하는 기능을 정의
//3. 모든 제품의 평균가격을 리턴하는 기능을 정의
//4. 100만원 이상의 고가제품의 정보를 출력하는 기능을 정의
//5. 특정한 회사 제품을 리턴하는 기능을 정의
//오늘 할 것 : 1~5번까지의 기능을 정의 (선언부+구현부)

import array.reference.vo.Product;

public class ProductService {
	//hr.크기 할당 및 초기화 없이 배열과 참조변수만 선언
	private Product[] product;
	//생성자 혹은 setter로 받음
	public ProductService(Product[] p) {
		product = p;
	}
	//1. 모든 제품의 브랜드 명을 출력하는 기능을 정의
/*	public void getAllBrand() {
		System.out.println("[모든 제품의 브랜드명 출력]");
	} */
	
	//4. 100만원 이상의 고가제품의 정보를 출력하는 기능을 정의
	public int maxPriceProduct(Product product) {
		int max = 100;
		for(Product product : p.getPrice()) {
			if(product.getPrice() >= max) {
				max = product.getPrice();
			}
		}
		


}

	

}
