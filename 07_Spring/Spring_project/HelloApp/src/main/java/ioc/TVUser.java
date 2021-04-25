package ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 4. 스프링 IoC를 이용
		/* - Ioc 컨테이너는 각 컨테이너에서 관리할 객체들를 위한 별도의 설정파일 사용한다.
		 * - src/main/resources 에 설정파일을 만들거나 자동으로 생성된다.
		 */
		
		// 1) Spring 컨테이너 구동한다 
		// - 스프링 컨테이너와 톰캣이 제공해주는 Servelet 컨테이너는 다름 
		//   (톰캣에서 제공하는 servelet - xml을 통해 객체를 생성해주는 방식과 비슷함)
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("META-INF/spring/app-context.xml");
		
		// 2) Spring 컨테이너로부터 필요한 객체를 요청(Lookup - 찾는 것)한다
		TV tv = (TV) factory.getBean("tv"); //오류나는 이유 : object 타입이기 때문 - 그래서 형변환 필요
		 										   //("samsungTV") 소문자로 쓰는 이유 : 암묵적인 약속, 우리가 아직 어노테이션만 달고 따로 
		                                           //                              명시를 안했기 때문에(@Component) 클래스 이름 중 첫 번째만 소문자로 해서 가져온다
		                                           //명시했으면 그대로 가져오면 됨
      //TV tv2 = (TV) factory.getBean("tv"); //getBean할 때 객체를 생성하지만, 싱글톤이기 때문에 똑같이 출력 / scope 설정을 하면 객체 두 개 생성
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3) Spring 컨테이너를 종료한다.
	    factory.close();
		
	}

}
