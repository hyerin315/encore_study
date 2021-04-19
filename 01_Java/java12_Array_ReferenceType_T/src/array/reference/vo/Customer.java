package array.reference.vo;
//Oulet Store에서 제품을 구입하는 고객의 정보를 담고 있는 클래스
public class Customer {
	private int ssn;
	private String name;
	private String address;
	//Has a Relation 추가
	private Product[] products;
	
	public Customer(int ssn, String name, String address) {
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public void buyProduct(Product[] products) {
		this.products = products;//이 부분이 setter의 기능이기 때문에 굳이 setProduct라고 안해도 됨
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Product[] getProducts() {
		return products;
	}
}
