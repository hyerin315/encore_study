package warehouse;

public interface Dao {
	void insert(Product p);//��ǰ ���
	Product selectByNum(int num);//��ȣ�� �˻� (��ȣ�� �ߺ����� ����) -> Product�� ��ȯ
	Product[] selectByName(String name);
	Product[] selectAll();
	void update(int num, int price);
	void delete(int num);
	void in_out(int num, int a);//a:����� ����
	
}
