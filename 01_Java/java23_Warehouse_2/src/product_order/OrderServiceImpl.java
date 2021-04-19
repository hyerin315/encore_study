package product_order;

import java.util.Scanner;

import product_order.DaoImpl;
import warehouse.Product;
import product_order.Dao;

public class OrderServiceImpl implements OrderService {
	private Dao dao;
	public OrderServiceImpl() {
		dao = new DaoImpl();
	}
	
	//주문 (승연님)
	@Override
	public void addOrder(Scanner sc) {// 배열 추가. 등록: 주문번호, 제품명, 수량, 결제금액 입력받아서 저장
		System.out.println("==== 주문 등록 =========");
		System.out.print("prod_num:");
		int prod_num = sc.nextInt();
		System.out.print("amount:");
		int amount = sc.nextInt();
		System.out.print("Product p");
		Product p = sc.next();
		
		
		Order o = new Order(prod_num, amount, p);
		dao.insert(o);
	}

	//주문목록 (혜린)
	@Override
	public Order[] getAll() {
			return dao.selectAll();
	}
	
	public void printAll() {
		Order[] arr = dao.selectAll();
		for(Order o : arr) {
			System.out.println(o);
		}
	}

	//주문번호로 하나 검색 (해영)
	@Override
	public Order getOrder(Scanner sc) {
		//System.out.println("==== 주문 번호로 검색 ====");
		System.out.println("주문 번호: ");
		int order_num = sc.nextInt();
		return dao.select(order_num);
	}
	
	//주문취소. 결제완료시 취소 안됨 (찬식님)
	@Override
	public void cancelOrder(Scanner sc) {
		System.out.println("주문취소 메뉴를 선택하셨습니다. 결제 완료된 항목은 취소 안됩니다. 주문번호를 입력해주세요.");
		int tempInt = sc.nextInt();
		dao.delete(tempInt);
		System.out.println("정상적으로 주문 취소 되었습니다.");
	}
	
	//결제처리. 주문번호로 찾아서 pay_result를 true. (승연님)
	@Override
	public void pay(Scanner sc) {
		System.out.println("==== 결제처리 =========");
		System.out.print("주문번호:");
		int num = sc.nextInt();
		System.out.print("price:");
		
		
		Order o = dao. select(num);
		int price = sc.nextInt();
		if(num ==price) {
			 dao.update(num);
			 System.out.print("결제가 완료되었습니다.");
			o.setPay_result(true);
		}else {
			System.out.print("미결제입니다.");
			o.setPay_result(false);
		}
	}
	
	//결제대상. pay_result가 false인 것만 검색해서 반환 (소정님)
	@Override
	public Order[] getByPayFalse() {
		return dao.selectByPayFalse();
	}
	
	//출고대상. (동관님)
	public Order[] getByOutFalse() {
		System.out.println("=======제품 출고======");
		return dao.selectByOutFalse();
	}
	
}