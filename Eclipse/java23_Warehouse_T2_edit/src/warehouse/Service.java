package warehouse;
import java.util.Scanner;

import product_order.Order;

//��� ��

public interface Service {
	void addProduct(Scanner sc);//���
	Product getByNum(int num);//��ȣ�� �˻�
	void printProductByNum(Scanner sc);
	void getByName(Scanner sc);//�̸����� �˻�
	void editProduct(Scanner sc);//���� ����
	void delProduct(Scanner sc);//����
	Product[] getAll();//��ü�˻�
	void printAll();
	void inProduct(Scanner sc);//�԰�
	void outProduct(Order[] orders);//���
	
}
