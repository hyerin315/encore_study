package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV {
	
	@Autowired
	@Qualifier("apple") // Apple의 형태가 다양할 때 내가 원하는 것만 갖다 쓸 때, 내가 선언한 apple만 갖다 쓰겠다 (DI가 중복되어서 쓰일때)
	//@Resource - @Autowired + @Qualifier 같음
	private AppleSpeaker speaker; //매게변수 생성
	//@Qualifier("samsung") - 컬리파이어 여러개 쓸 때 이런 형식
	//private AppleSpeaker speaker2;
	private int price;
	
	public void initMethod() {
		System.out.println("객체 초기화 작업");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전, 처리할 작업");
	}
	
	public SamsungTV() {
		System.out.println(">>>>>>>> SamsungTV 객체 생성");
	}
	
	public SamsungTV(AppleSpeaker speaker, int price) {//매개변수 2개
		System.out.println(">>>>>>> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}

	public void powerOn() {
		System.out.println("Samsung........전원을 켠다 (가격:"+ price + ")");
	}

	public void powerOff() {
		System.out.println("Samsung........전원을 끈다");
	}

	public void volumeUp() {
		speaker.volumUp();
	}

	public void volumeDown() {
		speaker.volumDown();
	}
	
}
