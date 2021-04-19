package product_order;
import java.util.Scanner;

public interface OrderService {
	void addOrder(Scanner sc);//�ֹ�
	Order[] getAll();//�ֹ� ���
	void printAll();//�ֹ� ��� ���
	Order getOrder(Scanner sc);//�ֹ� ��ȣ�� �ϳ� �˻�
	void cancelOrder(Scanner sc);//�ֹ� ��� - ���� �Ϸ�� ��� �ȵ�
	void pay(Scanner sc);//����ó�� - �ֹ���ȣ�� ã�Ƽ� pay_result�� trueó��
	Order[] getByPayFalse();//������� - pay_result�� false�� �͸� �˻��ؼ� �迭�� ��� ��ȯ
	Order[] getByOutFalse();//����� - out_result�� false�� �͸� �˻��ؼ� ��ȯ
}
