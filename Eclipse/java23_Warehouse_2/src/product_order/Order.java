package product_order;
import warehouse.Product;

//vo
//�ֹ���ȣ, ��ǰ��ȣ, ����, �����ݾ�, ��������, ������� 
public class Order {
	private int order_num;
	private Product prod;//�ֹ��� ��ǰ (���忡 ��ϵǾ� �ִ� ��ǰ �ֹ�)
	private int amount;//�ֹ�����
	private int pay;//���� �ݾ�
	private boolean pay_result;//�������� --> ���� ���ָ� �⺻������ false�� ó��
	private boolean out_result;//�������
	private static int cnt;
	
	public Order() {
	}
	public Order(int prod_num, int amount, Product p) {
		this.order_num = ++cnt;
		this.prod = p;
		this.amount = amount;
		this.pay = p.getPrice() * amount;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public boolean isPay_result() {
		return pay_result;
	}

	public void setPay_result(boolean pay_result) {
		this.pay_result = pay_result;
	}

	public boolean isOut_result() {
		return out_result;
	}

	public void setOut_result(boolean out_result) {
		this.out_result = out_result;
	}

	public static int getCnt() {
		return cnt;
	}

	public static void setCnt(int cnt) {
		Order.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Order [order_num=" + order_num + ", prod=" + prod + ", amount=" + amount + ", pay=" + pay
				+ ", pay_result=" + pay_result + ", out_result=" + out_result + "]";
	}
	
	
}
