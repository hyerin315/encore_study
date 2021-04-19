package warehouse;
//이 프로그램에서 주로 다루는 객체를 정의 - vo(값 저장)
//클래스는 객체 "1개"를 담을 수 있게 정의 = 싱글톤(?)
public class Product {
	private int num;
	private String name;
	private int price;
	private int amount;
	private static int cnt;//모든 Product 객체가 공유 --> 등록되는 모든 제품 개수 카운트
	
	public Product() {
	}
	public Product(String name, int price, int amount) {//제품 등록 시에만 사용
		this.num = ++cnt;//번호 자동 할당
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
