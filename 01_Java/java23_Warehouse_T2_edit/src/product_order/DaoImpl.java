package product_order;

public class DaoImpl implements Dao {
	private Order[] orders;
	private int cnt;
	
	public DaoImpl() {
		orders = new Order [30];
	}

	@Override
	public void insert(Order o) {
		if(cnt >= orders.length - 1) {
			System.out.println("배열 창. 주문등록 실패");
			return;
		}
		orders[cnt++] = o;
	}

	@Override
	public Order[] selectAll() {
		Order[] o = new Order[cnt];
		System.arraycopy(orders, 0, o, 0, cnt);
		return o;
	}

	@Override
	public Order select(int order_num) {
		for(Order o : orders) {
			if(o.getOrder_num() == order_num) {
				return o;
			}
		}
		return null;
	}

	@Override
	public void delete(int order_num) {
		int i;
		//주문 번호로 검색
		for(i=0; i < cnt; i++) {
			if(orders[i].getOrder_num() == order_num) {
				break;//찾으면 루프 나감
			}
		}
		if(i == cnt) {
			System.out.println("없는 주문 번호 입니다.");
		} else {
			if(orders[i].isPay_result()) {
				System.out.println("이미 결제한 상품은 취소 불가");
				return;
			}
			for(int j=i; j<cnt-1; j++) {
				orders[j] = orders[j + 1];
			}
			cnt--;
		}
	}

	@Override
	public void update_pay(int order_num) {
		Order o = select(order_num);
		if(o == null) {
			System.out.println("없는 주문번호");
		} else {
			o.setPay_result(true);
		}
	}
	
	
	//공장쪽 출고 처리시 사용
	@Override
	public void update_out(int order_num) {
		Order o = select(order_num);
		if(o == null) {
			System.out.println("없는 상품");
		} else {
			o.setOut_result(true);
		}
	}
	
	//결제를 안한 주문목록 반환
	@Override
	public Order[] selectByPayFalse() {
		Order[] o = new Order[cnt];
		Order dest[] = null;
		int c = 0;//검색된 객체 카운트
		for(Order s : orders) {
			if(s.isPay_result()) {
				o[c++] = s;
			}
		}
		if(c==0) {
			System.out.println("결제 대상이 없습니다.");
			return null;
		}
		dest = new Order[c];		
		System.arraycopy(o, 0, dest, 0, c);
		return dest;
	}

	//공장에서 사용 - 출고대상 넘겨주는 거(온라인 주문서 전송과 같은 개념)
	@Override
	public Order[] selectByOutFalse() {
		Order[] o = new Order[cnt];
		Order[] dest = null;
		int c = 0;//검색된 객체 카운트
		for(Order s : orders) {
			if(s.isPay_result() && s.isOut_result()) {
				o[c++] = s;
			}
		}
		if(c==0) {
			System.out.println("결제 대상이 없습니다.");
			return null;
		}
		dest = new Order[c];		
		System.arraycopy(o, 0, dest, 0, c);
		return dest;
	}

	
	
}
