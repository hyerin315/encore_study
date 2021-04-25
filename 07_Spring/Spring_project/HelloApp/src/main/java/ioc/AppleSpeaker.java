package ioc;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker {
	
	public AppleSpeaker() {
		System.out.println(">>>>>>> AppleSpeaker 객체 생성");
	}
	
	public void volumUp() {
		System.out.println("AppleSpeaker........소리를 올린다");
	}
	
	public void volumDown() {
		System.out.println("AppleSpeaker.........소리를 내린다");
	}

}
