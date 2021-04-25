package factory;

public class TVUser {
	
	//3. 디자인 패턴 - 팩토리 패턴
	/* - 결합도를 낮추는 또하나의 방법으로 디자인패턴을 이용한다.
	 * - TV를 교체할 때, 클라이언트 소스(TVUser.java)를 수정하지 않고 TV를 교체 한다면 유지보수는 더욱 편해진다.
	 * - Factory패턴을 적용하여, 클라이언트에서 사용할 객체 생성을 캡슐화하여 TVUser와 TV 사이를 느슨한 결합 상태로 만들어준다.
	 */

	public static void main(String[] args) {
		//Run configuration - Java appliction - 왼쪽 커서 - new configuration - 추가된 TVUser(2)
		// - Argument - 아래 박스에 samsung or lg 입력 -> String[] args에 들어갈 값을 입력해주는 것과 같음
		TV tv = BeanFactory.getBean(args[0]); //내가 원하는 객체(입력한 객체)를 생성해 주는 역할 = BeanFactory
		//args[0] : 내가 처음 입력한 값
		//args[1] : 띄어쓰기 한 다음 값 (2번째 값)
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}

}
