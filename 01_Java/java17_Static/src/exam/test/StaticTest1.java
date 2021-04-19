package exam.test;
//Static한 멤버는 객체생성 과정없이 사용할 수 있다
//== Static한 멤버는 클래스파일 로더 과정에서 이미 메모리가 올라가 있다
//== 클래스명.static한 멤버

//멤버 클래스
class Member{
	static String name = "강동원";//static V, class V, 전역변수 (셋 중 하나의 이름으로 부름)
	static int age = 22;
	int count = 1;//filed, 멤버변수
	
	public static void getMember1() {//Static Method
		System.out.println("우/유/빛/깔/"+name);
	}
	
	public void getMember2() {//Non-Static Method
		System.out.println("우/유/빛/깔/");//error --> static으로 안올라가 있어서 못씀
	}
}

//멤버 테스트 클래스
public class StaticTest1 {
	public static void main(String[] args) {
		//Static이기 때문에 객체 생성 없이 바로 올라가니까 이렇게 해도 바로 사용 가능
		Member.getMember1();
		
		//Non-Static이기 때문에 객체 생성으로 메모리에 직접 올려놓고 사용한다
		Member m = new Member();//객체생성과 동시에 다 만들어지기 때문에 == 메모리에 올라가기 때문에
		m.getMember2();//여기서 getMember2를 사용할 수 있음

	}

}
