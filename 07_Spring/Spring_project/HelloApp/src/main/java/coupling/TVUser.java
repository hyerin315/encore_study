package coupling;

public class TVUser {
	
	//1. 결합도가 높은 프로그램 예제
	/* - 결합도란 하나의 클래스가 다른 클래스와 얼마나 많이 연결되어 있는지를 나타내는 표현이며, 결합도가 높은 프로그램은 유지보수가 어렵다.
       - SamsungTV와 LgTV의 시청에 필요한 필수 기능 네개가 있다.
       - TVUser 클래스에서 두개 TV클래스를 사용하면 두 클래스의 메소드 원형이 다르기 때문에 
         TV 교체시 다변경해야 하므로 유지보수가 힘들어 지고, TV교체를 결정하기 쉽지 않다. */
	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		tv.setPrice(10000000);
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		LgTV tv2 = new LgTV("lg"); //객체를 생성하면서 멤버 변수를 담는 방식
		tv2.turnOn();
		tv2.turnOff();
		tv2.soundUp();
		tv2.soundDown();
	}
}
