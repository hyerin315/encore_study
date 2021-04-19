package exam.test;
/*
 * final 키워드에 대해서 알아본다
 * final "내가 마지막 ~~이야"라는 뜻의 키워드
 * 
 * final 변수 - "내가 마지막 변수야" --> 마지막이니까 고치면 안된다 - 상수 지정
 * final 메소드 - "내가 마지막 메소드야" --> 자식들아 고치지마 - 오버라이딩 금지
 * final 클래스 - "내가 마지막 클래스야" --> 내가 마지막 클래스니까 자식 안둘거야 - 상속금지
 */

//1. final 지정
class A{
	//상수 final 지정
	final static int BASE_SALARY = 800;//값 변경이 안되는지 확인
	//메소드 final 지정
	public final String test() {
		return "Overriding 금지";//오버라이딩 안되는지 확인
	}
}
//클래스 final 지정
final class B{ //상속을 못함
}

//2. 동작 확인

//상수, 메소드 오버라이딩 x
class D extends A{
//	BASE_SALARY = 1000;//상수값 변경 못해!
//	public final String test() {//오버라이딩 아예 안되니까 쓰지마
	
}

//클래스 x
//class C extends B{//야 너 상속 못받는다 쟤가 마지막이래
//}

public class FinalExamTest {
	public static void main(String[] args) {
		//상수 변경도 x
		D d = new D();
		//D.BASE_SALARY = 1000;//새롭게 할당할 수 없다
		System.out.println("기본급 : "+d.BASE_SALARY);


	}

}
