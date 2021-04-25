package ioc;

public class LgTV implements TV {
	
	private AppleSpeaker speaker;
	private int price;
	
	public void setSpeaker(AppleSpeaker speaker) {//setter : 멤버변수에 데이터를 담아주는 역할
		this.speaker = speaker;
		System.out.println(">>>>>>>> setSpeaker() 호출");
	}
	
	public void setPrice(int price) {
		this.price = price;
		System.out.println(">>>>>>>> setPrice() 호출");
	}

	public LgTV() {
		System.out.println(">>>>>>>> LgTV 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("LgTV........전원을 켠다 (가격:" + price + ")");
	}

	public void powerOff() {
		System.out.println("LgTV........전원을 끈다");
	}

	public void volumeUp() {
		speaker.volumUp();
	}

	public void volumeDown() {
		speaker.volumDown();
	}

}
