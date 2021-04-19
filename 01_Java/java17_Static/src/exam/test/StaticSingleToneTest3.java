package exam.test;
/*
 * 싱글톤
 * ::
 * 하나의 클래스로부터 오직 단 하나의 객체만 생성되도록 작성하는 코드
 * ::
 * 작성방법
 * 1. 클래스 안에서 일단 하나의 객체는 생성해 놓는다 --> private static으로 지정해서 생성함
 * 2. 다른 클래스에서는 객체생성을 못하도록 막아놓는다 --> private 생성자() 
 *    --> 객체 생성을 사적으로 한다 == 내 클래스 말고는 객체 생성 못한다
 * 3. 하나 만들어놓은 객체를 여기저기서 가져다 쓰도록 pubilc한 기능을 만든다 -- public ?
 */

class Service{
	private static Service service = new Service();
	private Service() {
		System.out.println("Server Instance Creating...Using SingleTone...");
	}
	public static Service getInstance() {//3. --> 이거 자체가 리턴 타입이 되는 것
		return service;
	}
}

public class StaticSingleToneTest3 {
	public static void main(String[] args) {
  		//Service s1 = new Service(); 다른 클래스에서 쓰지 못함
		// 만들어 놓은 것을 받아서 사용하는 방법밖에는 없다 --> 하지만 사용하려면 메모리에 올려야함 --> 그게 막혀져 있음
		//그래서 싱글톤 클래스 리턴타입만들 때 public static으로 만들어 미리 메모리에 올려놔야함
		
		Service service1 = Service.getInstance();//객체 생성 없이 위에서 만들어놓은 이 친구들을 가져올 수 있음
		Service service2 = Service.getInstance();
		Service service3 = Service.getInstance();
		
		System.out.println(service1);//싱글 톤으로 모두 같은 값 반환
		System.out.println(service2);
		System.out.println(service3);
	}
}
