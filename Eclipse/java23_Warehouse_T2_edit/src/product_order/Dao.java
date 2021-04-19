package product_order;
//주문, 주문목록, 주문취소, 결제, 출고대상 출력
public interface Dao {
	void insert(Order o);//주문
	Order[] selectAll();//주문 목록
	Order select(int order_num);//주문 번호로 하나 검색
	void delete(int order_num);//주문 취소 - 결제 완료시 취소 안됨
	void update(int order_num);//결제처리 - 주문번호로 찾아서 pay_result를 true처리
	Order[] selectByPayFalse();//결제대상 - pay_result가 false인 것만 검색해서 배열에 담아 반환
	Order[] selectByOutFalse();//출고대상 - out_result가 false이고 pay_result가 true인 것만 검색해서 반환
}
