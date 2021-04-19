 package array.reference.service;

import array.reference.vo.Customer;
import array.reference.vo.Product;

/*
 * OuletStore에서 상품을 구매하는 고객의 기능을 모아놓은 서비스 클래스
 * 이 클래스는 이후에 DAO 클래스로 디벨롭 될 것이다.
 * 
 */
public class OutletStoreService {
	
	//총 5개의 기능 정의
	//1. 특정고객이 구입한 제품명
	public String[ ] getAllBrand(Customer vo) {//Coustomer을 알아야 구매한 제품명 반환 가능
		Product[ ] pros = vo.getProducts();
		String[ ] temp = new String[pros.length];//temp 잠시쓰고 말때 자주 씀
		
		int idx = 0;
		for(Product p : pros) temp[idx++] = p.getBrand();
		
		return temp;
	}
		
/*		if(vo.getProducts()!=null) {
			String[] brand = new String[vo.getProducts().length];
			int i = 0;
			for(Product p : vo.getProducts()) {
				brand[i++] = p.getBrand();
			}
			return brand;
		}
		return null;
		
	} */
	
	//2. 아울렛 전체 고객 명단
	public Customer[ ] getAllCustomer(Customer[] custs) {
		Customer[ ] cs = new Customer[custs.length];
		int idx = 0;
		for(Customer c : custs) cs[idx++] = c;
		return cs;
	}//무엇을 뽑을지는 Test에서 뽑을 것
	
	//3. 특정 고객 명단 정보
	public Customer getACustomer(Customer[] custs, int ssn) {//여러 고객 중에 ssn으로 찾겠다
		Customer cust = null;
		for(Customer c : custs) {
			if(c.getSsn()==ssn) //int 타입이기 때문에 == 사용 가능
				cust = c;
			}
			return cust;
		}

	//4.
	public int maxPriceProduct(Customer vo) {//인자값이 Customer인 건 특정 고객의 최고값만 하겠다
		int max = 0;
		Product[ ] pros=vo.getProducts();
		for(Product p : pros) {
			if(p.getPrice()>max) max = p.getPrice();
		}
		return max;

	}

	//5.
	public int getAvgPrice(Customer vo) {
		int total = 0;
		Product[] pros = vo.getProducts();
		for(Product p : pros) 
			total += p.getPrice();

			
		return total/pros.length;	
		
	}
	
	public Product[ ] getMoreAvgProduct(Customer vo) {
		Product[ ] pros=vo.getProducts();
		Product[ ] temp = new Product[pros.length];
		int idx = 0;
		for(Product p: pros) {
			if(p.getPrice()>=getAvgPrice(vo))
				temp[idx++] = p;
		}
		return temp;
	}
	
	//추가적으로 필요한 기능을 함께 구현하세요
}
