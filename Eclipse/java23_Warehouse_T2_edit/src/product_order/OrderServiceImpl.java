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
	
	//주문
	@Override
	public void addOrder(Order o) {
		dao.insert(o);
	}

	//주문목록
	@Override
	public void getAll() {//주문내역
		Order[] o = dao.selectAll();
		for(Order x : o) {
			System.out.println(x);
		}
	}

	//주문번호로 하나 검색 (해영)
	@Override
	public Order getOrder(int order_num) {
		//System.out.println("==== 주문 번호로 검색 ====");
		return dao.select(order_num);
	}
	
	//주문취소. 결제완료시 취소 안됨 (찬식님)
	@Override
	public void cancelOrder(Scanner sc) {
		System.out.println("주문취소 메뉴를 선택하셨습니다.");
		getAll();
		System.out.println("취소할 주문 번호를 입력해주세요");
		int nem = sc.nextInt();
	}
	
	//결제처리. 주문번호로 찾아서 pay_result를 true. (승연님)
	@Override
	public void pay(Scanner sc) {
		System.out.println("==== 결제처리 =========");
		Order[] o = getByPayFalse();
		if(o==null) {
			return;
		}
		
		for(Order x : o) {
			System.out.println(x);
		}
		System.out.print("결제할 주문번호:");
		int num = sc.nextInt();
		dao.update(num);
		
	}
	
	//결제대상
	@Override
	public Order[] getByPayFalse() {
		return dao.selectByPayFalse();
	}
	
	//출고대상
	public Order[] getByOutFalse() {
		return dao.selectByOutFalse();
	}
	
}