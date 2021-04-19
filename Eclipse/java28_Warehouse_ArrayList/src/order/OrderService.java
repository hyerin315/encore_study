package order;

import java.util.Scanner;

public interface OrderService {
	void addOrder(Order o);// 주문
	void getAll();// 주문목록
	Order getOrder(int order_num);// 주문번호로 하나 검색
	void cancelOrder(Scanner sc);// 주문취소. 결제완료시 취소 안됨
	void pay(Scanner sc);// 결제처리. 주문번호로 찾아서 pay_result를 true.
	Order[] getByPayFalse();// 결제대상. pay_result가 false인 것만 검색해서 반환
	Order[] getByOutFalse();//출고대상.
}
