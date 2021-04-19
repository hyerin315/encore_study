package array.reference.service;

import array.reference.vo.Product;

//1. 모든 제품의 브랜드 명을 출력하는 기능을 정의 (메소드를 짜야함)
//2. 모든 제품의 총가격을 리턴하는 기능을 정의
//3. 모든 제품의 평균가격을 리턴하는 기능을 정의
//4. 100만원 이상의 고가제품의 정보를 출력하는 기능을 정의
//5. 특정한 회사 제품을 리턴하는 기능을 정의
//오늘 할 것 : 1~5번까지의 기능을 정의 (선언부+구현부)

public class ProductService {
	public void printAllBrand(Product[ ] pros) {//모든 상품에 대한 브랜드 이름을 출력해야하기 때문에 배열이 들어가야함 --> 서비스와 프로덕트의 인자값으로 Hasing
		for(Product p : pros) System.out.print(p.getBrand()+" ");
	}
	public int getTotalPrice(Product[ ] pros) {//리턴타입이 있을 때는 반드시 선언하고 구현해야함
		int total = 0;//초기화 반드시 첫 라인에서 하고 들어가야함
		for(Product p : pros) total += p.getPrice();
		//배열이니까 모두 돌면서 값을 쌓아야함 --> pros의 객체 하나하나를 Product p에 하나하나 객체가 들어와서 total += p.getPrice를 돌아가게 됨 (p는 여기서 선언됨) / pros는 테스트에서 불러와짐
		return total;//리턴은 해야하지만 에러 안나게 0으로 뒀다가 나중에 total로 바꿔줌
	}//퀀티티 반영 안되어서 다시 해야함
	public int getAvgPrice(Product[ ] pros) {
		//모든 제품의 총 가격을 구하고 그 값을 다시 배열의 사이즈로 최종적으로 나눈다 --> 이렇게 할 필요가 없음
		return getTotalPrice(pros)/pros.length;//위에 정의된 기능을 여기서 재사용(중요)한다 --> 총가격 호출 후 pros의 사이즈로 나눈다
	}
	public void printOverPrice(Product[ ] pros, int price) {
		for(Product p : pros) {
			if(p.getPrice()>=price)//price를 안 넣어주면 실제값이 들어감
				System.out.println(p.getBrand()+","+p.getPrice());
		}//for	
	}
	//String일 필요가 없음 --> Product가 여라개 컬렉션으로 리턴되어야함
	public Product[ ] getCertainBrand(Product[ ] pros,String brand) {
		Product[ ] products= new Product[pros.length];//1. 전체 상품 개수랑 같은 사이즈의 배열을 생성함 (4칸 --> null 값이 들어있음)
		//객체를 이 안에 집어넣어야하기 때문에 생성하고 들어가야함 (그리고 배열은 사이즈를 명시하고 들어가야하는데, 어떤 게 들어올지 모름 --> 그래서 pros.length
		//향상된 for문이 아님 --> 나중에 바꿔야함
	    /* for(int i=0; i<pros.length; i++) {
			if(pros[i].getBrand().equals(brand)) //브랜드 이름이 같을 때, 같은 인덱스에 값이 들어간다
			//equals와 ==의 차이
				products[i] = pros[i];
		}  */
		//향상된 for문
		int idx = 0;
		//향상된 for문은 인덱스가 없어도 내부적으로 돌아가서 하나하나를 뽑아 줄 수 있는데, 
		//우리가 idx역할 하는 것을 일부러 보여줘야지 하나하나 더해져서 올라갈 수 있기 때문에 명시하고 진행
		for(Product p : pros) {
			//2. 상품들 하나하나가 할당된다 (여기서 pros는 4칸짜리 배열인데 상품들이 꽉 차있음 --> 이 상품 하나하나를 Product p에 하나하나 할당 --> 그래서 4번 돌면서 상품을 하나하나 꺼내게 됨)
			//3. 꺼낸 이름이 내가 쓴 Apple과 같은지 비교하게 됨 --> 같으면 1. null 값에 Apple 브랜드를 가진 상품을 넣게 됨
			//4. 앞의 브랜드는 내가 적은 브랜드랑 달라서 안들어갔다는 건 앞에는 1. 그대로 null이 들어있고 뒤에 두개만 Apple이 들어 있음
			if(p.getBrand().equals(brand))//false라는 건 4칸에 값을 집어넣지 않는다는 것, true라는 것은 null 값이 Apple 값으로 바뀐다는 것
				products[idx++] = p;//향상된 for문에는 인덱스가 없음. idx역할을 할 것을 for문 앞에서 선언해주면 됨
				//idx++을 넣어줘야하지만 idx를 다시 안에 넣어줘도 됨
				//향상된 for문에서는 자신이 알아서 돌기 때문에 i를 쓰지 못하는데 idx역할을 할 것을 for문 앞에서 선언해주면 됨
		}
		return products;//그 Apple 2개를 돌게 됨
	}
}

