package product_order;

public class DaoImpl implements Dao {
	private Order[] datas;
	private int cnt;
	
	public DaoImpl() {
		datas = new Order[30];
	}

	//주문 (승연님)
	@Override
	public void insert(Order o) {
		if (cnt >= datas.length - 1) {
			System.out.println("배열 참. 등록 취소");
			return;
		}
		datas[cnt] = o;
	}
	
	//주문 목록 (혜린님) 
	@Override
	public Order[] selectAll() {
		Order[] temp = new Order[cnt];
		System.arraycopy(datas, 0, temp, 0, cnt);
		System.out.println("주문 목록");
		for(Order a : temp) {
			if(a == null) continue;
			System.out.println(a.toString());
		}
		return temp;
	}

	//주문 번호로 하나 검색 (해영님)
	@Override
	public Order select(int order_num) {
		for(Order o : datas) {
			if(o ==null) continue;
			if(o.getOrder_num() == order_num) {	
				System.out.println(o.toString());
				return o;
			}
		}
		System.out.println("주문 번호 확인 불가합니다.");
		return null;
	}
	
	//주문취소. 결제완료시 취소 안됨 (찬식님)
	@Override
	public void delete(int order_num) {
		//전체 리스트를 가지고 와서 해당 인덱스로부터 앞으로 떙겨주면 끝
		Order order = this.select(order_num);
		int a = 0;
		if(order != null) {
			for(int i=0 ; i<cnt ; i++) {
				if(datas[i] == order && datas[i].isPay_result() == false) { //결제 완료시 체크
					a = i;
					break;
				}
			}
			//해당 인덱스부터 앞으로 땡기기
			for(int j=a ; j<cnt-1 ; j++) {
				//아직 결제를 안했으니 주문 취소 합니다.
				datas[j] = datas[j+1];
			}
			cnt--;
		}
		else {
			System.out.println("해당 번호를 가진 주문 건이 존재하지 않아 삭제할 수 없습니다.");
		}
	}
	
	//결제처리. 주문번호로 찾아서 pay_result를 true. (승연님)
	@Override
	public void update_pay(int order_num) {
		Order o = select(order_num);
		if (o != null) {
			o.setPay_result(true);
		}else {
			System.out.println("결제되지 않았습니다.");
		}
	}
	
	//결제대상. pay_result가 false인 것만 검색해서 반환 (소정님)
	@Override
	public Order[] selectByPayFalse() {
		Order[] temp = new Order[cnt];
		Order[] falseOnly = null;//반환예정 배열
		int c=0;//false인 개수
		for (int i=0; i<cnt; i++) {
			if(!datas[i].isPay_result()) {
				temp[c++]=datas[i];
			}
		}
		if(c!=0) {
			falseOnly = new Order[c];
			System.arraycopy(temp, 0, falseOnly, 0, c);
		}
		return falseOnly;
	}
	
	//출고대상. out_result가 false이고 pay_result가 true인 것만 검색해서 반환 (동관님)
	@Override
	public Order[] selectByOutFalse() {
		Order[] temp = new Order[cnt];
		boolean out_result = true;
		boolean pay_result = true;
		for(int i=0; i<cnt; i++) {
			if(out_result && pay_result) {
				System.out.println(temp+"출고되었습니다");
				delete(cnt);
			}else {
				System.out.println("출고되지 않았습니다.");
			}
		}
		return temp;
	}

}
