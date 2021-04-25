package polymorphism;

public class TVUser {
	
	//2. 다형성 이용하기
	/* - 결합도를 낮추기 위해서 객체지향 언어의 핵심 개념인 다형성(Polymorphism)을 이용한다. 결합도 높은 위의 예제를 수정한다.
       - 다형성을 이용하려면 상속과 메소드 재정의(Overriding), 형변환이 필요하다.
    */

	public static void main(String[] args) {
		TV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
