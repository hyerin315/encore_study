package polymorphism;

public class SamsungTV implements TV {

	public void powerOn() {
		System.out.println("Samsung........전원을 켠다");
	}

	public void powerOff() {
		System.out.println("Samsung........전원을 끈다");
	}

	public void volumeUp() {
		System.out.println("Samsung........소리를 올린다");
	}

	public void volumeDown() {
		System.out.println("Samsung........소리를 내린다");
	}
	
}
