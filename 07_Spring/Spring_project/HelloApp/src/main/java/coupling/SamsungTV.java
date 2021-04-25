package coupling;

public class SamsungTV {//기본생성자는 기본으로 생성되니까 따로 안만들어줘도 됨
	private int price;//캡슐화 된 멤버변수
	
	public void setPrice(int price) {//캡슐화 된 멤버변수에 접근하기 위해 setter를 사용
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV.........전원을 켠다");
		System.out.println("price :" + price);
	}
	
	public void powerOff() {
		System.out.println("SamsungTV.........전원을 끈다");
	}
	
	public void volumeUp() {
		System.out.println("SamsungTV.........소리를 올린다");
	}
	
	public void volumeDown() {
		System.out.println("SamsungTV..........소리를 내린다");
	}
}
