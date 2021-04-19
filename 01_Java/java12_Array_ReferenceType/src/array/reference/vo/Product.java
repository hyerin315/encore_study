package array.reference.vo;
/*
 * ��ǰ�� ���� ������ �����ϴ� Ŭ����...
 */
public class Product {
	private String brand; //���� Ŭ���������� ������ ����ϴ� ���� ������ - private
	private int price;
	private int quantity;
	
	public Product(String brand, int price, int quantity) {
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getDetails() {
		return brand+", "+price+", "+quantity;
	}

	//1)~5)�� ���� ��� �߰�
	public String getBrand() {
		return brand;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}	
	

}

