package warehouse;
//�� ���α׷����� �ַ� �ٷ�� ��ü�� ���� - vo(�� ����)
//Ŭ������ ��ü "1��"�� ���� �� �ְ� ���� = �̱���(?)
public class Product {
	private int num;
	private String name;
	private int price;
	private int amount;
	private static int cnt;//��� Product ��ü�� ���� --> ��ϵǴ� ��� ��ǰ ���� ī��Ʈ
	
	public Product() {
	}
	public Product(String name, int price, int amount) {//��ǰ ��� �ÿ��� ���
		this.num = ++cnt;//��ȣ �ڵ� �Ҵ�
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
	
}
