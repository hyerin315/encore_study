package array.reference.test;

import array.reference.vo.Product;

public class PersonArrayTest1 {
	public static void main(String[] args) {
		/*
		 * Product 객체를 3개 생성
		 * 생성된 3개의 객체를 배열에 집어 넣는다
		 * (Product 배열 안에는 Product 타입의 객체만 들어감)
		 */
/*		Product pro1 = new Product("Hp", 120, 1);
		Product pro2 = new Product("Samsung", 80, 2);
		Product pro3 = new Product("Apple", 42, 3);
		
		Product[ ] pros = new Product[3]; */
		
		Product[ ] pros = {
				new Product("Hp", 120, 1),
				new Product("Samsung", 80, 2),
				new Product("Apple", 42, 3),
				new Product("Apple", 200, 2),
		};//위의 방법과 똑같음
		
		
		System.out.println("배열의 주소값: "+pros);
		System.out.println("===============배열의 객체를 참조하는 주소값===========");
		for(int i=0; i<pros.length; i++) 
			System.out.println(pros[i].getDetails());
		
		//위의 방법과 똑같음
		System.out.println("===============배열의 객체를 참조하는 주소값 :: 향상된 for문을 사용===========");
		for(Product p:pros) System.out.println(p.getDetails());
		
		
		/* 
		 * 1) pros 배열 안에 있는 각 제품들의 브랜드 명만 출력하세요
		 * 2) pros 배열 안에 있는 제품들 중에서 100만원이 넘는 고가의 제품의 이름과 가격을 출력하세요
		 * 3) pros 배열 안에 있는 제품들의 총 가격을 출력하세요
		 * 4) pros 배열 안에 있는 제품들의 평균가격을 출력하세요
		 */
		
		
		//호출과 동시에 기능이 짬뽕되어 있음 (이건 정보 저장 vo인데 기능 짬뽕이 되어 잇음 x) 
		//--> 그래서 기능만 가지고 있는 클래스를 따로 만들것 = 강사님은 보통 ~ Service라는 이름을 붙임 / ~ Manager로 끝나는 경우도 있음 == 기능을 핸들링하고 있구나
		//1) pros 배열 안에 있는 각 제품들의 브랜드 명만 출력하세요
		System.out.println("각 제품의 브랜드 이름입니다...");
		for(Product p : pros) System.out.print(p.getBrand());
		
		//2) pros 배열 안에 있는 제품들 중에서 100만원이 넘는 고가의 제품의 이름과 가격을 출력하세요
		System.out.println("100만원 이상 가격의 제품입니다...");
		for(Product p : pros) {
			if (p.getPrice()>=100) System.out.println(p.getBrand()+","+p.getPrice());
		}
		
		//3) pros 배열 안에 있는 제품들의 총 가격을 출력하세요
		int total = 0;
		for (Product p : pros) total += p.getPrice();
		System.out.println("제품의 총 가격입니다....."+total+" 만원");
		
		//4) pros 배열 안에 있는 제품들의 평균가격을 출력하세요
		
		
	}
}
