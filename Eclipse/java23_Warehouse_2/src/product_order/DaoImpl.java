package product_order;

public class DaoImpl implements Dao {
	private Order[] datas;
	private int cnt;
	
	public DaoImpl() {
		datas = new Order[30];
	}

	//�ֹ� (�¿���)
	@Override
	public void insert(Order o) {
		if (cnt >= datas.length - 1) {
			System.out.println("�迭 ��. ��� ���");
			return;
		}
		datas[cnt] = o;
	}
	
	//�ֹ� ��� (������) 
	@Override
	public Order[] selectAll() {
		Order[] temp = new Order[cnt];
		System.arraycopy(datas, 0, temp, 0, cnt);
		System.out.println("�ֹ� ���");
		for(Order a : temp) {
			if(a == null) continue;
			System.out.println(a.toString());
		}
		return temp;
	}

	//�ֹ� ��ȣ�� �ϳ� �˻� (�ؿ���)
	@Override
	public Order select(int order_num) {
		for(Order o : datas) {
			if(o ==null) continue;
			if(o.getOrder_num() == order_num) {	
				System.out.println(o.toString());
				return o;
			}
		}
		System.out.println("�ֹ� ��ȣ Ȯ�� �Ұ��մϴ�.");
		return null;
	}
	
	//�ֹ����. �����Ϸ�� ��� �ȵ� (���Ĵ�)
	@Override
	public void delete(int order_num) {
		//��ü ����Ʈ�� ������ �ͼ� �ش� �ε����κ��� ������ �����ָ� ��
		Order order = this.select(order_num);
		int a = 0;
		if(order != null) {
			for(int i=0 ; i<cnt ; i++) {
				if(datas[i] == order && datas[i].isPay_result() == false) { //���� �Ϸ�� üũ
					a = i;
					break;
				}
			}
			//�ش� �ε������� ������ �����
			for(int j=a ; j<cnt-1 ; j++) {
				//���� ������ �������� �ֹ� ��� �մϴ�.
				datas[j] = datas[j+1];
			}
			cnt--;
		}
		else {
			System.out.println("�ش� ��ȣ�� ���� �ֹ� ���� �������� �ʾ� ������ �� �����ϴ�.");
		}
	}
	
	//����ó��. �ֹ���ȣ�� ã�Ƽ� pay_result�� true. (�¿���)
	@Override
	public void update_pay(int order_num) {
		Order o = select(order_num);
		if (o != null) {
			o.setPay_result(true);
		}else {
			System.out.println("�������� �ʾҽ��ϴ�.");
		}
	}
	
	//�������. pay_result�� false�� �͸� �˻��ؼ� ��ȯ (������)
	@Override
	public Order[] selectByPayFalse() {
		Order[] temp = new Order[cnt];
		Order[] falseOnly = null;//��ȯ���� �迭
		int c=0;//false�� ����
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
	
	//�����. out_result�� false�̰� pay_result�� true�� �͸� �˻��ؼ� ��ȯ (������)
	@Override
	public Order[] selectByOutFalse() {
		Order[] temp = new Order[cnt];
		boolean out_result = true;
		boolean pay_result = true;
		for(int i=0; i<cnt; i++) {
			if(out_result && pay_result) {
				System.out.println(temp+"���Ǿ����ϴ�");
				delete(cnt);
			}else {
				System.out.println("������ �ʾҽ��ϴ�.");
			}
		}
		return temp;
	}

}
