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
			System.out.println("�迭 â. �ֹ���� ����");
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
		//�ֹ� ��ȣ�� �˻�
		for(i=0; i < cnt; i++) {
			if(orders[i].getOrder_num() == order_num) {
				break;//ã���� ���� ����
			}
		}
		if(i == cnt) {
			System.out.println("���� �ֹ� ��ȣ �Դϴ�.");
		} else {
			if(orders[i].isPay_result()) {
				System.out.println("�̹� ������ ��ǰ�� ��� �Ұ�");
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
			System.out.println("���� �ֹ���ȣ");
		} else {
			o.setPay_result(true);
		}
	}
	
	
	//������ ��� ó���� ���
	@Override
	public void update_out(int order_num) {
		Order o = select(order_num);
		if(o == null) {
			System.out.println("���� ��ǰ");
		} else {
			o.setOut_result(true);
		}
	}
	
	//������ ���� �ֹ���� ��ȯ
	@Override
	public Order[] selectByPayFalse() {
		Order[] o = new Order[cnt];
		Order dest[] = null;
		int c = 0;//�˻��� ��ü ī��Ʈ
		for(Order s : orders) {
			if(s.isPay_result()) {
				o[c++] = s;
			}
		}
		if(c==0) {
			System.out.println("���� ����� �����ϴ�.");
			return null;
		}
		dest = new Order[c];		
		System.arraycopy(o, 0, dest, 0, c);
		return dest;
	}

	//���忡�� ��� - ����� �Ѱ��ִ� ��(�¶��� �ֹ��� ���۰� ���� ����)
	@Override
	public Order[] selectByOutFalse() {
		Order[] o = new Order[cnt];
		Order[] dest = null;
		int c = 0;//�˻��� ��ü ī��Ʈ
		for(Order s : orders) {
			if(s.isPay_result() && s.isOut_result()) {
				o[c++] = s;
			}
		}
		if(c==0) {
			System.out.println("���� ����� �����ϴ�.");
			return null;
		}
		dest = new Order[c];		
		System.arraycopy(o, 0, dest, 0, c);
		return dest;
	}

	
	
}
