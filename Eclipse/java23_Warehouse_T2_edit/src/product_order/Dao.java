package product_order;
//�ֹ�, �ֹ����, �ֹ����, ����, ����� ���
public interface Dao {
	void insert(Order o);//�ֹ�
	Order[] selectAll();//�ֹ� ���
	Order select(int order_num);//�ֹ� ��ȣ�� �ϳ� �˻�
	void delete(int order_num);//�ֹ� ��� - ���� �Ϸ�� ��� �ȵ�
	void update(int order_num);//����ó�� - �ֹ���ȣ�� ã�Ƽ� pay_result�� trueó��
	Order[] selectByPayFalse();//������� - pay_result�� false�� �͸� �˻��ؼ� �迭�� ��� ��ȯ
	Order[] selectByOutFalse();//����� - out_result�� false�̰� pay_result�� true�� �͸� �˻��ؼ� ��ȯ
}
