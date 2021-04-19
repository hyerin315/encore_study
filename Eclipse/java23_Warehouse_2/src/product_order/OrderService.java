package product_order;
import java.util.Scanner;

public interface OrderService {
	void addOrder(Scanner sc);//주문
	Order[] getAll();//주문 목록
	void printAll();//주문 목록 출력
	Order getOrder(Scanner sc);//주문 번호로 하나 검색
	void cancelOrder(Scanner sc);//주문 취소 - 결제 완료시 취소 안됨
	void pay(Scanner sc);//결제처리 - 주문번호로 찾아서 pay_result를 true처리
	Order[] getByPayFalse();//결제대상 - pay_result가 false인 것만 검색해서 배열에 담아 반환
	Order[] getByOutFalse();//출고대상 - out_result가 false인 것만 검색해서 반환
}
