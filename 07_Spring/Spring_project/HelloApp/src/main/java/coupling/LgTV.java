package coupling;

public class LgTV {
	private String id;
	
	public LgTV() {}
	
	public LgTV(String id) {
		this.id = id;
	}
	
	public void turnOn() {
		System.out.println("LgTV.........전원을 켠다");
		System.out.println("id :" + id);
	}
	public void turnOff() {
		System.out.println("LgTV.........전원을 끈다");
	}
	public void soundUp() {
		System.out.println("LgTV.........소리를 올린다");
	}
	public void soundDown() {
		System.out.println("LgTV..........소리를 내린다");
	}
}
